import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { ProductPageComponent } from './product-page.component';
import { PRODUCT_PAGE_ROUTE } from './product-page.route';
import { CommentsComponent } from './comments/comments.component';
import { FormsModule } from '@angular/forms';
@NgModule({
  imports: [CommonModule, RouterModule.forRoot([PRODUCT_PAGE_ROUTE], { useHash: true }), FormsModule],
  declarations: [ProductPageComponent, CommentsComponent],
  entryComponents: [],
  providers: []
})
export class ProductPageModule {}
