import { Component, OnDestroy, OnInit } from '@angular/core';
import { Order, OrdersService } from 'src/app/core';
import { Subscription } from 'rxjs';
import { UserService } from 'src/app/core';

@Component({
  selector: 'app-orders-page',
  templateUrl: './orders-page.component.html',
  styleUrls: ['./orders-page.component.scss'],
})
export class OrdersPageComponent implements OnInit, OnDestroy {
  private userService: UserService;
  private ordersService: OrdersService;
  orders?: Order[];
  userId?: number;
  private ordersSub?: Subscription;

  constructor(userService: UserService, ordersService: OrdersService) {
    this.userService = userService;
    this.ordersService = ordersService;
  }

  ngOnInit(): void {
    this.userId = this.userService.getUserId();
    if (this.userId) {
      this.ordersSub = this.ordersService.getOrders().subscribe((orders) => {
        this.orders = orders;
      });
    }
  }

  ngOnDestroy(): void {
    this.ordersSub?.unsubscribe();
  }
}
