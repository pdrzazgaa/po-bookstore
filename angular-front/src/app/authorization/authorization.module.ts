import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthorizationRoutingModule } from './authorization-routing.module';
import { LoginPageComponent } from './login-page/login-page.component';


@NgModule({
  declarations: [
    LoginPageComponent
  ],
  imports: [
    CommonModule,
    AuthorizationRoutingModule
  ]
})
export class AuthorizationModule { }
