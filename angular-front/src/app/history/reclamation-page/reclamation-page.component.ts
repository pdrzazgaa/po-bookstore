import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { OrderDetails, OrdersService } from 'src/app/core';
import { ActivatedRoute } from '@angular/router';
import { HasCheckedBox } from 'src/app/shared';
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
    this.productsForm = this.formBuilder.group(this.createForm(), {
      validator: HasCheckedBox,
    });
    console.log(this.productsForm);
  }

  createForm() {
    const form: Record<number, FormGroup> = {};
    this.order?.orderPositions.forEach((position) => {
      form[position.product.id] = new FormGroup({
        checked: new FormControl(false),
        amount: new FormControl('', [this.requiredValidator]),
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
