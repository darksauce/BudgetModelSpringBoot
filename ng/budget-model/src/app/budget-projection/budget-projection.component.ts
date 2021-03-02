import { Component, OnInit } from '@angular/core';
import { BudgetModelService } from '../services/budget-model/budget-model.service';
import { BudgetItem } from '../services/budget-model/model/budget-item';
import { FinancialSummary } from '../services/budget-model/model/financial-summary';

@Component({
  selector: 'app-budget-projection',
  templateUrl: './budget-projection.component.html',
  styleUrls: ['./budget-projection.component.css']
})
export class BudgetProjectionComponent implements OnInit {

  projItems: FinancialSummary[] = [];
  startingBalance: number = 0;

  constructor(private service: BudgetModelService) { }

  ngOnInit(): void {
    this.loadProjectionItems();
  }

  loadProjectionItems() {
    this.service.getProjectionItems(this.startingBalance)
      .subscribe(proj => {
        this.projItems = proj;
      });
  }

  update() {
    this.loadProjectionItems();
  }
}
