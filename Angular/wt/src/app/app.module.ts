import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
<<<<<<< HEAD
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ButtonComponent } from './components/button/button.component';
=======
import { NewSeriesFormComponent } from './components/new-series-form/new-series-form.component';
import { ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
>>>>>>> brian

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    LoginComponent,
    NavbarComponent,
    ButtonComponent
=======
    NewSeriesFormComponent
>>>>>>> brian
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
