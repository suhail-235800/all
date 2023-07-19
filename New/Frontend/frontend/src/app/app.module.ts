import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { NavbarfComponent } from './navbarf/navbarf.component';
import { UserhomeComponent } from './userhome/userhome.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingpageComponent,
    NavbarfComponent,
    UserhomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
