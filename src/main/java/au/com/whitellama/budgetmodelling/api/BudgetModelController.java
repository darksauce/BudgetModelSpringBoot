package au.com.whitellama.budgetmodelling.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.whitellama.budgetmodelling.calc.BudgetCalculator;
import au.com.whitellama.budgetmodelling.model.BudgetEvent;
import au.com.whitellama.budgetmodelling.model.Expense;
import au.com.whitellama.budgetmodelling.model.FinancialSummary;
import au.com.whitellama.budgetmodelling.model.Income;
import au.com.whitellama.budgetmodelling.service.BudgetModelService;

@CrossOrigin(origins = "http://localhost:4200") // allow local angular client
@RequestMapping("api/v1/budget")
@RestController
public class BudgetModelController {

	private final BudgetModelService budgetModelService;
	private final BudgetCalculator   budgetCalculator;
	
	@Autowired
	public BudgetModelController(BudgetModelService budgetModelService, BudgetCalculator budgetCalculator) {
		this.budgetModelService = budgetModelService;
		this.budgetCalculator = budgetCalculator;
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
	
	@GetMapping(path = {"model", "model/{startingBalance}" })
	public List<FinancialSummary> getModelling(@PathVariable Optional<Double> startingBalance) {
	    // @PathVariable(required = false) is an alternative to the above...
		Double startBalance = startingBalance.isPresent() ? startingBalance.get() : 0.0;
		
		return budgetCalculator.calculateData(getBudgetEvents(), startBalance, 30);
	}
}
