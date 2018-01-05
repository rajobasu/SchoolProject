package travelBudget.ui;

import java.io.IOException;
import java.util.ArrayList;

import travelBudget.core.ExpenseManager;
import travelBudget.core.ExpenseHead;

/**
 * This class keeps the progam running and process the choices given by the
 * user. This is the central location from which the program is managed.
 * 
 * @author rajob
 *
 */
public class Menu {
	private ExpenseManager expense;
	public final int MENU_EXIT = 9;

	// private TourDetails tourDetails;
	/**
	 * Initializes the object to its default state. Not calling this method at
	 * the start may cause errors.
	 */
	public void init() {
		expense = new ExpenseManager();
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
		System.out.println("   2. Enter Actual Expense");
		System.out.println("   3. Show Report");
		System.out.println("   4. Show Actual Expenses");
		System.out.println("   5. Add New Head");
		System.out.println("   6. Remove Head");
		System.out.println("   9. Exit");
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
				return x > 0 && x < (MENU_EXIT + 1);
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
			showActualExpensesDetail();
			break;
		case 5:
			addNewExpenseHead();
			break;
		case 6:
			removeExpenseHead();
			break;
		case MENU_EXIT:
			return false;

		}

		return true;
	}

	public void removeExpenseHead() throws IOException {
		InputTaker inputTaker = new InputTaker();
		ArrayList<String> headNames = expense.getHeadNames();
		int i = 1;
		
		System.out.println("");
		System.out.println("==============================================");
		System.out.println(" Travel Budget System : Remove Expense Head");
		System.out.println("==============================================");
		System.out.println("");
		System.out.println(" Expense Heads");
		
		
		for (String n : headNames) {
			System.out.println("    "+ i + ". " + n);
			i++;
		}
		System.out.println();

		int index = new InputTaker(new Validator() {
			@Override
			public boolean isValid(int x) {
				if (x == -1)
					return true;
				return x > 0 && x <= headNames.size();
			}
		}).getInputInt("Enter head name to delete (-1 to exit): ");
		if (index != -1) {
			if (expense.removeHead(headNames.get(index - 1))) {
				System.out.println("Info: Expense Head removed successfully.");
			} else {
				System.out.println("Error: Expense Head could not be removed ("+expense.getLastErrorMessage()+").");

			}
		}

	}

	public void addNewExpenseHead() throws IOException {
		InputTaker inputTaker = new InputTaker();
		
		System.out.println("");
		System.out.println("==============================================");
		System.out.println(" Travel Budget System : Add New Expense Head");
		System.out.println("==============================================");
		System.out.println("");

		String headName = inputTaker.getInputString("   Enter name of new head : ");
		int initVal = new InputTaker().getInputInt("   Enter initial amount : ", ExpenseManager.DEF_VAL);
		if(expense.addNewHead(headName, initVal))
		{
			System.out.println("Info: Expense Head added successfully.");
		} else {
			System.out.println("Error: Expense Head could not be added ("+expense.getLastErrorMessage()+").");

		}

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

	public void showActualExpensesDetail() throws IOException {
		new Report(expense).showActualExpensesDetail();

	}

}
