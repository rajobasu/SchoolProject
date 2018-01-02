package travelBudget;

import java.util.LinkedList;

public class ExpenseCategory {
	private LinkedList<Integer> amounts;

	public ExpenseCategory() {
		amounts = new LinkedList<>();
	}

	public void updateAmount(int amount) {
		// System.out.println(" *** AMOUTN TO BE UPDATED : " + amount);
		amounts.add(amount);
	}

	public void clear() {
		amounts.clear();
	}

	public int getAmount() {
		if (amounts.isEmpty())
			return Expense.DEF_VAL;
		int sum = 0;
		for (int i : amounts) {
			sum += i;
		}
		return sum;
	}

	public boolean isEmpty() {
		return amounts.isEmpty();
	}
}
