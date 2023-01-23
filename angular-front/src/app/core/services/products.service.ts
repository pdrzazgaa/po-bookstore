import { Image, Product, ProductDetails } from '../models';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ProductsService {
  private productsBaseUrl = 'http://localhost:6060/products';
  private productBaseUrl = 'http://localhost:6060/product';
  private http: HttpClient;
  private products: Product[] = [];

  constructor(http: HttpClient) {
    this.http = http;
  }

  getProduct(productId: number): Observable<any> {
    return this.http.get(this.productBaseUrl + `/${productId}`).pipe(
      map((res: any) => {
        if (res) {
          const cover = res.coverType == 'HardCover' ? 'twarda' : 'miękka';
          return new ProductDetails(
            res.id,
            res.name,
            res.price,
            new Image(`../../../assets/${res.id}.jpg`, res.name),
            res.description,
            cover,
            res.author,
            res.publisher,
            res.releaseDate,
            res.numberOfPages,
            res.title
          );
        } else return null;
      })
    );
  }

  getProducts(idCat: any): Observable<Product[]> {
    let url = this.productsBaseUrl;
    if (idCat) {
      url = this.productsBaseUrl + `/${idCat}`;
    }
    return this.http.get<any[]>(url).pipe(
      map((res) => {
        if (res) {
          this.products = res.map(
            (prod) =>
              new Product(
                prod.id,
                prod.name,
                prod.price,
                new Image(`../../../assets/${prod.id}.jpg`, prod.name),
                prod.coverType == 'HardCover' ? 'twarda' : 'miękka',
                prod.author
              )
          );
        }
        return this.products;
      })
    );
  }
}
