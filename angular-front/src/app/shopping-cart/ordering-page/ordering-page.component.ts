import {
  Address,
  Delivery,
  ParcelMachine,
  Payment,
  ShoppingCart,
  ShoppingCartService,
  UserService,
} from 'src/app/core';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
  public confirmPopupMessage: string = '';
  public confirmMode: 'green' | 'red' = 'green';
  public deliveryCost!: number;
  public usedBookcoins: number = 0;
  public triedSubmit: boolean = false;
  public deliveryCostOptions = {
    carrier: 13.99,
    bookstore: 0,
    parcel: 9.99,
  };
  public errorMessage: string = '';
  public showErrorMessage: boolean = false;

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
    document: new FormControl('receipt', Validators.required),
    payment: new FormControl('online-payment', Validators.required),
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
      this.router.navigate(['/']);
    }
  }

  onErrorMessagePopupClose(isClosed: boolean) {
    if (isClosed) {
      this.showErrorMessage = false;
    }
  }

  onFormSubmit() {
    this.triedSubmit = true;
    const c = this.orderForm.controls;
    const p = c.personalData.controls;
    const d = c.deliveryOption.controls;

    if (this.orderForm.valid) {
      const response = this.shoppingCartService.makeNewOrder(
        p.email.value!,
        p.phoneNumber.value!,
        new Address(
          p.street.value!,
          +p.number.value!,
          p.city.value!,
          p.postcode.value!,
          p.country.value!
        ),
        {
          delivery: d.delivery.value,
          parcelMachineNumber: d.parcelMachineNumber.value,
        } as Delivery,
        c.payment.value! as Payment,
        c.bookcoins.value!,
        this.shoppingCart!.cartId,
        p.forname.value!,
        p.surname.value!
      );
      if (response) {
        this.confirmMode = 'green';
        this.confirmPopupMessage =
          'Poprawnie złozono zamówienie. Opłać swoje zamówienie. Dodano 13 bookcoinów do twojego konta';
      } else {
        this.confirmPopupMessage =
          'Przepraszamy, coś poszło nie tak... nie udało się złozyc zamowienia';
        this.confirmMode = 'red';
      }
      this.showConfirmPopup = true;
    } else {
      if (c.bookcoins.invalid) {
        this.errorMessage = 'Zła liczba podanych bookcoinów!';
      } else if (c.personalData.invalid) {
        this.errorMessage = 'Podano niepoprawne dane osobowe';
      } else if (c.deliveryOption.invalid) {
        this.errorMessage = 'Nie wybrano paczkomatu!';
      } else {
        this.errorMessage = 'Musisz wyrazić zgodę na przetwarzanie danych osobowych';
      }
      this.showErrorMessage = true;
    }
  }
}
