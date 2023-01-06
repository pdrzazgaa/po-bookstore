import { Component, OnInit } from '@angular/core';
import { Order, OrdersService } from 'src/app/core';
import { UserService } from 'src/app/core';

@Component({
  selector: 'app-orders-page',
  templateUrl: './orders-page.component.html',
  styleUrls: ['./orders-page.component.scss'],
})
export class OrdersPageComponent implements OnInit {
  private userService: UserService;
  private ordersService: OrdersService;
  orders?: Order[];
  userId?: number;

  constructor(userService: UserService, ordersService: OrdersService) {
    this.userService = userService;
    this.ordersService = ordersService;
  }

  ngOnInit(): void {
    this.userId = this.userService.getUserId();
    // if (this.userId) {
    this.orders = this.ordersService.getOrders(this.userId || 1);
    // }
  }
}
