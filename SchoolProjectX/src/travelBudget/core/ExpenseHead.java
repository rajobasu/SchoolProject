package travelBudget.core;

import java.util.LinkedList;

/**
 * This object encapsulates the basic block of a budget system -- A Expense
 * Head. It stores primarily 2 informations, the head name and the expenditure
 * under that head name.
 * 
 * @author Rajarshi Basu, Samaroha Ghosh class - X B.
 *
 *
 */

public class ExpenseHead {
	public static final int TYPE_BUDGET_HEAD = -1423;
	public static final int TYPE_ACTUAL_HEAD = -4654;

	private String headName;
	private Expense budgetedAmount;
	private Expense actualAmount;

	/**
	 * Create a new {@code ExpenseHead} object from the {@code headName} and the
	 * {@code amount} passed in as parameter.
	 * 
	 * @param headName
	 *            - The name of the head for which this object stores the
	 *            information.
	 * @param amount
	 *            - The amount spent under that head.
	 */
	ExpenseHead(String headName) {

		this.headName = headName;

		budgetedAmount = new Expense() {
			@Override
			public void updateAmount(int amount) {
				clear();
				super.updateAmount(amount);
			}
		};

		actualAmount = new Expense();
	}

	/**
	 * @return the headName
	 */
	public String getHeadName() {
		return headName;
	}

	/**
	 * @param headName
	 *            the headName to set
	 */
	public void setHeadName(String headName) {
		this.headName = headName;
	}

	/**
	 * @return the amount
	 */
	public int getBudgetedAmount() {
		return budgetedAmount.getAmount();
	}

	public int getActualAmount() {
		return actualAmount.getAmount();
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void updateBudgetedAmount(int amount) {
		budgetedAmount.updateAmount(amount);
	}

	public void updateActualAmount(int amount, String details) {
		actualAmount.updateAmount(amount, details);
	}

	/**
	 * Calculates the required amount.
	 * 
	 * @param type
	 *            - Whether the required amount is of budget and actual.
	 * @return - the amount
	 */
	public int getAmount(int type) {
		if (type == TYPE_BUDGET_HEAD)
			return getBudgetedAmount();
		else if (type == TYPE_ACTUAL_HEAD) {
			return getActualAmount();
		} else {
			return -1;
		}
	}

	public void updateAmount(int amount, int type) {
		updateAmount(amount, "", type);
	}

	/**
	 * Update the amount corresponding to the {@code type}.
	 * 
	 * @param amount
	 *            - The amount to update
	 * @param details
	 *            - The details of the transaction.
	 * @param type
	 *            - The type of {@code Expense} to update.
	 */
	public void updateAmount(int amount, String details, int type) {
		if (type == TYPE_ACTUAL_HEAD)
			updateActualAmount(amount, details);
		if (type == TYPE_BUDGET_HEAD)
			updateBudgetedAmount(amount);
	}

	/**
	 * 
	 * @param type
	 * @return - {@code Expense} corresponding to the given {@code type}.
	 */

	public Expense getAmountType(int type) {
		if (type == TYPE_ACTUAL_HEAD)
			return actualAmount;
		if (type == TYPE_BUDGET_HEAD)
			return budgetedAmount;
		return null;
	}

	public LinkedList<Transaction> getActualTransactions() {
		return actualAmount.getAllTransactions();
	}

}
