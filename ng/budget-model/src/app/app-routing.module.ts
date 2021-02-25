import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddExpenseComponent } from './add-expense/add-expense.component';
import { AddIncomeComponent } from './add-income/add-income.component';
import { BudgetItemsComponent } from './budget-items/budget-items.component';

const routes: Routes = [
  { path:'', component: BudgetItemsComponent },
  { path:'add-income', component: AddIncomeComponent },
  { path:'add-expense', component: AddExpenseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
