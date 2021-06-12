import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user/user.model';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  users: User[] = [];

  currentProduct = new Object();
  currentIndex = -1;
  name = '';

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers(): void {
    this.customerService.getAll()
      .subscribe(users => this.users = users);
  }

  deleteCustomer(id: number) {
    this.customerService.delete(id).subscribe(() => {
      this.users = this.users.filter(item => item.id !== id);
    });
  }

}
