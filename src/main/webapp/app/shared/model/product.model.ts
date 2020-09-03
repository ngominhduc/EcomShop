import { Comments } from './comments.model';

export interface IProduct {
  id?: string;
  name?: string;
  description?: string;
  quantity?: number;
  price?: number;
  comments?: Comments[];
}

export class Product implements IProduct {
  constructor(
    public id?: string,
    public name?: string,
    public description?: string,
    public quantity?: number,
    public price?: number,
    public comments?: Comments[]
  ) {}
}
