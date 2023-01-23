import { HttpClient } from '@angular/common/http';
import { ProductsService } from './products.service';
import { of } from 'rxjs';
import { Product, ProductDetails } from '../models';

let httpClientSpy: jasmine.SpyObj<HttpClient>;
let productsService: ProductsService;

beforeEach(() => {
  httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
  productsService = new ProductsService(httpClientSpy);
});

describe('ProductsService', () => {
  const MOCK_ID_PRODUCT = 4;
  const MOCK_CAT_ID = 12;
  const MOCK_PRODUCTS = [
    {
      id: 12,
      name: 'Zanim wystygnie kawa',
      author: 'Kawaguchi Toshikazu',
      price: 39.99,
      coverType: 'SoftCover',
    },
  ];
  const MOCK_PRODUCT = {
    id: 4,
    name: 'Harry Potter i Komnata Tajemnic',
    author: 'J.K. Rowling',
    price: 59.99,
    coverType: 'SoftCover',
    description:
      'Komnata tajemnic znów została otwarta. Słowa te prędzej czy później pojawiają się na kartach powieści J.K. Rowling. Zanim jednak do tego dojdzie, Harry ponownie pojedzie do Hogwartu, co wydarzy się w ciekawych okolicznościach. Zobacz, co tym razem stanie na przeszkodzie, kiedy będzie chciał udać się na pociąg do szkoły magii i czarodziejstwa. Z pewnością i Tobie w związku z drugim tomem cyklu Harry`ego Pottera nasuwa się wiele pytań: Czym jest Komnata Tajemnic? Czym grozi jej ponowne otwarcie? Gdzie można ją znaleźć? Odpowiedzi - wraz ze sporą dawką emocji - znajdziesz w książce.',
    publisher: 'NOWA ERA',
    title: 'Harry Potter i Komnata Tajemnic',
    numberOfPages: 426,
    numberOfItemsInStock: 13,
    releaseDate: null,
    language: null,
  };

  it('should get a product by http get request', (done: DoneFn) => {
    httpClientSpy.get.and.returnValue(of(MOCK_PRODUCT));
    productsService.getProduct(MOCK_ID_PRODUCT).subscribe((res) => {
      expect(res).toBeDefined();
      expect(res instanceof ProductDetails).toBeTrue();
      expect(httpClientSpy.get.calls.count()).toBe(1);
      done();
    });
  });

  it('should get products by http get request', (done: DoneFn) => {
    httpClientSpy.get.and.returnValue(of(MOCK_PRODUCTS));
    productsService.getProducts(MOCK_CAT_ID).subscribe((res) => {
      expect(res).toBeDefined();
      expect(res instanceof Array<Product>).toBeTrue();
      expect(res.length).toBe(1);
      expect(httpClientSpy.get.calls.count()).toBe(1);
      done();
    });
  });
});
