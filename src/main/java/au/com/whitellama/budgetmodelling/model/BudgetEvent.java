package au.com.whitellama.budgetmodelling.model;

/**
 * Budget Event marker interface, for income or expense events.
 */
public class BudgetEvent {

	public static final String TYPE_INCOME  = "INC";
	public static final String TYPE_EXPENSE = "EXP";
	
	private final String eventType;
	
	public BudgetEvent(String eventType) {
		this.eventType = eventType;
	}

	public String getEventType() {
		return eventType;
	}
	
}
