import { EventEmitter, Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable()
export class AuthorizationService {
  isLoggedInChanged = new EventEmitter<{ loggedIn: boolean }>();

  login(username: string, password: string) {
    console.log(username, password);
    localStorage.setItem('userId', '1');
    this.isLoggedInChanged.emit({ loggedIn: true });
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
