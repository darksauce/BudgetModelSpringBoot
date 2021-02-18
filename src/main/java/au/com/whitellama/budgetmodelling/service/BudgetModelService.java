package au.com.whitellama.budgetmodelling.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.whitellama.budgetmodelling.dao.BudgetModelDataAccess;
import au.com.whitellama.budgetmodelling.model.BudgetEvent;
import au.com.whitellama.budgetmodelling.model.Expense;
import au.com.whitellama.budgetmodelling.model.FrequencyType;
import au.com.whitellama.budgetmodelling.model.Income;

@Service
public class BudgetModelService {

	private BudgetModelDataAccess budgetModelDao;
	
	@Autowired
	public BudgetModelService(BudgetModelDataAccess dao) {
		this.budgetModelDao = dao;
	}

	public void addIncome(Income income) {
		
	}

	public void addExpense(Expense expense) {
		
	}

	public List<BudgetEvent> getBudgetEvents() {
		
		List<BudgetEvent> list = new ArrayList<BudgetEvent>();
		list.add(new Income("Pay", 1000.0, FrequencyType.FREQ_FORTNIGHTLY, "11/02/2021"));
		list.add(new Expense("Netflix", 15.0, FrequencyType.FREQ_MONTHLY, "01/02/2021"));
		
		return list;
	}
}
