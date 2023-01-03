import { ActivatedRouteSnapshot, CanActivate, Router, UrlTree } from '@angular/router';
import { AuthorizationService } from './';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthorizationGuardService implements CanActivate {
  private router: Router;
  private authorizationService: AuthorizationService;
  constructor(router: Router, authorizationService: AuthorizationService) {
    this.router = router;
    this.authorizationService = authorizationService;
  }

  canActivate(route: ActivatedRouteSnapshot): boolean | UrlTree {
    if (!this.authorizationService.isLoggedIn()) {
      this.router.navigate(['log-in'], { queryParams: { retUrl: route.url } });
      return false;
    }
    return true;
  }
}
