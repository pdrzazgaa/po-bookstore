import { Component, OnDestroy, OnInit } from '@angular/core';
import { OrderDetails, OrdersService } from 'src/app/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-order-page',
  templateUrl: './order-page.component.html',
  styleUrls: ['./order-page.component.scss'],
})
export class OrderPageComponent implements OnInit, OnDestroy {
  private ordersService: OrdersService;
  private route: ActivatedRoute;
  private routeSub?: Subscription;
  public order?: OrderDetails;
  public orderSub?: Subscription;

  constructor(ordersService: OrdersService, route: ActivatedRoute) {
    this.ordersService = ordersService;
    this.route = route;
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      this.orderSub = this.ordersService
        .getOrderDetails(params['id'])
        .subscribe((order) => {
          this.order = order;
          console.log(this.order?.canComplain);
        });
    });
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }
}
