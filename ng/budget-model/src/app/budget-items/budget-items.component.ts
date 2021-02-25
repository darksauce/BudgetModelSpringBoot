import { Component, OnInit } from '@angular/core';
import { BudgetModelService } from '../services/budget-model/budget-model.service';
import { BudgetItem } from '../services/budget-model/model/budget-item';

@Component({
  selector: 'app-budget-items',
  templateUrl: './budget-items.component.html',
  styleUrls: ['./budget-items.component.css']
})
export class BudgetItemsComponent implements OnInit {

  budgetItems: BudgetItem[] = [];

  constructor(private service: BudgetModelService) { 
  }

  ngOnInit(): void {
    this.loadBudgetItems();
  }

  loadBudgetItems() {
    this.service.getBudgetItems().subscribe(res => {
      var rawItems = res;
      rawItems.forEach(item => this.decodeItem(item));
      this.budgetItems = rawItems;
    });
  }

  decodeItem(item: BudgetItem) {
      // Decode the Event Types
      switch(item.eventType) {
        case 'INC':
            item.eventType = 'Income';
            break;
        case 'EXP':
            item.eventType = 'Expense';
            break;
      }

      // Decode the Frequencies
      switch(item.freqType) {
        case 'DY':
            item.freqType = 'Daily';
            break;
        case 'WK':
            item.freqType = 'Weekly';
            break;
        case 'FN':
            item.freqType = 'Fortnight';
            break;
        case 'MTH':
            item.freqType = 'Monthly';
            break;
        case 'QTR':
            item.freqType = 'Quarterly';
            break;
        case 'SMTH':
            item.freqType = 'Six Monthly';
            break;
        case 'YR':
            item.freqType = 'Yearly';
            break;
      }
  }
  
}
