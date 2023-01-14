import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {
  ParcelMachine,
  ShoppingCart,
  ShoppingCartService,
  UserService,
} from 'src/app/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ordering-page',
  templateUrl: './ordering-page.component.html',
  styleUrls: ['./ordering-page.component.scss'],
})
export class OrderingPageComponent implements OnInit {
  private shoppingCartService: ShoppingCartService;
  private userService: UserService;
  private router: Router;
  shoppingCart?: ShoppingCart;
  ordererMode: 'client' | 'company' = 'client';
  public showParcelMachineForm: boolean = false;
  public chosenParcelMachine?: ParcelMachine;
  public showChosenParcel: boolean = false;
  public showConfirmPopup: boolean = false;
  public deliveryCost!: number;
  public usedBookcoins: number = 0;
  public triedSubmit: boolean = false;
  public deliveryCostOptions = {
    carrier: 13.99,
    bookstore: 0,
    parcel: 9.99,
  };

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
      country: new FormControl('Polska', Validators.required),
    }),
    document: new FormControl('', Validators.required),
    payment: new FormControl('', Validators.required),
    deliveryOption: new FormGroup({
      delivery: new FormControl<'carrier' | 'bookstore' | 'parcel'>(
        'carrier',
        Validators.required
      ),
      parcelMachineNumber: new FormControl('', Validators.required),
    }),
    bookcoins: new FormControl(0, Validators.min(0)),
    rodo: new FormControl<boolean>(false, Validators.requiredTrue),
  });

  constructor(
    shoppingCartService: ShoppingCartService,
    userService: UserService,
    router: Router
  ) {
    this.shoppingCartService = shoppingCartService;
    this.userService = userService;
    this.router = router;
  }

  ngOnInit(): void {
    this.shoppingCart = this.shoppingCartService.getShoppingCart();
    this.orderForm.controls['bookcoins'].addValidators(
      Validators.max(this.userService.getBookcoins())
    );
    const personalData = this.orderForm.controls['personalData'];
    personalData.controls['NIP'].disable();
    personalData.controls['companyName'].disable();
    const deliveryData = this.orderForm.controls['deliveryOption'];
    deliveryData.controls['parcelMachineNumber'].disable();
    this.deliveryCost =
      this.deliveryCostOptions[deliveryData.controls['delivery'].value!];
  }

  getTotalCartAmount() {
    if (this.shoppingCart) {
      return this.shoppingCart.totalAmount;
    } else return 0;
  }

  getBookcoins() {
    return this.userService.getBookcoins();
  }

  onBookcoinsChange() {
    const bookcoinsControl = this.orderForm.controls['bookcoins'];
    if (bookcoinsControl.valid) {
      this.usedBookcoins = bookcoinsControl.value!;
    }
    console.log(this.orderForm);
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

  private onDeliveryClick() {
    this.orderForm.controls['deliveryOption'].controls['parcelMachineNumber'].disable();
    this.showChosenParcel = false;
  }

  onBookstoreClick() {
    this.onDeliveryClick();
    this.deliveryCost = this.deliveryCostOptions.bookstore;
  }

  onCarrierClick() {
    this.onDeliveryClick();
    this.deliveryCost = this.deliveryCostOptions.carrier;
  }

  onParcelClick() {
    this.deliveryCost = this.deliveryCostOptions.parcel;
    this.showParcelMachineForm = true;
    this.showChosenParcel = true;
    this.orderForm.controls['deliveryOption'].controls['parcelMachineNumber'].enable();
  }

  onParcelFormClose(parcelMachine: ParcelMachine) {
    if (parcelMachine.address && parcelMachine.code) {
      this.chosenParcelMachine = parcelMachine;
      this.orderForm.controls['deliveryOption'].controls['parcelMachineNumber'].setValue(
        parcelMachine.code
      );
    }
    this.showParcelMachineForm = false;
  }

  onConfirmPopupClose(isClosed: boolean) {
    if (isClosed) {
      this.showConfirmPopup = false;
      this.router.navigate(['/orders']);
    }
  }
  onFormSubmit() {
    this.triedSubmit = true;
    if (this.orderForm.valid) {
      // this.shoppingCartService.makeNewOrder();
    } else {

    }
  }
}
