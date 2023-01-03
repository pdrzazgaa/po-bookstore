import { EventEmitter, Injectable } from '@angular/core';
import { AuthorizationService } from './authorization.service';
import { User } from '../models';

@Injectable()
export class UserService {
  private user?: User | null;
  private authorizationService: AuthorizationService;
  loyaltyProgram = new EventEmitter<{ isInLoyaltyProgram: boolean }>();

  constructor(authorizationService: AuthorizationService) {
    this.authorizationService = authorizationService;
    if (this.authorizationService.isLoggedIn()) {
      this.user = new User([], false, 'Adam', 'Nowak');
    }
    this.authorizationService.isLoggedInChanged.subscribe(({ loggedIn }) => {
      if (loggedIn) {
        this.user = new User([], false, 'Adam', 'Nowak');
      } else {
        this.clearUser();
      }
    });
  }

  isInLoyaltyProgram() {
    return this.user?.inLoyaltyProgram || false;
  }

  joinLoyaltyProgram() {
    if (this.user) {
      this.user.inLoyaltyProgram = true;
      this.user.bookcoins = 0;
    }
    this.loyaltyProgram.emit({ isInLoyaltyProgram: true });
  }

  getBookcoins() {
    return this.user?.bookcoins || 0;
  }

  clearUser() {
    this.user = null;
    this.loyaltyProgram.emit({ isInLoyaltyProgram: false });
  }
}
