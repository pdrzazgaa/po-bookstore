import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParcelMachineFormComponent } from './parcel-machine-form.component';

describe('ParcelMachineFormComponent', () => {
  let component: ParcelMachineFormComponent;
  let fixture: ComponentFixture<ParcelMachineFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParcelMachineFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParcelMachineFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
