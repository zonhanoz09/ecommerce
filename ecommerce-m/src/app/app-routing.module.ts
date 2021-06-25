import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { ProductComponent } from './component/product/product.component';
import { CustomerComponent } from './component/customer/customer.component';
import { CustomerCreateComponent } from './component/customer/customer-create/customer-create.component';
import { CustomerDetailComponent } from './component/customer/customer-detail/customer-detail.component';
import { CustomerEditComponent } from './component/customer/customer-edit/customer-edit.component';
import { Role } from './models/role';
import { AuthGuard } from './helpers/auth.guard';

const routes: Routes = [
  {
      path: '',
      component: DashboardComponent,
      canActivate: [AuthGuard]
  },
  { path: 'customer', component: CustomerComponent ,canActivate: [AuthGuard] },
  { path: 'customer/:customerId/details', component: CustomerDetailComponent,canActivate: [AuthGuard] },
  { path: 'customer/create', component: CustomerCreateComponent,canActivate: [AuthGuard] },
  { path: 'customer/:customerId/edit', component: CustomerEditComponent,canActivate: [AuthGuard] },
  {
      path: 'dashboard',
      component: DashboardComponent,
      canActivate: [AuthGuard]
      // data: { roles: [Role.ADMIN] }
  },
  {
      path: 'login',
      component: LoginComponent
  },

  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}