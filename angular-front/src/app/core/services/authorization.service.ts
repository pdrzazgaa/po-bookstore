import { EventEmitter, Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable()
export class AuthorizationService {
  private isloggedIn: boolean = true;
  isLoggedInChanged = new EventEmitter<{ loggedIn: boolean }>();

  login(username: string, password: string) {
    console.log(username, password);
    this.isloggedIn = true;
    this.isLoggedInChanged.emit({ loggedIn: true });
    return of(this.isLoggedIn());
  }

  isLoggedIn(): boolean {
    return this.isloggedIn;
  }

  logout() {
    this.isloggedIn = false;
    this.isLoggedInChanged.emit({ loggedIn: false });
  }
}
