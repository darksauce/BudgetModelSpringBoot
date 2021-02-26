import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BudgetModelService } from '../services/budget-model/budget-model.service';

@Component({
  selector: 'app-add-income',
  templateUrl: './add-income.component.html',
  styleUrls: ['./add-income.component.css']
})
export class AddIncomeComponent implements OnInit {

  desc: string;
  amount: number;
  frequency: string;
  referenceDate: string;

  errorMessage: string;

  constructor(private service: BudgetModelService, private router: Router) { }

  ngOnInit(): void {
      this.errorMessage = '';
      this.desc = '';
      this.amount = 0.00;
      this.referenceDate = 'dd/mm/yyyy';
  }

  addIncome() {
      if (this.validateInputs()) {
          this.service.addIncomeItem({
              label: this.desc,
              amount: this.amount,
              freqType: this.frequency,
              referenceDate: this.referenceDate,
              eventType: 'INC'
          }).subscribe(
            item => {
              console.log('Income item has been added.');
              this.router.navigateByUrl('/');
            },
            err => {
              console.log(err);
            }
          );
      }
  }

  validateInputs(): boolean {
      if (this.desc.length == 0) {
          this.errorMessage = 'Please enter a description for the income item.';
          return false;
      }
      if (this.amount <= 0) {
         this.errorMessage = 'Please enter a valid income amount.';
         return false;
      }
      if (this.frequency == undefined) {
         this.errorMessage = 'Please select a Frequency.';
         return false;
      }
      if (this.referenceDate == 'dd/mm/yyyy') {
          this.errorMessage = 'Please enter a valid reference date (eg. your last pay date).';
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
