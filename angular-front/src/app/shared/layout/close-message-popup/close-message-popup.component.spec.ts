import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CloseMessagePopupComponent } from './close-message-popup.component';

describe('CloseMessagePopupComponent', () => {
  let component: CloseMessagePopupComponent;
  let fixture: ComponentFixture<CloseMessagePopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CloseMessagePopupComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(CloseMessagePopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
