import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TitlebarComponent } from './titlebar/titlebar.component';
import { AddIncomeComponent } from './add-income/add-income.component';
import { AddExpenseComponent } from './add-expense/add-expense.component';
import { BudgetItemsComponent } from './budget-items/budget-items.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

const appRoutes: Routes = [
  { path: '', component: BudgetItemsComponent },
  { path: 'income', component: AddIncomeComponent },
  { path: 'expense', component: AddExpenseComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TitlebarComponent,
    AddIncomeComponent,
    AddExpenseComponent,
    BudgetItemsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    FontAwesomeModule,
    RouterModule.forRoot(
      appRoutes
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

