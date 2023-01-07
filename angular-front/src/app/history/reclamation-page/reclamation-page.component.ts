import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { OrderDetails, OrdersService } from 'src/app/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-reclamation-page',
  templateUrl: './reclamation-page.component.html',
  styleUrls: ['./reclamation-page.component.scss'],
})
export class ReclamationPageComponent implements OnInit, OnDestroy {
  private ordersService: OrdersService;
  private route: ActivatedRoute;
  private routeSub?: Subscription;
  private formBuilder: FormBuilder;
  public order?: OrderDetails;
  public step: 'choose-data' | 'choose-delivery' = 'choose-data';
  public productsForm?: FormGroup;

  private requiredValidator = Validators.required;
  private minValidator = Validators.minLength(5);
  private maxValidator = Validators.maxLength(20);

  constructor(
    ordersService: OrdersService,
    route: ActivatedRoute,
    formBuilder: FormBuilder
  ) {
    this.ordersService = ordersService;
    this.route = route;
    this.formBuilder = formBuilder;
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      this.order = this.ordersService.getOrderDetails(+params['orderId']);
    });
    this.productsForm = this.formBuilder.group(this.createForm());
    console.log(this.productsForm);
  }

  createForm() {
    const form: Record<number, FormGroup> = {};
    this.order?.orderPositions.forEach(
      (position) =>
        (form[position.product.id] = new FormGroup({
          checked: new FormControl(false),
          amount: new FormControl(''),
          reason: new FormControl(''),
        }))
    );
    return form;
  }

  onCheckboxChange(productId: number) {
    const checkedControl = (this.productsForm!.controls[productId] as FormGroup).controls[
      'checked'
    ];
    if (checkedControl.value) {
      (this.productsForm!.controls[productId] as FormGroup).controls[
        'amount'
      ].addValidators(this.requiredValidator);
      (this.productsForm!.controls[productId] as FormGroup).controls[
        'reason'
      ].addValidators([this.requiredValidator, this.minValidator, this.maxValidator]);
    } else {
      (this.productsForm!.controls[productId] as FormGroup).controls[
        'amount'
      ].removeValidators(this.requiredValidator);
      (this.productsForm!.controls[productId] as FormGroup).controls[
        'reason'
      ].removeValidators([this.requiredValidator, this.minValidator, this.maxValidator]);
    }
  }

  isCheckboxChecked(productId: number) {
    return (this.productsForm!.controls[productId] as FormGroup).controls['checked']
      .value;
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

  onFormSubmit() {
    this.step = 'choose-delivery';
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }
}
