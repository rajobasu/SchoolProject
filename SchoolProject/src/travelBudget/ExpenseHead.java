package travelBudget;

/**
 * This object encapsulates the basic block of a budget system -- A Expense
 * Head. It stores primarily 2 informations, the head name and the expenditure
 * under that head name.
 * 
 * @author rajob
 *
 */
public class ExpenseHead {
	private String headName;
	private int amount;

	/**
	 * Create a new {@code ExpenseHead} object from the {@code headName} and the
	 * {@code amount} passed in as parameter.
	 * 
	 * @param headName
	 *            - The name of the head for which this object stores the
	 *            information.
	 * @param amount
	 *            - The amount spent under that head.
	 */
	public ExpenseHead(String headName, int amount) {
		super();
		this.headName = headName;
		this.amount = amount;
	}

	/**
	 * The default constructor that sets the head name and amount to a default
	 * value.
	 */
	public ExpenseHead() {
		super();
	}

	/**
	 * @return the headName
	 */
	public String getHeadName() {
		return headName;
	}

	/**
	 * @param headName the headName to set
	 */
	public void setHeadName(String headName) {
		this.headName = headName;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
