package travelBudget.core;

import java.util.ArrayList;

/**
 * This is a general purpose class that stores a set of {@code ExpenseHead}s.
 * 
 * @author rajobasu of SLS
 *
 */
public class ExpenseManager {
	private static ExpenseManager INSTANCE;

	public static final int DEF_VAL = 0;
	private ArrayList<ExpenseHead> expenseHeads;
	private static ArrayList<String> headNames;

	private String errorMsg;
	protected TourDetails tourDetails = new TourDetails();

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
	public ExpenseManager() {
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

	public ArrayList<String> getHeadNames() {

		return headNames;
	}

	protected void setErrorMessage(String msg) {
		errorMsg = msg;
	}

	public String getLastErrorMessage() {
		return errorMsg;

	}

	public boolean addNewHead(String s, int value) {
		
		if (headNames.contains(s)) {
			// head name already exists
			setErrorMessage("Expense Head Name already exists");
			return false;
		}
		headNames.add(s);
		ExpenseHead eh;
		expenseHeads.add(eh = new ExpenseHead(s));
		eh.updateBudgetedAmount(value);

		return true;
	}

	public boolean removeHead(String s) {
		// headNames.remove(s);
		// expenseHeads.remove(index);
		return removeExpenseHead(s);
	}

	protected boolean removeExpenseHead(String s) {
		int index=0;
		boolean bSuccess=false;
		ExpenseHead toRemove = null;
		for(ExpenseHead eh: expenseHeads)
		{
			index++;
			if(eh.getHeadName().equalsIgnoreCase(s))
			{
				if(eh.getActualAmount()==0)
				{
					//No actual amount mentioned, so it can be removed
					toRemove = eh;
					//expenseHeads.remove(index);
					headNames.remove(index);
					bSuccess=true;
				} else {
					setErrorMessage("Expense Head has actual expense amounts");
				}
			}
		}
		expenseHeads.remove(toRemove);
		//expenseHeads.remove(index);
		return bSuccess;
	}

	public boolean hasTransactions(int i) {
		return false;
	}

	public static ExpenseManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ExpenseManager();

		return INSTANCE;
	}

	public String getTourName() {
		// TODO Auto-generated method stub
		return tourDetails.getTourName();
	}

	public String getTourDetails() {
		// TODO Auto-generated method stub
		return tourDetails.getTourDetails();
	}

	public void updateTourInfo(String tourName, String details) {
		// TODO Auto-generated method stub
		tourDetails.update(tourName, details);
	}

}
