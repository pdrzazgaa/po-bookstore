import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AuthorizationService } from 'src/app/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss'],
})
export class LoginPageComponent implements OnInit {
  retUrl: string = '/';
  private authorizationService: AuthorizationService;
  private router: Router;
  private activatedRoute: ActivatedRoute;

  constructor(
    authorizationService: AuthorizationService,
    router: Router,
    activatedRoute: ActivatedRoute
  ) {
    this.authorizationService = authorizationService;
    this.router = router;
    this.activatedRoute = activatedRoute;
  }

  ngOnInit(): void {
    this.activatedRoute.queryParamMap.subscribe((params) => {
      this.retUrl = params.get('retUrl')!;
      console.log('LoginComponent/ngOnInit ' + this.retUrl);
    });
  }

  onFormSubmit(loginForm: NgForm) {
    this.authorizationService
      .login(loginForm.value.username, loginForm.value.password)
      .subscribe((data) => {
        console.log(data);
        console.log('return to ' + this.retUrl);
        if (this.retUrl != null) {
          this.router.navigate([this.retUrl]);
        } else {
          this.router.navigate(['']);
        }
      });
  }
}
