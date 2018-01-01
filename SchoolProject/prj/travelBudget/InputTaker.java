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

	private static final int NO_DEFAULT_VAL = -1423525432;

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
	public int getInputInt(String inputMessage, int defValue) throws NumberFormatException, IOException {
		boolean exit = true;
		int n = defValue;
		do {
			n = defValue;
			exit = true;
			System.out.print(inputMessage);
			try {
				String inp = br.readLine().trim();
				if (!inp.isEmpty()) {
					n = Integer.parseInt(inp);

					for (Validator vv : validators) {
						if (!vv.isValid(n)) {
							exit = false;
							System.out.println(vv.getErrorMessage());
							break;
						}
					}
				} else {
					if (defValue == NO_DEFAULT_VAL) {
						exit = false;
					} else {
						System.out.println("Info: Original value < " + n + " > reinstated.");
					}
				}

			} catch (NumberFormatException e) {
				System.out.println("Error: Only Integer values are accepted !");
				exit = false;
			}

		} while (!exit);
		return n;
	}

	public int getInputInt(String inputMessage) throws NumberFormatException, IOException {
		return getInputInt(inputMessage, NO_DEFAULT_VAL);
	}

	public String getInputString(String message) throws IOException {
		System.out.println(message);
		return br.readLine();
	}
}
