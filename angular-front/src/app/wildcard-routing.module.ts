import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { PageNotFoundComponent } from './shared/layout/page-not-found/page-not-found.component';

const routes: Routes = [{ path: '**', component: PageNotFoundComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class WildcardRoutingModule {}
