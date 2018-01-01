//Program to print a patter based on the number chosen by user
//Program No: 5
//Program Date: 30.11.2016

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName: NumberPattern 
 * Description: Program to take a number as input from
 * user and print the pattern as given in the problem
 * 
 * 
 * @author Rajarshi Basu, Class IX-B, Roll 7
 *
 */

public class NumberPattern {

	int numberOfTerms;

	public static void main(String[] args) 
					throws NumberFormatException, IOException {
		// instantiate a new object
		NumberPattern obj = new NumberPattern();
		// get user input
		obj.getInput();
		// print the required pattern
		obj.printPattern();
	}

	/**
	 * Print the series for the given input
	 * 
	 */
	public void printPattern() {
		int i;
		for (i = 0; i < numberOfTerms; i++) {
			printOutputLine(i + 1);// output each line one by one
		}
	}

	/**
	 * print a single line starting with an offset
	 * 
	 * @param offset
	 */
	private void printOutputLine(int offset) {
		// print each line according to the logic of the pattern
		int i;
		for (i = 0; i < numberOfTerms; i++) {
			System.out.print(offset++ + " ");
			if (offset > numberOfTerms)
				offset = 1;
		}
		System.out.println();
	}

	public void getInput() throws NumberFormatException, IOException {
		// Create BufferedReader to take user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Enter a valid number: ");
			numberOfTerms = Integer.parseInt(br.readLine());
			if (numberOfTerms > 0) {
				return;// exits the method on getting a valid number
			} else {
				System.out.println("Enter a valid positive number !!");
			}
		} while (true);// this runs indefinitely until the user enters a valid
						// value, when it will exit the loop body using the
						// previous return statement
	}

} // End of class