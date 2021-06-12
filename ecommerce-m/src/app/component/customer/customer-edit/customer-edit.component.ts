import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user/user.model';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  id: number = 0;
  user: User | undefined;
  editForm;
 
  constructor(
    public customerService: CustomerService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.editForm = this.formBuilder.group({
      id: ['', Validators.required],
      name: ['', Validators.required],
      status: [''],
      amount: ['', Validators.min(0)]
    });
  }
 
  ngOnInit(): void {
    this.id = this.route.snapshot.params['customerId'];
 
    this.customerService.get(this.id).subscribe((data: User) => {
      this.user = data;
      this.editForm.patchValue(data);
    });
  }
 
  onSubmit(formData: any) {
    this.customerService.update(this.id, formData.value).subscribe(res => {
      this.router.navigateByUrl('customer');
    });
  }
}
