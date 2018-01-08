package travelBudget.ui;

import travelBudget.core.ExpenseManager;

import java.io.IOException;

import travelBudget.core.ExpenseHead;
import travelBudget.core.Transaction;

/**
 * This class is used to print a report of the budget that the user has made and
 * a comparison between the budgeted expenses and the actual expense that he has
 * spent. The methods of this class can be called multiple times after it has
 * been set up with the desired {@code BudgetedExpense} and
 * {@code ActualExpense} objects. The queries will always reflect the current
 * state of the objects.
 * 
 * @author rajob
 *
 */
public class Report {
	private ExpenseManager expenseMgr;

	/**
	 * Create a new {@code Report} object from the budgeted and actual expenses
	 * that the user has enrolled.
	 * 
	 * @param budgetedExpense
	 *            - A reference of the {@code BudgetedExpense} that stores the
	 *            initial budget.
	 * @param actualExpense
	 *            - A reference of the {@code ActualExpense} that stores the
	 *            actual expenses incurred.
	 */
	public Report(ExpenseManager expenseMgr) {
		this.expenseMgr = expenseMgr;
	}

	/**
	 * This method calculates the percentage of increase or decrease between 2
	 * given value.
	 * 
	 * @param val1
	 *            - The initial value
	 * @param val2
	 *            - The value whose increase percentage has to be calculated.
	 * @return The percentage increase of the second value over the first value.
	 *         In case it has decreased, the answer will be in negetive.
	 */
	private double calculatePercentage(int val1, int val2) {

		if (val1 == 0)
			return 0;
		int excess = val2 - val1;
		return excess * 100.0 / val1;
	}

	/**
	 * This method, when called, shows the budgeted expense, actual expense and
	 * the percentage of increase or decrease on all the budget heads. This can
	 * be called multiple times on the same object and the output will change
	 * depending on the state of the paramaters ( that had been passed to this
	 * object at the time of creation ) at the time of invokation.
	 */
	public void showTabular() {
		int totalBudget = 0;
		int totalActual = 0;
		System.out.println("");
		// System.out.println("----------------------------------------------");
		System.out.println("==============================================");
		System.out.println(" Travel Budget System : Report");
		System.out.println("==============================================");
		System.out.println();

		// System.out.printf("%-25s %-8s \n", "Head", " Amount");
		// System.out.printf("%-25s %-8s \n", "-------------------------",
		// "--------");

		// System.out.println("****************************************************");
		String formatString = "%-25s  %8d  %8d  %7.1f %% \n";
		System.out.printf("%-25s  Budgeted    Actual  Deviation\n", "Head");
		System.out.println("-------------------------  --------  --------  --------- ");
		for (ExpenseHead head : expenseMgr.getExpenseHeads()) {
			int val1 = head.getBudgetedAmount();
			int val2 = head.getActualAmount();
			String name = head.getHeadName();
			totalBudget += val1;
			totalActual += val2;
			System.out.printf(formatString, name, val1, val2, calculatePercentage(val1, val2));
		}
		System.out.println("-------------------------  --------  --------  ---------");
		System.out.printf(formatString, "Total", totalBudget, totalActual,
				calculatePercentage(totalBudget, totalActual));
		System.out.println("=========================  ========  ========  =========");
		System.out.println();

	}

	/**
	 * transaction
	 * 
	 * @throws IOException
	 */
	public void showActualExpensesDetail() {
		InputTaker taker = new InputTaker();
		int totalActual = 0;
		System.out.println("");
		// System.out.println("----------------------------------------------");
		System.out.println("==============================================");
		System.out.println(" Travel Budget System : Actual Expense Report");
		System.out.println("==============================================");
		System.out.println();

		// System.out.printf("%-25s %-8s \n", "Head", " Amount");
		// System.out.printf("%-25s %-8s \n", "-------------------------",
		// "--------");

		// System.out.println("****************************************************");
		// String formatString = "%-25s %8d %-50s\n";
		// System.out.printf("%-25s Actual Exp Details \n", "Head");
		// System.out.println("------------------------- -------- --------
		// --------- ");
		System.out.println("Head                         Amount  Details ");
		System.out.println("-------------------------  --------  --------------------");

		for (ExpenseHead head : expenseMgr.getExpenseHeads()) {
			int amount = head.getActualAmount();
			String name = head.getHeadName();
			System.out.println("\nHead Name: " + name);
			for (Transaction txn : head.getActualTransactions()) {
				System.out.printf("%-25s  %8d  %-50s", "", txn.getAmount(), txn.getDetails());
				System.out.println();
			}
			System.out.printf("%-25s  %8d", "Total Amount:", amount);
			System.out.println();
			totalActual += amount;
		}
		System.out.println("-------------------------  --------  --------  ---------");
		System.out.printf("%-25s  %8d\n", "Total", totalActual);
		System.out.println("=========================  ========  ========  =========");
		System.out.println();

		taker.getInputString("Press Enter to continue...");
	}
}
