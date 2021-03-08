package au.com.whitellama.budgetmodelling.calc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import au.com.whitellama.budgetmodelling.model.BudgetEvent;
import au.com.whitellama.budgetmodelling.model.Expense;
import au.com.whitellama.budgetmodelling.model.FinancialSummary;
import au.com.whitellama.budgetmodelling.model.Income;

@Component
public class BudgetCalculator {

	public List<FinancialSummary> calculateData(List<BudgetEvent> eventList, double startBalance, int numDays) {
		double[] dayBalance = new double[numDays];
		
		SimpleDateFormat fmt = new SimpleDateFormat("d/M/yyyy");
		Calendar runningCal = Calendar.getInstance();
		runningCal.set(Calendar.MILLISECOND, 0);
		runningCal.set(Calendar.SECOND, 0);
		runningCal.set(Calendar.MINUTE, 0);
		runningCal.set(Calendar.HOUR_OF_DAY, 0);
		Date startDate = runningCal.getTime();
		
		List<FinancialSummary> finSummaryList = new ArrayList<FinancialSummary>();
		double runningBalance = startBalance;
		
		for (int d = 0; d < numDays; d++) {
			int day = d + 1;
			
			Date runningDate = runningCal.getTime();
			FinancialSummary finSum = new FinancialSummary();
			finSummaryList.add(finSum);
			finSum.setLabel(fmt.format(runningDate));
			
			if (day == 1) {
				dayBalance[d] = startBalance;
				calculateBalanceModifier(startDate, eventList, finSum);
				finSum.setBalance(startBalance);
			}
			else {
				double balModifier = calculateBalanceModifier(runningDate, eventList, finSum);
				
				runningBalance += balModifier;
				dayBalance[d] = runningBalance;
				finSum.setBalance(runningBalance);
			}
			
			runningCal.add(Calendar.DATE, 1);
		}
		
		return finSummaryList;
	}
	
	private double calculateBalanceModifier(Date thisDate, List<BudgetEvent> evList, FinancialSummary finSum) {
		double modifier = 0.0;
		for (BudgetEvent event: evList) {
			if (event.isOccurringOn(thisDate)) {
				if (event.getEventType().equals(BudgetEvent.TYPE_INCOME)) {
					Income inc = (Income) event;
					finSum.setIncome(finSum.getIncome() + inc.getAmount());
					appendEventName(finSum, inc.getLabel());
					modifier += inc.getAmount();
				}
				else if (event.getEventType().equals(BudgetEvent.TYPE_EXPENSE)) {
					Expense exp = (Expense) event;
					finSum.setExpense(finSum.getExpense() + exp.getAmount());
					appendEventName(finSum, exp.getLabel());
					modifier -= exp.getAmount();
				}
			}
		}
		return modifier;
	}

	private void appendEventName(FinancialSummary finSum, String label) {
		int spos = finSum.getLabel().indexOf('-');
		if (spos > 0) {
			finSum.setLabel(finSum.getLabel() + ", " + label);
		}
		else {
			finSum.setLabel(finSum.getLabel() + " - " + label);
		}
	}
}
