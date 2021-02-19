package au.com.whitellama.budgetmodelling.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Budget Event super class, for income or expense events.
 */
public abstract class BudgetEvent {

	public static final String TYPE_INCOME  = "INC";
	public static final String TYPE_EXPENSE = "EXP";
	
	private static final SimpleDateFormat dateFmt = new SimpleDateFormat("d/M/yyyy");
	
	private final String eventType;
	
	public BudgetEvent(String eventType) {
		this.eventType = eventType;
	}

	public String getEventType() {
		return eventType;
	}

	public abstract String getReferenceDate();
	
	public abstract String getFreqType();
	
	public boolean isOccurringOn(Date thisDate) {
		try {
			boolean passed = false;
			int direction = 1; // skip forward
			Date refDate = getParsedReferenceDate();
			if (thisDate.before(refDate)) {
				direction = -1; // skip backward
			}
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(refDate);
			
			while (!passed) {
				if (cal.getTime().equals(thisDate)) {
					return true;
				}
				
				if (getFreqType().equals(FrequencyType.FREQ_DAILY)) {
					cal.add(Calendar.DATE, direction);
				}
				else if (getFreqType().equals(FrequencyType.FREQ_WEEKLY)) {
					cal.add(Calendar.DATE, 7 * direction);
				}
				else if (getFreqType().equals(FrequencyType.FREQ_FORTNIGHTLY)) {
					cal.add(Calendar.DATE, 14 * direction);
				}
				else if (getFreqType().equals(FrequencyType.FREQ_MONTHLY)) {
					cal.add(Calendar.MONTH, 1 * direction);
				}
				else if (getFreqType().equals(FrequencyType.FREQ_QUARTERLY)) {
					cal.add(Calendar.MONTH, 3 * direction);
				}
				else if (getFreqType().equals(FrequencyType.FREQ_SIX_MONTHLY)) {
					cal.add(Calendar.MONTH, 6 * direction);
				}
				else if (getFreqType().equals(FrequencyType.FREQ_YEARLY)) {
					cal.add(Calendar.YEAR, direction);
				}
				
				if (direction == 1) { // forward
					passed = cal.getTime().after(thisDate);
				}
				else { // backward
					passed = cal.getTime().before(thisDate);
				}
			}
		}
		catch (ParseException ex) {
			// Log it here?
		}
		
		return false;
	}
	
	@JsonIgnore
	public Date getParsedReferenceDate() throws ParseException {
		String strDate = getReferenceDate();
		return dateFmt.parse(strDate);
	}
	
}
