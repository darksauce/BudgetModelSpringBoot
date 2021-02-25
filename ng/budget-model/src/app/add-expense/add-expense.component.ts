import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {

  desc: string;
  amount: number;
  frequency: string;
  referenceDate: string;

  errorMessage: string;

  constructor() { }

  ngOnInit(): void {
      this.errorMessage = '';
      this.desc = '';
      this.amount = 0.00;
      this.referenceDate = 'dd/mm/yyyy';
  }

  addExpense() {
      if (this.validateInputs()) {

      }
  }

  validateInputs(): boolean {
      if (this.desc.length == 0) {
          this.errorMessage = 'Please enter a description for the expense item.';
          return false;
      }
      if (this.amount <= 0) {
         this.errorMessage = 'Please enter a valid expense amount.';
         return false;
      }
      if (this.frequency == undefined) {
         this.errorMessage = 'Please select a Frequency.';
         return false;
      }
      if (this.referenceDate == 'dd/mm/yyyy') {
          this.errorMessage = 'Please enter a valid reference date (eg. your last bill date).';
          return false;
      }
      if (this.referenceDate.length != 10) {
        this.errorMessage = 'Please enter a valid reference date (use 10 characters).';
        return false;
      }
      this.errorMessage = '';
      return true;
  }
}
