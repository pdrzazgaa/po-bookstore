import { EventEmitter, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable, of } from 'rxjs';

@Injectable()
export class AuthorizationService {
  private http: HttpClient;
  private baseUrl: string = 'http://localhost:6060/verify';
  private isLogged: boolean = false;
  isLoggedInChanged = new EventEmitter<{ loggedIn: boolean }>();

  constructor(http: HttpClient) {
    this.http = http;
    this.isLogged = localStorage.getItem('userId') ? true : false;
  }

  private verify(username: string, password: string): Observable<any> {
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
        }
        return this.isLoggedIn();
      })
    );
  }

  isLoggedIn(): boolean {
    return this.isLogged;
  }

  logout() {
    localStorage.removeItem('userId');
    this.isLoggedInChanged.emit({ loggedIn: false });
  }
}
