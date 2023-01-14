import { Address, User } from '../models';
import { EventEmitter, Injectable } from '@angular/core';
import { AuthorizationService } from './authorization.service';

@Injectable()
export class UserService {
  private user?: User | null;
  private authorizationService: AuthorizationService;
  loyaltyProgram = new EventEmitter<{ isInLoyaltyProgram: boolean }>();

  constructor(authorizationService: AuthorizationService) {
    this.authorizationService = authorizationService;
    if (this.authorizationService.isLoggedIn()) {
      this.user = new User(
        1,
        'Anna',
        'Nowak',
        'anna.nowak@gmail.com',
        '+48 518 999 134',
        new Address('Tadeusza Kościuszki', 14, 'Wrocław', '50-430', 'Poland')
      );
    }
    this.authorizationService.isLoggedInChanged.subscribe(({ loggedIn }) => {
      if (loggedIn) {
        this.user = new User(
          1,
          'Anna',
          'Nowak',
          'anna.nowak@gmail.com',
          '+48 518 999 134',
          new Address('Tadeusza Kościuszki', 14, 'Wrocław', '50-430', 'Poland')
        );
      } else {
        this.clearUser();
      }
    });
  }

  isInLoyaltyProgram() {
    return false;
  }
  joinLoyaltyProgram() {
    this.loyaltyProgram.emit({ isInLoyaltyProgram: true });
  }

  getBookcoins() {
    return 0;
  }

  getUserId() {
    return this.user?.id;
  }

  clearUser() {
    this.user = null;
    this.loyaltyProgram.emit({ isInLoyaltyProgram: false });
  }

  getUserData() {
    return this.user;
  }
}
