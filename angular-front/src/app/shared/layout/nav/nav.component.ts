import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from 'src/app/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss'],
})
export class NavComponent implements OnInit {
  private authorizationService: AuthorizationService;
  isLoggedIn: boolean = false;

  constructor(authorizationService: AuthorizationService) {
    this.authorizationService = authorizationService;
  }

  ngOnInit(): void {
    this.isLoggedIn = this.authorizationService.getIsLoggedIn();
  }
}
