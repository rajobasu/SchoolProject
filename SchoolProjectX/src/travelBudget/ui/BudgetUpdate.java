package travelBudget.ui;

import java.io.IOException;

import travelBudget.core.ExpenseManager;
import travelBudget.core.ExpenseHead;

/**
 * Handles a budget update operation. It changes the {@code Expense} that is
 * passed when this object is created.
 * 
 * @author rajob
 *
 */
public class BudgetUpdate {
	private ExpenseManager expense;
	private int type;

	/**
	 * 
	 * @param expense
	 */
	public BudgetUpdate(ExpenseManager expense, int type) {
		super();
		this.expense = expense;
		this.type = type;
	}

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

	public boolean executeUserChoice() throws IOException {
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
		} else {
			ExpenseEditor ed = new ExpenseEditor(expense.getExpenseHead(choice), type);
			ed.updateValue();
		}
		return true;
	}
}