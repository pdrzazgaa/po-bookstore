import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FooterComponent } from './shared/layout/footer/footer.component';
import { NavComponent } from './shared/layout/nav/nav.component';
import { PageNotFoundComponent } from './shared/layout/page-not-found/page-not-found.component';
import { MessagePopupComponent } from './shared/layout/message-popup/message-popup.component';
import { ParcelMachineFormComponent } from './shared/layout/parcel-machine-form/parcel-machine-form.component';


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavComponent,
    PageNotFoundComponent,
    MessagePopupComponent,
    ParcelMachineFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
