package au.com.whitellama.budgetmodelling.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Income extends BudgetEvent {

	private final String label;
	private final double amount;
	private final String freqType; // weekly, monthly, etc
	private final String referenceDate;
	
	public Income(@JsonProperty("label") String label, 
			      @JsonProperty("amount") double amount, 
			      @JsonProperty("freqType") String freqType, 
			      @JsonProperty("referenceDate") String referenceDate) {
		super(TYPE_INCOME);
		
		this.label = label;
		this.amount = amount;
		this.freqType = freqType;
		this.referenceDate = referenceDate;
	}

	public String getLabel() {
		return label;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getFreqType() {
		return freqType;
	}
	
	public String getReferenceDate() {
		return referenceDate;
	}
	
}
