import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.scss'],
})
export class SideMenuComponent implements OnInit, OnDestroy {
  public category: string = '';
  public subcategory: string = '';
  public priceRanges: number[] = [20, 50, 100, 200];
  private route: ActivatedRoute;
  private routeSub?: Subscription;

  constructor(route: ActivatedRoute) {
    this.route = route;
  }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      console.log(params);
      this.category = params['category'];
      this.subcategory = params['subcategory'];
    });
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }
}
