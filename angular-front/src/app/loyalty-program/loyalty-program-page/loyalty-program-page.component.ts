import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { UserService } from 'src/app/core';

@Component({
  selector: 'app-loyalty-program-page',
  templateUrl: './loyalty-program-page.component.html',
  styleUrls: ['./loyalty-program-page.component.scss'],
})
export class LoyaltyProgramPageComponent implements OnInit, OnDestroy {
  private userService: UserService;
  inLoyaltyProgram: boolean = false;
  bookcoins: number = 0;
  private loyaltyProgramSub?: Subscription;

  constructor(userService: UserService) {
    this.userService = userService;
  }

  ngOnInit(): void {
    this.inLoyaltyProgram = this.userService.isInLoyaltyProgram();
    if (this.inLoyaltyProgram) {
      this.bookcoins = this.userService.getBookcoins();
    }
    this.loyaltyProgramSub = this.userService.loyaltyProgram.subscribe(
      ({ isInLoyaltyProgram }) => {
        this.inLoyaltyProgram = isInLoyaltyProgram;
      }
    );
  }

  onJoinButtonClick() {
    this.userService.joinLoyaltyProgram();
  }

  ngOnDestroy(): void {
    this.loyaltyProgramSub?.unsubscribe();
  }
}
