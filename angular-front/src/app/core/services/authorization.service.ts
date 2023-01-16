import { EventEmitter, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { of } from 'rxjs';

@Injectable()
export class AuthorizationService {
  private http: HttpClient;
  private baseUrl: string = 'http://localhost:6060/verify';
  isLoggedInChanged = new EventEmitter<{ loggedIn: boolean }>();

  constructor(http: HttpClient) {
    this.http = http;
  }

  login(username: string, password: string) {
    const headers = { 'content-type': 'application/json' };
    this.http
      .post(this.baseUrl, JSON.stringify({ email: username, password: password }), {
        headers: headers,
      })
      .subscribe((res: any) => {
        if (res.id > 0) {
          this.isLoggedInChanged.emit({ loggedIn: true });
          localStorage.setItem('userId', `${res.id}`);
        }
      });
    return of(this.isLoggedIn());
  }

  isLoggedIn(): boolean {
    if (localStorage.getItem('userId')) {
      return true;
    } else return false;
  }

  logout() {
    localStorage.removeItem('userId');
    this.isLoggedInChanged.emit({ loggedIn: false });
  }
}
