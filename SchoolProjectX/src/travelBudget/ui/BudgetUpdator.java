package travelBudget.ui;

import travelBudget.core.ExpenseHead;
import travelBudget.core.ExpenseManager;

/**
 * Handles a budget update operation. It changes the {@code Expense} that is
 * passed when this object is created.
 * 
 * @author rajob
 *
 */
public class BudgetUpdator {
	private ExpenseManager expense;
	private int type;

	/**
	 * 
	 * @param expense
	 */
	public BudgetUpdator(ExpenseManager expense, int type) {
		this.expense = expense;
		this.type = type;
	}

	/**
	 * Prints the heading corresponding to the {@code type}
	 */
	protected void printHeading() {
		if (type == ExpenseHead.TYPE_BUDGET_HEAD) {
			// System.out.println("\f");
			// System.out.println("*******************************************************");
			System.out.println("");
			// System.out.println("----------------------------------------------");
			System.out.println("==============================================");
			System.out.println(" Travel Budget System : Update Budget");
			System.out.println("==============================================");
			// System.out.println("*********************************************
			// ");
		}
		if (type == ExpenseHead.TYPE_ACTUAL_HEAD) {
			System.out.println("");
			System.out.println("==============================================");
			System.out.println(" Travel Budget System : Update Actual");
			System.out.println("==============================================");
		}

	}

	/**
	 * Show all the {@code ExpenseHead}s and their respective amounts Also show
	 * the total amount.
	 */
	public void showExpenseHeads() {
		printHeading();

		System.out.printf("%-25s   %-8s \n", "Head", "  Amount");
		System.out.printf("%-25s   %-8s \n", "-------------------------", "--------");
		int i = 0;
		int totalAmt = 0;
		for (ExpenseHead head : expense.getExpenseHeads()) {
			System.out.printf(++i + " %-25s %8d \n", head.getHeadName(), head.getAmount(type));
			totalAmt += head.getAmount(type);
		}
		System.out.println();
		System.out.printf("%-25s   %8d \n", "Total Amount", totalAmt);
		System.out.println();

	}

	/**
	 * Take the choice from the user and update the required
	 * {@code ExpenseHead}.
	 * 
	 * @return - whether or not to exit.
	 */
	public boolean executeUserChoice() {
		InputTaker inputTaker = new InputTaker(new Validator() {
			@Override
			public String getErrorMessage() {
				return "Error: The choice you entered is invalid !";
			}

			@Override
			public boolean isValid(int x) {
				if (x == -1)
					return true;

				if (x < 1)
					return false;
				if (x > ExpenseManager.getHeadCount())
					return false;

				return true;
			}
		});

		int choice = inputTaker.getInputInt("Enter which value to update (<-1> to exit) :");

		if (choice == -1) {
			return false;
		}
		ExpenseEditor ed = new ExpenseEditor(expense.getExpenseHead(choice), type);
		ed.updateValue();

		return true;
	}
}
