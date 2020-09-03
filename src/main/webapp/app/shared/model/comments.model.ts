import { User } from '../../core/user/user.model';
export interface IComments {
  user?: User;
  title?: string;
  body?: string;
  node?: number;
  date?: string;
}

export class Comments implements IComments {
  constructor(public user?: User, public title?: string, public body?: string, public node?: number, public date?: string) {}
}
