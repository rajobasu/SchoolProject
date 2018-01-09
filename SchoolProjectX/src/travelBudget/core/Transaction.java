package travelBudget.core;

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
