import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  createForm;
  hide = true;
  hider = true;
  color : String;

  constructor(
    public customerService: CustomerService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.createForm = this.formBuilder.group({
      username: ['', Validators.required],
      amount: ['', Validators.min(0)],
      password: ['', Validators.required],
      repassword: [''],
      role: [''],
    },{ validators: this.checkPasswords });


  }

  checkPasswords(group: FormGroup) { // here we have the 'passwords' group
    const password = group.get('password').value;
    const confirmPassword = group.get('repassword').value;
    return password === confirmPassword ? null : { notSame: true }
  }

  changeRole ()
  {
    switch (this.createForm.get('role').value) {
      case 'ADMIN':
        this.color = 'primary';
        break;
      case 'USER':
        this.color = 'accent';
        break;
      case 'SUPER':
        this.color = 'warn';
        break;
      default:
    }
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.createForm.value);
    this.customerService.create(this.createForm.value).subscribe(res => {
      this.router.navigateByUrl('customer');
    });
  }

}
