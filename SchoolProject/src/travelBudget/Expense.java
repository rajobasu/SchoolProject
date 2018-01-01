package travelBudget;

/**
 * This is a general purpose class that stores a set of {@code ExpenseHead}s.
 * 
 * @author rajob
 *
 */
public class Expense {
	private ExpenseHead[] expenseHeads;
	// public static final int HEAD_COUNT = ;

	private static String[] headNames = { "Lodging", "Travel", "Food ", "Sightseeing", "Miscelleneous" ,"1234567890123456789012345"};
	private static int headCount;

	static {
		headCount = headNames.length;
	}

	/**
	 * Create a new Expense object and create a set of {@code ExpenseHead}s for
	 * all the heads, along with a default value for them.
	 */
	public Expense() {
		expenseHeads = new ExpenseHead[headCount];

		for (int i = 0; i < headCount; i++) {
			expenseHeads[i] = new ExpenseHead(headNames[i], 1000);
		}
	}

	/**
	 * 
	 * @return - The number of heads in the expenditure plan.
	 */
	public static int getHeadCount() {
		return headCount;
	}

	/**
	 * 
	 * @param choice
	 *            - The index of the {@code ExpenseHead} to return.
	 * @return The {@code ExpenseHead} asked for.
	 */
	public ExpenseHead getExpenseHead(int choice) {
		return expenseHeads[choice - 1];
	}

	/**
	 * 
	 * @return - A array of all the {@code ExpenseHead}s.
	 */
	public ExpenseHead[] getExpenseHeads() {
		return expenseHeads;
	}

	/**
	 * 
	 * @param choice
	 *            - The index of the head name that is required.
	 * @return - The corresponding headname of the given index.
	 */
	public static String getHeadName(int choice) {
		return headNames[choice];
	}
}
