package travelBudget;

/**
 * This is a class that is used to validate a input from the user, but can be
 * used as a general purpose integer validator also.
 * 
 * @author rajob
 *
 */
public abstract class Validator {

	/**
	 * This is used to get the message that has to be shown when the parameter
	 * passed in {@code isValid} is invalid. Thus, it stores the message
	 * appropriate when this validation fails.
	 * 
	 * @return - The message to be shown.
	 */
	public String getErrorMessage() {
		return "Invalid Input";
	}

	/**
	 * Check whether the integer given as parameter is valid according to the
	 * set rules or not.
	 * 
	 * @param x
	 *            - The integer to be validated.
	 * @return Whether the given parameter is valid or not.
	 */
	public abstract boolean isValid(int x);
}
