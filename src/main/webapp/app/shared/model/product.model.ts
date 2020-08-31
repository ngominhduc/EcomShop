export interface IProduct {
  id?: string;
  name?: string;
  description?: string;
  quantity?: string;
  price?: string;
}

export class Product implements IProduct {
  constructor(public id?: string, public name?: string, public description?: string, public quantity?: string, public price?: string) {}
}
