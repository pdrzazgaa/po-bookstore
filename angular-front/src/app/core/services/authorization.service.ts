import { Injectable } from '@angular/core';

@Injectable()
export class AuthorizationService {
  private isLoggedIn: boolean = false;

  getIsLoggedIn() {
    return this.isLoggedIn;
  }
}
