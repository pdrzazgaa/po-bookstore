import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoyaltyProgramPageComponent } from './loyalty-program-page.component';

describe('LoyaltyProgramPageComponent', () => {
  let component: LoyaltyProgramPageComponent;
  let fixture: ComponentFixture<LoyaltyProgramPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoyaltyProgramPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoyaltyProgramPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
