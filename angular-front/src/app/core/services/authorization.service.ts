import { EventEmitter, Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AuthorizationService {
  private http: HttpClient;
  private baseUrl: string = 'http://localhost:6060/verify';
  private isLogged: boolean = false;
  private userId: number = -1;
  isLoggedInChanged = new EventEmitter<{ loggedIn: boolean }>();

  constructor(http: HttpClient) {
    this.http = http;
    this.isLogged = localStorage.getItem('userId') ? true : false;
    if (this.isLogged) {
      this.userId = +localStorage.getItem('userId')!;
    }
  }

  verify(username: string, password: string): Observable<any> {
    const headers = { 'content-type': 'application/json' };
    return this.http.post(
      this.baseUrl,
      JSON.stringify({ email: username, password: password }),
      {
        headers: headers,
      }
    );
  }

  login(username: string, password: string) {
    return this.verify(username, password).pipe(
      map((res: any) => {
        if (res.id > 0) {
          this.isLogged = true;
          localStorage.setItem('userId', `${res.id}`);
          this.userId = res.id;
          this.isLoggedInChanged.emit({ loggedIn: true });
        }
        return this.isLoggedIn();
      })
    );
  }

  getUserId() {
    return this.userId;
  }

  isLoggedIn(): boolean {
    return this.isLogged;
  }

  logout() {
    localStorage.removeItem('userId');
    this.isLogged = false;
    this.isLoggedInChanged.emit({ loggedIn: false });
  }
}
