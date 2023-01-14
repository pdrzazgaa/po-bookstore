import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ShoppingCart, ShoppingCartService, UserService } from 'src/app/core';

@Component({
  selector: 'app-ordering-page',
  templateUrl: './ordering-page.component.html',
  styleUrls: ['./ordering-page.component.scss'],
})
export class OrderingPageComponent implements OnInit {
  private shoppingCartService: ShoppingCartService;
  private userService: UserService;
  shoppingCart?: ShoppingCart;
  ordererMode: 'client' | 'company' = 'client';

  orderForm = new FormGroup({
    orderer: new FormControl('client', Validators.required),
    personalData: new FormGroup({
      forname: new FormControl('', Validators.required),
      surname: new FormControl('', Validators.required),
      companyName: new FormControl('', Validators.required),
      NIP: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      phoneNumber: new FormControl('', Validators.required),
      street: new FormControl('', Validators.required),
      number: new FormControl('', Validators.required),
      postcode: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(6),
      ]),
      city: new FormControl('', Validators.required),
      country: new FormControl('', Validators.required),
    }),
    document: new FormControl('', Validators.required),
    payment: new FormControl('', Validators.required),
    delivery: new FormControl('', Validators.required),
    bookcoins: new FormControl(0, [Validators.required, Validators.min(0)]),
  });

  constructor(shoppingCartService: ShoppingCartService, userService: UserService) {
    this.shoppingCartService = shoppingCartService;
    this.userService = userService;
  }

  ngOnInit(): void {
    this.shoppingCart = this.shoppingCartService.getShoppingCart();
    this.orderForm.controls['bookcoins'].addValidators(
      Validators.max(this.userService.getBookcoins())
    );
    const personalData = this.orderForm.controls['personalData'];
    personalData.controls['NIP'].disable();
    personalData.controls['companyName'].disable();
  }

  onClientClick() {
    this.ordererMode = 'client';
    const personalData = this.orderForm.controls['personalData'];
    personalData.controls['NIP'].disable();
    personalData.controls['companyName'].disable();
    personalData.controls['forname'].enable();
    personalData.controls['surname'].enable();
  }

  onCompanyClick() {
    this.ordererMode = 'company';
    const personalData = this.orderForm.controls['personalData'];
    personalData.controls['NIP'].enable();
    personalData.controls['companyName'].enable();
    personalData.controls['forname'].disable();
    personalData.controls['surname'].disable();
  }

  onFormSubmit() {}
}
