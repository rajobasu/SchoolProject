package travelBudget;

import java.io.IOException;

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

	/**
	 * Create a {@code ExpenseEditor} object with the {@code ExpenseHead} object
	 * whose value has to be updated.
	 * 
	 * @param budgetHead
	 *            - The appropriate {@code ExpenseHead} object.
	 */
	public ExpenseEditor(ExpenseHead budgetHead) {
		this.budgetHead = budgetHead;
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
				return "Give a more reasonable value! ";
			}

			@Override
			public boolean isValid(int x) {
				return x >= 1000 && x < 100000;
			}
		});
		int amt = inputTaker.getInput(
				budgetHead.getHeadName() + "   ( Old amount: " + budgetHead.getAmount() + " )   New amount: ");
		budgetHead.setAmount(amt);
	}
}
