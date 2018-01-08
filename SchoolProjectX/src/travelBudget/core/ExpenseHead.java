package travelBudget.core;

import java.util.LinkedList;

/**
 * This object encapsulates the basic block of a budget system -- A Expense
 * Head. It stores primarily 2 informations, the head name and the expenditure
 * under that head name.
 * 
 * @author rajob
 *
 */
public class ExpenseHead {
	public static final int TYPE_BUDGET_HEAD = -1423;
	public static final int TYPE_ACTUAL_HEAD = -4654;
	
	private String headName;
	private AmountType budgetedAmount;
	private AmountType actualAmount;

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
	public ExpenseHead(String headName) {
		super();
		this.headName = headName;

		budgetedAmount = new AmountType() {
			@Override
			public void updateAmount(int amount) {
				clear();
				super.updateAmount(amount);
			}
		};

		actualAmount = new AmountType();
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
		if (type == TYPE_ACTUAL_HEAD)
			updateActualAmount(amount, "");
		if (type == TYPE_BUDGET_HEAD)
			updateBudgetedAmount(amount);

		// System.out.println(type);
	}

	public void updateAmount(int amount, String details, int type) {
		if (type == TYPE_ACTUAL_HEAD)
			updateActualAmount(amount, details);
		if (type == TYPE_BUDGET_HEAD)
			updateBudgetedAmount(amount);

		// System.out.println(type);
	}

	public AmountType getAmountType(int type) {
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
