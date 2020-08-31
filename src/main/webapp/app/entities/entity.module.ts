import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'product',
        loadChildren: () => import('./product/product.module').then(m => m.EcomShopProductModule)
      },
      {
        path: 'category',
        loadChildren: () => import('./category/category.module').then(m => m.EcomShopCategoryModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class EcomShopEntityModule {}
