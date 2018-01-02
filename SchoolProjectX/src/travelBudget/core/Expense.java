package travelBudget;

import java.util.ArrayList;

/**
 * This is a general purpose class that stores a set of {@code ExpenseHead}s.
 * 
 * @author rajobasu of SLS
 *
 */
public class Expense {
	private static Expense INSTANCE;

	public static final int DEF_VAL = 1000;
	private ArrayList<ExpenseHead> expenseHeads;
	private static ArrayList<String> headNames;

	static {
		headNames = new ArrayList<>();
		headNames.add("Lodging");
		headNames.add("Travel");
		headNames.add("Food");
		headNames.add("Sightseeing");
		headNames.add("Miscelleneous");
	}

	/**
	 * Create a new Expense object and create a set of {@code ExpenseHead}s for
	 * all the heads, along with a default value for them.
	 */
	public Expense() {
		expenseHeads = new ArrayList<>();

		for (String name : headNames) {
			expenseHeads.add(new ExpenseHead(name));
		}
	}

	/**
	 * 
	 * @return - The number of heads in the expenditure plan.
	 */
	public static int getHeadCount() {
		return headNames.size();
	}

	/**
	 * 
	 * @param choice
	 *            - The index of the {@code ExpenseHead} to return.
	 * @return The {@code ExpenseHead} asked for.
	 */
	public ExpenseHead getExpenseHead(int choice) {
		return expenseHeads.get(choice - 1);
	}

	/**
	 * 
	 * @return - A array of all the {@code ExpenseHead}s.
	 */
	public ArrayList<ExpenseHead> getExpenseHeads() {
		return expenseHeads;
	}

	/**
	 * 
	 * @param choice
	 *            - The index of the head name that is required.
	 * @return - The corresponding headname of the given index.
	 */
	public static String getHeadName(int choice) {
		return headNames.get(choice);
	}

	public void addNewHead(String s, int value) {
		headNames.add(s);
		ExpenseHead eh;
		expenseHeads.add(eh = new ExpenseHead(s));
		eh.updateBudgetedAmount(value);
	}

	public void removeHead(String s) {
		headNames.remove(s);
		//expenseHeads.remove(index);
	}
	
	public boolean hasTransactions(int i){
		return false;
	}

	public static Expense getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Expense();

		return INSTANCE;
	}
}
