import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReclamationPageComponent } from './reclamation-page.component';

describe('ReclamationPageComponent', () => {
  let component: ReclamationPageComponent;
  let fixture: ComponentFixture<ReclamationPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReclamationPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReclamationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
