import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { User } from 'src/app/models/user/user.model';
import { CustomerService } from 'src/app/services/customer/customer.service';

import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit, AfterViewInit  {

  displayedColumns: string[] = ['id', 'username', 'amount', 'symbol'];
  dataSource = new MatTableDataSource<User>();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.getCustomers();
  }

  getRecord(name)
  {
    alert(name);
  }

  getCustomers(): void {
    this.customerService.getAll()
      .subscribe(
        users => {
          this.dataSource.data = users;
        }
      );
  }

  deleteCustomer(id: number) {
    this.customerService.delete(id).subscribe(() => {
      //this.users = this.users.filter(item => item.id !== id);
    });
  }

}
