import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthorizationService } from 'src/app/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss'],
})
export class LoginPageComponent implements OnInit, OnDestroy {
  retUrl: string = '/';
  private authorizationService: AuthorizationService;
  private router: Router;
  private activatedRoute: ActivatedRoute;
  private routeSub?: Subscription;
  incorrectData: boolean = false;

  public loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(20),
    ]),
  });

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
    if (this.authorizationService.isLoggedIn()) {
      this.router.navigate(['/']);
    } else {
      this.routeSub = this.activatedRoute.queryParamMap.subscribe((params) => {
        this.retUrl = params.get('retUrl')!;
      });
    }
  }

  onFormSubmit() {
    this.authorizationService
      .login(
        this.loginForm.controls.email.value!,
        this.loginForm.controls.password.value!
      )
      .subscribe((res) => {
        if (res) {
          if (this.retUrl != null) {
            this.router.navigate([this.retUrl]);
          } else {
            this.router.navigate(['']);
          }
        } else {
          this.incorrectData = true;
        }
      });
  }

  isEmailInvalid() {
    const emailControl = this.loginForm.controls.email;
    return !emailControl.valid && (emailControl.dirty || emailControl.touched);
  }

  isPasswordInvalid() {
    const passwordControl = this.loginForm.controls.password;
    return !passwordControl.valid && (passwordControl.dirty || passwordControl.touched);
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }
}
