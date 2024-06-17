import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentGetwaysComponent } from './payment-getways.component';

describe('PaymentGetwaysComponent', () => {
  let component: PaymentGetwaysComponent;
  let fixture: ComponentFixture<PaymentGetwaysComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaymentGetwaysComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PaymentGetwaysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
