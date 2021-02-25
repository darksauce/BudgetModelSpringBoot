import { TestBed } from '@angular/core/testing';

import { BudgetModelService } from './budget-model.service';

describe('BudgetModelService', () => {
  let service: BudgetModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BudgetModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
