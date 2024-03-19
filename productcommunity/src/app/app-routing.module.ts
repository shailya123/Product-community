import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AdminreviewComponent } from './adminreview/adminreview.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SearchResultComponent } from './search-result/search-result.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'loginuser', component: LoginComponent },
  { path: 'registeruser', component: RegisterComponent },
  { path: 'homepage', component: HomePageComponent },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'productsearch', component: SearchResultComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'adminreview', component: AdminreviewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
