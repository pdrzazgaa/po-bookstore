import { Component, OnDestroy, OnInit } from '@angular/core';
import { AuthorizationService } from 'src/app/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss'],
})
export class NavComponent implements OnInit, OnDestroy {
  private authorizationService: AuthorizationService;
  private router: Router;
  isLoggedIn: boolean = false;
  private isLoggedInSub?: Subscription;

  constructor(authorizationService: AuthorizationService, router: Router) {
    this.authorizationService = authorizationService;
    this.router = router;
  }

  ngOnInit(): void {
    this.isLoggedIn = this.authorizationService.isLoggedIn();
    this.isLoggedInSub = this.authorizationService.isLoggedInChanged.subscribe(
      ({ loggedIn }) => {
        this.isLoggedIn = loggedIn;
      }
    );
  }

  onLogoutClick() {
    this.authorizationService.logout();
    this.router.navigate(['/']);
  }

  ngOnDestroy(): void {
    this.isLoggedInSub?.unsubscribe();
  }
}
