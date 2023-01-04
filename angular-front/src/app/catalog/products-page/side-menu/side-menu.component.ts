import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.scss'],
})
export class SideMenuComponent implements OnInit {
  public category: string = 'Poradniki i albumy';
  public subcategory: string = 'Podroze';

  public priceRanges: number[] = [20, 50, 100, 200];
  constructor() {}

  ngOnInit(): void {}
}
