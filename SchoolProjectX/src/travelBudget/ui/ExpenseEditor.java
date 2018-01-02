package travelBudget.ui;

import java.io.IOException;

import travelBudget.core.ExpenseHead;

/**
 * This class Edits the expense of a particular {@code ExpenseHead}.
 * 
 * @see ExpenseHead
 * 
 * @author rajob
 *
 */
public class ExpenseEditor {

	private ExpenseHead budgetHead;
	private final int type;

	/**
	 * Create a {@code ExpenseEditor} object with the {@code ExpenseHead} object
	 * whose value has to be updated.
	 * 
	 * @param budgetHead
	 *            - The appropriate {@code ExpenseHead} object.
	 */
	public ExpenseEditor(ExpenseHead budgetHead, int type) {
		this.budgetHead = budgetHead;
		this.type = type;
	}

	/**
	 * This method updates the value of the particular {@code ExpenseHead} that
	 * was passes at the time of creation.
	 * 
	 * @throws IOException
	 */
	public void updateValue() throws IOException {
		InputTaker inputTaker = new InputTaker(new Validator() {

			@Override
			public String getErrorMessage() {
				// TODO Auto-generated method stub
				return "Info: Enter value from 100 to 10000000";
			}

			@Override
			public boolean isValid(int x) {
				return x >= 100 && x < 10000000;
			}
		});
		int amt = inputTaker.getInputInt(
				budgetHead.getHeadName() + "   ( Old amount: " + budgetHead.getAmount(type) + " )   New amount: ",
				budgetHead.getAmount(type));

		budgetHead.updateAmount(amt, type);
	}
}
