package au.com.whitellama.budgetmodelling.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import au.com.whitellama.budgetmodelling.model.BudgetEvent;
import au.com.whitellama.budgetmodelling.model.Expense;
import au.com.whitellama.budgetmodelling.model.Income;

@Repository
public class BudgetModelDataAccess {

	private static List<BudgetEvent> eventList = new ArrayList<BudgetEvent>();
	
	public void addIncome(Income income) {
		if (eventList.stream()
		             .filter(evt -> evt.getEventType().equals(BudgetEvent.TYPE_INCOME))
		             .noneMatch(inc -> ((Income)inc).getLabel().equals(income.getLabel()))) {
			eventList.add(income);
		}
	}

	public void addExpense(Expense expense) {
		if (eventList.stream()
		             .filter(evt -> evt.getEventType().equals(BudgetEvent.TYPE_EXPENSE))
		             .noneMatch(inc -> ((Income)inc).getLabel().equals(expense.getLabel()))) {
			eventList.add(expense);
		}
	}

	public List<BudgetEvent> getBudgetEvents() {
		return eventList;
	}
}
