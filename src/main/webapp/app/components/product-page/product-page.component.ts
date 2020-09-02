import { Component, OnInit } from '@angular/core';
import { Product } from 'app/shared/model/product.model';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { ProductService } from 'app/entities/product/product.service';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'jhi-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.scss']
})
export class ProductPageComponent implements OnInit {
  product: any;
  id!: string;

  constructor(private route: ActivatedRoute, private productService: ProductService, private router: Router) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => (this.id = params['id']));
    this.productService
      .find(this.id)
      .toPromise()
      .then((res: HttpResponse<Product>) => this.bindData(res.body));
  }

  bindData(data: any) {
    this.product = data;
  }
}
