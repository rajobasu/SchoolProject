package travelBudget.core;

/**
 * Corresponds to a unit of transaction, and contains a amount and some details.
 * 
 * @author Rajarshi Basu, Samaroha Ghosh class - X B.
 *
 *
 */
public class Transaction {
	private int amount;
	private String details;

	Transaction(int amount, String details) {
		super();
		this.amount = amount;
		this.details = details;
	}

	public int getAmount() {
		return amount;
	}

	public String getDetails() {
		return details;
	}

}
