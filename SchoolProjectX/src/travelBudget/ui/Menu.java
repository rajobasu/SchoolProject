package travelBudget.ui;

import java.io.IOException;

import travelBudget.core.Expense;
import travelBudget.core.ExpenseHead;

/**
 * This class keeps the progam running and process the choices given by the
 * user. This is the central location from which the program is managed.
 * 
 * @author rajob
 *
 */
public class Menu {
	private Expense expense;

	// private TourDetails tourDetails;
	/**
	 * Initializes the object to its default state. Not calling this method at
	 * the start may cause errors.
	 */
	public void init() {
		expense = new Expense();
	}

	/**
	 * The starting point of execution of the system. The user is prompted for
	 * action again and again until he exits.
	 * 
	 * @throws IOException
	 */
	public void execute() throws IOException {
		init();
		do {
			showMenu();
		} while (executeChoice());
	}

	/**
	 * Shows the Menu and the choice number associated which action.
	 */
	public void showMenu() {
		// System.out.println("\033[H\033[2J");
		System.out.flush();
		System.out.println("");
		// System.out.println("----------------------------------------------");
		System.out.println("==============================================");
		System.out.println(" Travel Budget System : Main Menu");
		System.out.println("==============================================");
		// System.out.println("********************************************* ");

		System.out.println("Choose : ");
		System.out.println("   1. Update Budgeted Expense");
		System.out.println("   2. Update Actual Expense");
		System.out.println("   3. Show Report");
		System.out.println("   4. Add New Head");
		System.out.println("   5. Remove Head");
		System.out.println("   6. Exit");
		System.out.println();
	}

	/**
	 * This method takes a choice and performs that action. The input is taken
	 * at first, and then the corresponding action is performed. It also passes
	 * back information on whether the user wants to exit.
	 * 
	 * @return - Whether the user wants to exit.
	 * @throws IOException
	 */
	public boolean executeChoice() throws IOException {
		InputTaker inputTaker = new InputTaker(new Validator() {
			@Override
			public boolean isValid(int x) {
				return x > 0 && x < 7;
			}

			@Override
			public String getErrorMessage() {
				// TODO Auto-generated method stub
				return super.getErrorMessage();
			}

		});
		int choice = inputTaker.getInputInt("Enter the choice : ");

		switch (choice) {
		case 1:
			updateBudgetedExpense();
			break;
		case 2:
			updateActualExpense();
			break;
		case 3:
			showReport();
			break;
		case 4:
			String headName = inputTaker.getInputString("Enter name of new head : ");
			int initVal = new InputTaker().getInputInt("Enter initial amount : ", Expense.DEF_VAL);
			expense.addNewHead(headName, initVal);
			break;
		case 5:
			/*int index = new InputTaker(new Validator() {
				@Override
				public boolean isValid(int x) {
					if (x == -1)
						return true;
					return x > 0 && x <= Expense.getHeadCount();
				}
			}).getInputInt("Enter head name to delete : ");*/
			//xpense.removeHead(index - 1);
			break;
		case 6:
			return false;

		}

		return true;
	}

	/**
	 * Update the budgeted expense in a manner that the user wants. Includes
	 * prompting, taking input, and updating the actual value.
	 * 
	 * @throws IOException
	 */
	public void updateBudgetedExpense() throws IOException {
		BudgetUpdate budgetUpdate = new BudgetUpdate(expense, ExpenseHead.TYPE_BUDGET_HEAD);
		do {
			budgetUpdate.showExpenseHeads();
		} while (budgetUpdate.executeUserChoice());
	}

	/**
	 * Update the actual expense in a manner that the user wants. Includes
	 * prompting, taking input, and updating the actual value.
	 * 
	 * @throws IOException
	 */
	public void updateActualExpense() throws IOException {
		BudgetUpdate budgetInput = new BudgetUpdate(expense, ExpenseHead.TYPE_ACTUAL_HEAD);
		do {
			budgetInput.showExpenseHeads();
		} while (budgetInput.executeUserChoice());
	}

	/**
	 * Show the report of the current state of the budget plan as given by the
	 * budgeted and actual expense.
	 */
	public void showReport() {
		// System.out.println("In Show report");
		new Report(expense).showTabular();
	}
}
