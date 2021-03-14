import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent} from './auth/login-page/login-page.component';
import { RegisterPageComponent} from './auth/register-page/register-page.component';
import { HomePageComponent} from './home/home-page/home-page.component';
import { WeatherWidgetComponent} from './home/weather-widget/weather-widget.component';

const routes: Routes = [
  { path: 'login', component: LoginPageComponent },
  { path: 'register', component: RegisterPageComponent},
  { path: 'home/:_id', component: HomePageComponent},
  { path: 'weather/:_id', component: WeatherWidgetComponent},
  { path: '', pathMatch: 'full', redirectTo: 'login' }
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
