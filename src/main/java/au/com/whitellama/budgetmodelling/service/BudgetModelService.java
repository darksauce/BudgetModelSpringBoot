package au.com.whitellama.budgetmodelling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.whitellama.budgetmodelling.dao.BudgetModelDataAccess;
import au.com.whitellama.budgetmodelling.model.BudgetEvent;
import au.com.whitellama.budgetmodelling.model.Expense;
import au.com.whitellama.budgetmodelling.model.Income;

@Service
public class BudgetModelService {

	private BudgetModelDataAccess budgetModelDao;
	
	@Autowired
	public BudgetModelService(BudgetModelDataAccess dao) {
		this.budgetModelDao = dao;
	}

	public void addIncome(Income income) {
		budgetModelDao.addIncome(income);
	}

	public void addExpense(Expense expense) {
		budgetModelDao.addExpense(expense);
	}

	public List<BudgetEvent> getBudgetEvents() {
		return budgetModelDao.getBudgetEvents();
	}
}
