import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  createForm;
  constructor(
    public customerService: CustomerService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.createForm = this.formBuilder.group({
      username: ['', Validators.required],
      name: ['', Validators.required],
      status: [''],
      amount: ['', Validators.min(0)],
      password: ['']
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.customerService.create(this.createForm.value).subscribe(res => {
      this.router.navigateByUrl('customer');
    });
  }

}
