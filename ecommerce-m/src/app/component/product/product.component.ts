import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product/product.model';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[] = [];
  constructor(private productService: ProductService,) { }

  ngOnInit(): void {
    this.geProducts();
  }

  geProducts(): void {
    this.productService.getProducts()
    .subscribe(products => this.products = products);
  }

}
