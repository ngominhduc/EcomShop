import { Component, OnInit, Input } from '@angular/core';
import { Comments } from 'app/shared/model/comments.model';

@Component({
  selector: 'jhi-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.scss']
})
export class CommentsComponent implements OnInit {
  @Input()
  comments!: Comments;

  constructor() {}

  ngOnInit(): void {}
}
