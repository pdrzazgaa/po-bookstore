import { AuthorizationRoutingModule } from './authorization-routing.module';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { LoginPageComponent } from './login-page/login-page.component';
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [LoginPageComponent],
  imports: [CommonModule, AuthorizationRoutingModule, FormsModule],
  exports: [LoginPageComponent],
})
export class AuthorizationModule {}
