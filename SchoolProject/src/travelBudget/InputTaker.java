package travelBudget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class can be used to take a Integer input of type {@code int}. The input
 * is also validated depending on the {@code Validator}s that have been passed
 * to it.
 * 
 * @author rajob
 *
 */
public class InputTaker {

	private Validator[] validators;
	private static BufferedReader br;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Create a new {@code InputTaker} object along with the {@code Validator}s
	 * that will be used to validate the input when taken using this object.
	 * 
	 * @see Validator
	 * 
	 * @param validator
	 *            - A variable list of {@code Validator}s.
	 */
	public InputTaker(Validator... validator) {
		this.validators = validator;
	}

	/**
	 * This method returns a integer taken as input, which is validated against
	 * all of the {@code Validator}s with which the object on which this method
	 * was invoked on, was created. Also, a inputMessage is also taken which is
	 * printed prior to prompting the user for input. In case of wrong input, if
	 * so judged by any of the provided {@code Validator}s, a error message as
	 * prescribed by that {@code Validator} is shown and the user is prompted
	 * again.
	 * 
	 * @see Validator
	 * 
	 * @param inputMessage
	 *            - The message that is shown to the user before prompting for
	 *            input.
	 * @return - The integer which is taken from the user, after checking for
	 *         all validations.
	 * @throws NumberFormatException
	 * @throws IOException
	 * 
	 * 
	 */
	public int getInput(String inputMessage) throws NumberFormatException, IOException {
		boolean exit = true;
		int n = 0;
		do {
			exit = true;
			System.out.print(inputMessage);
			try {
				n = Integer.parseInt(br.readLine().trim());
			} catch (NumberFormatException e) {
				
			}
			for (Validator vv : validators) {
				if (!vv.isValid(n)) {
					exit = false;
					System.out.println(vv.getErrorMessage() + " " + n);
					break;
				}
			}

		} while (!exit);
		return n;
	}
}
