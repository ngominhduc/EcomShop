import { Component, OnInit, Input } from '@angular/core';
import { Comments } from 'app/shared/model/comments.model';
import { ProductService } from 'app/entities/product/product.service';
import { AccountService } from 'app/core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { Subscription } from 'rxjs';
import { UserService } from 'app/core/user/user.service';
import { Product } from 'app/shared/model/product.model';

@Component({
  selector: 'jhi-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.scss']
})
export class CommentsComponent implements OnInit {
  @Input() product!: Product;

  comments: Comments[] | undefined;
  title!: string;
  body!: string;
  account: Account | null = null;
  currentUser: any;
  authSubscription?: Subscription;
  newComments!: Comments;
  constructor(private productService: ProductService, private accountService: AccountService, private userService: UserService) {}

  ngOnInit(): void {
    this.comments = this.product.comments;
    this.accountService.getAuthenticationState().subscribe(acount => (this.currentUser = acount));
  }

  isAuthenticated(): boolean {
    console.log('you are login? ' + this.accountService.isAuthenticated());
    return this.accountService.isAuthenticated();
  }

  addComments(formValue: any) {
    console.log(formValue);
    /*
    if (this.accountService.isAuthenticated()) {
      this.accountService.getAuthenticationState().subscribe(acount => {
        this.currentUser = acount;
        console.log(this.currentUser);
        this.newComments = new Comments(this.currentUser, formValue.commentTitle, formValue.commentBody, 10, '09/07/2020');
        console.log(this.newComments);
        this.product.comments?.push(this.newComments);
        this.productService.update(this.product).subscribe(response => {
          if(response.status === 200){
            console.log("sumit sucess");
          }
        })
      })
    }
    */
  }
}
