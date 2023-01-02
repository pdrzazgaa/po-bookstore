import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page';
import { NgModule } from '@angular/core';

const routes: Routes = [{ path: 'log-in', component: LoginPageComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthorizationRoutingModule {}
