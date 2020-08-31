import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProductListComponent } from './product-list.component';

@NgModule({
  imports: [CommonModule, RouterModule],
  declarations: [ProductListComponent],
  exports: [ProductListComponent]
})
export class ProductListModule {}
