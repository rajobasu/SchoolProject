package travelBudget;

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
	private BudgetedExpense budgetedExpense;
	private ActualExpense actualExpense;

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
	public Report(BudgetedExpense budgetedExpense, ActualExpense actualExpense) {
		super();
		this.budgetedExpense = budgetedExpense;
		this.actualExpense = actualExpense;
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
		System.out.println("****************************************************");
		String formatString = "%-32s  %10d  %10d         %7.3f%%\n";
		System.out.printf("%-32s    Budgeted      Actual     Percentage Excess\n", "Head");
		System.out.println("------------------------------------------------------------");
		for (int i = 0; i < Expense.getHeadCount(); i++) {
			int val1 = budgetedExpense.getExpenseHead(i + 1).getAmount();
			int val2 = actualExpense.getExpenseHead(i + 1).getAmount();

			System.out.printf(formatString, Expense.getHeadName(i), val1, val2, calculatePercentage(val1, val2));
		}
	}

}
