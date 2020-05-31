import { TestBed } from '@angular/core/testing';

import { AddRuleService } from './add-rule.service';

describe('AddRuleService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AddRuleService = TestBed.get(AddRuleService);
    expect(service).toBeTruthy();
  });
});
