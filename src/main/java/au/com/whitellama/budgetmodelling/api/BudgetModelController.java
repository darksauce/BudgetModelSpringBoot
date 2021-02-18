package au.com.whitellama.budgetmodelling.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.whitellama.budgetmodelling.model.BudgetEvent;
import au.com.whitellama.budgetmodelling.model.Expense;
import au.com.whitellama.budgetmodelling.model.Income;
import au.com.whitellama.budgetmodelling.service.BudgetModelService;

@RequestMapping("api/v1/budget")
@RestController
public class BudgetModelController {

	private final BudgetModelService budgetModelService;
	
	@Autowired
	public BudgetModelController(BudgetModelService budgetModelService) {
		this.budgetModelService = budgetModelService;
	}
	
	@GetMapping
	public List<BudgetEvent> getBudgetEvents() {
		return this.budgetModelService.getBudgetEvents();
	}
	
	@PostMapping("income")
	public void addIncome(@RequestBody Income income) {
		budgetModelService.addIncome(income);
	}
	
	@PostMapping("expense")
	public void addExpense(@RequestBody Expense expense) {
		budgetModelService.addExpense(expense);
	}
}
