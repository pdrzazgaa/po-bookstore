import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthorizationService } from 'src/app/core';

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
    this.activatedRoute.queryParamMap.subscribe((params) => {
      this.retUrl = params.get('retUrl')!;
      console.log('LoginComponent/ngOnInit ' + this.retUrl);
    });
  }

  onFormSubmit() {
    this.authorizationService
      .login(
        this.loginForm.controls.email.value!,
        this.loginForm.controls.password.value!
      )
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

  isEmailInvalid() {
    const emailControl = this.loginForm.controls.email;
    return !emailControl.valid && (emailControl.dirty || emailControl.touched);
  }

  isPasswordInvalid() {
    const passwordControl = this.loginForm.controls.password;
    return !passwordControl.valid && (passwordControl.dirty || passwordControl.touched);
  }
}
