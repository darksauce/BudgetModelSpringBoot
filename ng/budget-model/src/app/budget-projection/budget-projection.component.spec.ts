import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BudgetProjectionComponent } from './budget-projection.component';

describe('BudgetProjectionComponent', () => {
  let component: BudgetProjectionComponent;
  let fixture: ComponentFixture<BudgetProjectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BudgetProjectionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BudgetProjectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
