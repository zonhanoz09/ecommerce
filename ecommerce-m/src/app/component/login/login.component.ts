import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { User } from '../../models/user/user.model';
import { LoginService } from '../../services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users: User[] = [];

  constructor(private heroService: LoginService, private router: Router) {}

  ngOnInit(): void {
  }

  getUsers(): void {
    this.heroService.getUsers()
    .subscribe(users => this.users = users);
  }

  add(username: string,password: string): void {
    username = username.trim();
    password = password.trim();
    if (!username) { return; }
    this.heroService.login({ username, password } as User)
      .subscribe(user => {
        if(user)
        {
          this.router.navigate(['']);
        }
      });
  }
}
