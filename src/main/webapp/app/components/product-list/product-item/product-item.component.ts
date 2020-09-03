import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../../../shared/model/product.model';
@Component({
  selector: 'jhi-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.scss']
})
export class ProductItemComponent implements OnInit {
  @Input() product: Product | undefined;

  constructor() {}

  ngOnInit() {}
}