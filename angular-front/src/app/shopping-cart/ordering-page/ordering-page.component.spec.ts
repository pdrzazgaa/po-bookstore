import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderingPageComponent } from './ordering-page.component';

describe('OrderingPageComponent', () => {
  let component: OrderingPageComponent;
  let fixture: ComponentFixture<OrderingPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderingPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
