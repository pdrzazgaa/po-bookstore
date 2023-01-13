import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnDestroy, OnInit } from '@angular/core';
import {
  Delivery,
  OrderDetails,
  OrdersService,
  ParcelMachine,
  Reclamation,
  ReclamationPosition,
  UserService,
} from 'src/app/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HasCheckedBox } from 'src/app/shared';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-reclamation-page',
  templateUrl: './reclamation-page.component.html',
  styleUrls: ['./reclamation-page.component.scss'],
})
export class ReclamationPageComponent implements OnInit, OnDestroy {
  private ordersService: OrdersService;
  private userService: UserService;
  private route: ActivatedRoute;
  private router: Router;
  private routeSub?: Subscription;
  private formBuilder: FormBuilder;

  public order?: OrderDetails;
  public step: 'choose-data' | 'choose-delivery' = 'choose-data';
  public productsForm?: FormGroup;
  public deliveryForm?: FormGroup = this.createDeliveryForm();
  public showParcelMachineForm: boolean = false;
  public chosenParcelMachine?: ParcelMachine;
  public showChosenParcel: boolean = false;
  public showConfirmPopup: boolean = false;

  private requiredValidator = Validators.required;
  private minValidator = Validators.minLength(5);
  private maxValidator = Validators.maxLength(60);
  private reclamationPositions: ReclamationPosition[] = [];

  constructor(
    ordersService: OrdersService,
    userService: UserService,
    route: ActivatedRoute,
    router: Router,
    formBuilder: FormBuilder
  ) {
    this.ordersService = ordersService;
    this.userService = userService;
    this.route = route;
    this.router = router;
    this.formBuilder = formBuilder;
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      this.order = this.ordersService.getOrderDetails(+params['orderId']);
    });
    this.productsForm = this.formBuilder.group(this.createForm(), {
      validator: HasCheckedBox,
    });
  }

  createForm() {
    const form: Record<number, FormGroup> = {};
    this.order?.orderPositions.forEach((position) => {
      form[position.product.id] = new FormGroup({
        checked: new FormControl(false),
        amount: new FormControl(1, [this.requiredValidator]),
        reason: new FormControl('', [
          this.requiredValidator,
          this.minValidator,
          this.maxValidator,
        ]),
      });
      form[position.product.id].controls['amount'].disable();
      form[position.product.id].controls['reason'].disable();
    });
    return form;
  }

  createDeliveryForm() {
    const form = new FormGroup({
      delivery: new FormControl('', Validators.required),
      parcelMachineNumber: new FormControl('', Validators.required),
    });
    form.controls.parcelMachineNumber.disable();
    return form;
  }

  onCheckboxChange(productId: number) {
    const checkedControl = (this.productsForm!.controls[productId] as FormGroup).controls[
      'checked'
    ];
    const amountControl = (this.productsForm!.controls[productId] as FormGroup).controls[
      'amount'
    ];
    const reasonControl = (this.productsForm!.controls[productId] as FormGroup).controls[
      'reason'
    ];
    if (checkedControl.value) {
      amountControl.enable();
      reasonControl.enable();
    } else {
      amountControl.disable();
      reasonControl.disable();
    }
  }

  isCheckboxChecked(productId: number) {
    return (this.productsForm!.controls[productId] as FormGroup).controls['checked']
      .value;
  }

  isReasonInputValid(productId: number) {
    return (this.productsForm!.controls[productId] as FormGroup).controls['reason'].valid;
  }

  showHeaders() {
    let showHeader = false;
    for (let formGroup of Object.values(this.productsForm?.controls!)) {
      if ((formGroup as FormGroup).controls['checked'].value === true) {
        showHeader = true;
      }
    }
    return showHeader;
  }

  onProductsFormSubmit() {
    this.step = 'choose-delivery';
    Object.entries(this.productsForm!.controls).forEach(([productId, formGroup]) => {
      if (this.isCheckboxChecked(+productId)) {
        this.reclamationPositions.push({
          productId: +productId,
          amount: +(formGroup as FormGroup).controls['amount'].value,
          reason: (formGroup as FormGroup).controls['reason'].value,
        });
      }
    });
    this.deliveryForm = this.createDeliveryForm();
  }

  onDeliveryInputClick() {
    this.showChosenParcel = false;
    this.deliveryForm?.controls['parcelMachineNumber'].disable();
  }

  onParcelMachineClick() {
    this.showParcelMachineForm = true;
    this.showChosenParcel = true;
    this.deliveryForm?.controls['parcelMachineNumber'].enable();
  }

  onParcelFormClose(parcelMachine: ParcelMachine) {
    if (parcelMachine.address && parcelMachine.code) {
      this.chosenParcelMachine = parcelMachine;
      this.deliveryForm?.controls['parcelMachineNumber'].setValue(parcelMachine.code);
    }
    this.showParcelMachineForm = false;
  }

  onReclamationFormSubmit() {
    const reclamation = {
      reclamationPositions: this.reclamationPositions,
      orderId: this.order!.id,
      userId: this.userService.getUserId()!,
      delivery: { delivery: this.deliveryForm!.controls['delivery'].value } as Delivery,
    } as Reclamation;

    const parcelMachineNumber = this.deliveryForm!.controls['parcelMachineNumber'].value;

    if (parcelMachineNumber) {
      reclamation.delivery.parcelMachineNumber = parcelMachineNumber;
    }

    this.ordersService.sendReclamation(reclamation);
    this.showConfirmPopup = true;
  }

  onConfirmPopupClose(isClosed: boolean) {
    if (isClosed) {
      this.showConfirmPopup = false;
      this.router.navigate(['/orders']);
    }
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }
}
