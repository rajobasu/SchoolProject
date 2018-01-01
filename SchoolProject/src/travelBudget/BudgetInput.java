package travelBudget;

import java.io.IOException;

/**
 * Handles a budget update operation. It changes the {@code Expense} that is
 * passed when this object is created.
 * 
 * @author rajob
 *
 */
public class BudgetInput {
	private Expense expense;
	/**
	 * 
	 * @param expense
	 */
	public BudgetInput(Expense expense) {
		super();
		this.expense = expense;
	}

	public void showExpenseHeads() {
		System.out.println("\f");
		System.out.println("*******************************************************");
		System.out.printf("%-32s         %8s \n", "Head", "Amount");
		System.out.printf("%-32s         %8s \n", "--------------------", "--------");
		int i = 0;
		for (ExpenseHead head : expense.getExpenseHeads()) {
			System.out.printf(++i + " %-32s         %8d \n", head.getHeadName(), head.getAmount());
		}
		System.out.println();
	}

	public boolean executeUserChoice() throws IOException {
		InputTaker inputTaker = new InputTaker(new Validator() {
			@Override
			public String getErrorMessage() {
				return "The choice you entered is invalid !s";
			}

			@Override
			public boolean isValid(int x) {
				if (x == -1)
					return true;

				if (x < 1)
					return false;
				if (x > Expense.getHeadCount())
					return false;

				return true;
			}
		});

		int choice = inputTaker.getInput("Enter which value to update (<-1> to exit) :");

		if (choice == -1) {
			return false;
		} else {
			ExpenseEditor ed = new ExpenseEditor(expense.getExpenseHead(choice));
			ed.updateValue();
		}
		return true;
	}
}
