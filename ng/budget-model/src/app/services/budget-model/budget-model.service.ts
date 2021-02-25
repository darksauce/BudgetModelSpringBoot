import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BudgetItem } from './model/budget-item';

@Injectable({
  providedIn: 'root'
})
export class BudgetModelService {

  constructor(private httpClient: HttpClient) { }

  getBudgetItems(): Observable<BudgetItem[]> {
    return this.httpClient.get<BudgetItem[]>(
      `http://localhost:8080/api/v1/budget`
    );
  }

}