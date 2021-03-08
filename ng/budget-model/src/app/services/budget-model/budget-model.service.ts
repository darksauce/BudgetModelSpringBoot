import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BudgetItem } from './model/budget-item';
import { FinancialSummary } from './model/financial-summary';

@Injectable({
  providedIn: 'root'
})
export class BudgetModelService {

  httpOptions = {
    // TODO switch Auth to JWT
    headers: { 'Authorization': 'Basic YnVkZ2V0dXNlcjojMXRzYVMzY3IzdA==' }
  };

  constructor(private httpClient: HttpClient) { 
  }

  getBudgetItems(): Observable<BudgetItem[]> {
    return this.httpClient.get<BudgetItem[]>(
      `http://localhost:8080/api/v1/budget`,
      this.httpOptions
    );
  }

  addIncomeItem(newBudgetItem: BudgetItem): Observable<BudgetItem> {
    return this.httpClient.post<BudgetItem>(
      `http://localhost:8080/api/v1/budget/income`,
      newBudgetItem,
      this.httpOptions
    );
  }

  addExpenseItem(newBudgetItem: BudgetItem): Observable<BudgetItem> {
    return this.httpClient.post<BudgetItem>(
      `http://localhost:8080/api/v1/budget/expense`,
      newBudgetItem,
      this.httpOptions
    );
  }

  getProjectionItems(startingBalance: number): Observable<FinancialSummary[]> {
    return this.httpClient.get<FinancialSummary[]>(
      `http://localhost:8080/api/v1/budget/model/` + startingBalance,
      this.httpOptions
    );
  }
}
