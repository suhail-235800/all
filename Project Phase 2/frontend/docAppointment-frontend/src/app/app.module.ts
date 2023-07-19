import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { LandingComponent } from './landing/landing.component';
import { LoginComponent } from './login/login.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { RatingComponent } from './rating/rating.component';
import { UserbodyComponent } from './userbody/userbody.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { RatingbodyComponent } from './ratingbody/ratingbody.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ServicesComponent } from './services/services.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AdminbodyComponent } from './adminbody/adminbody.component';
import { RatingdialogComponent } from './ratingdialog/ratingdialog.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    LandingComponent,
    LoginComponent,
    UserhomeComponent,
    RatingComponent,
    UserbodyComponent,
    RegisterComponent,
    RatingbodyComponent,
    AboutusComponent,
    ServicesComponent,
    AdminhomeComponent,
    AdminbodyComponent,
    RatingdialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
