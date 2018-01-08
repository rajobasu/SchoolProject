package travelBudget.core;

import java.util.LinkedList;

public class AmountType {
	private LinkedList<Transaction> transactions;

	public AmountType() {
		transactions = new LinkedList<>();
	}

	public void updateAmount(int amount) {
		updateAmount(amount, "No Details.");
	}

	public void updateAmount(int amount, String details) {
		// System.out.println(" *** AMOUNT TO BE UPDATED : " + amount);
		// transactions.add(new Transaction(amount, details));
		updateAmount(new Transaction(amount, details));
	}

	public void updateAmount(Transaction txn) {
		// System.out.println(" *** AMOUNT TO BE UPDATED : " + amount);
		transactions.add(txn);
	}

	public void clear() {
		transactions.clear();
	}

	public int getAmount() {
		if (transactions.isEmpty())
			return ExpenseManager.DEF_VAL;

		int sum = 0;
		for (Transaction i : transactions) {
			sum += i.getAmount();
		}
		return sum;
	}

	public boolean isEmpty() {
		return transactions.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public LinkedList<Transaction> getAllTransactions() {
		return (LinkedList<Transaction>) transactions.clone();
	}
}
