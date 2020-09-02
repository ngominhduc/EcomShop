import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProductListComponent } from './product-list.component';
import { ProductItemComponent } from './product-item/product-item.component';
@NgModule({
  imports: [CommonModule, RouterModule],
  declarations: [ProductListComponent, ProductItemComponent],
  exports: [ProductListComponent, ProductItemComponent]
})
export class ProductListModule {}
