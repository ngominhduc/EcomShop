import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EcomShopSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';
import { ProductListModule } from 'app/components/product-list/product-list.module';

@NgModule({
  imports: [EcomShopSharedModule, RouterModule.forChild([HOME_ROUTE]), ProductListModule],
  declarations: [HomeComponent]
})
export class EcomShopHomeModule {}
