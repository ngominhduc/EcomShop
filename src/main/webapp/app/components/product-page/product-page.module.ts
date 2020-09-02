import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { ProductPageComponent } from './product-page.component';
import { PRODUCT_PAGE_ROUTE } from './product-page.route';

@NgModule({
  imports: [CommonModule, RouterModule.forRoot([PRODUCT_PAGE_ROUTE])],
  declarations: [ProductPageComponent],
  entryComponents: [],
  providers: []
})
export class ProductPageModule {}
