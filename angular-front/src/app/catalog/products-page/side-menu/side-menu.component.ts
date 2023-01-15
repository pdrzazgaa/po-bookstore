import { Component, EventEmitter, OnDestroy, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
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
  @Output() filtersChanged = new EventEmitter<{ price: string; cover: string }>();

  constructor(route: ActivatedRoute) {
    this.route = route;
  }

  filtersForm = new FormGroup({
    price: new FormControl(''),
    cover: new FormControl(''),
  });

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe((params) => {
      this.category = params['category'];
      this.subcategory = params['subcategory'];
    });
  }

  onSubmitForm() {
    this.filtersChanged.emit({
      price: this.filtersForm.controls.price.value!,
      cover: this.filtersForm.controls.cover.value!,
    });
  }

  ngOnDestroy(): void {
    this.routeSub?.unsubscribe();
  }
}
