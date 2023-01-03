import { Injectable } from '@angular/core';
import { User } from '../models';

@Injectable()
export class UserService {
  private user?: User;

  getUser() {
    return this.user;
  }
}
