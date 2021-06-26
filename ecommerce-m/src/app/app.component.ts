import { Component } from '@angular/core';
import { User } from '../app/models/user';
import { Role } from '../app/models/role';
import { Router } from '@angular/router';
import { AuthenticationService } from '../app/services/authentication.service';
import { map,  } from 'rxjs/operators';
import { observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'ecommerce-m';

  toggle: boolean = false;
  clickEventToggle(){
      this.toggle = !this.toggle;       
  }

  currentUser?: User;

  constructor(
      private router: Router,
      private authenticationService: AuthenticationService
  ) {
      this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
  }

  get isAdmin() {
      return this.currentUser &&  this.currentUser?.role.find(x => x.authority == Role.ADMIN);
  }

  logout() {
      this.authenticationService.logout();
      this.router.navigate(['/login']);
  }
}


