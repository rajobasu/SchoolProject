package travelBudget.core;

import java.util.LinkedList;

/**
 * Stores all the {@code Transaction}s
 * 
 * @author rajarshibasu
 *
 */
public class Expense {
	private LinkedList<Transaction> transactions;

	/**
	 * Initializes the object.
	 */
	Expense() {
		transactions = new LinkedList<>();
	}

	public void updateAmount(int amount) {
		updateAmount(amount, "No Details.");
	}

	public void updateAmount(int amount, String details) {
		updateAmount(new Transaction(amount, details));
	}

	public void updateAmount(Transaction txn) {
		transactions.add(txn);
	}

	public void clear() {
		transactions.clear();
	}

	/**
	 * Calculate the total amount of all the {@code Transaction}s present.
	 * 
	 * @return - Total value of all {@code Transaction}s.
	 */
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
