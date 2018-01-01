//Program to calculate and display the difference between smallest and second smallest
//        digiat of a number
//Program No: 1
//Program Date: 08.11.2016

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName: DigitDiffCalculator Program to take 5-digit number as input from
 * user and calculate & display difference between the smallest and the second
 * smallest digit
 * 
 * 
 * @author Rajarshi Basu, Class IX-B, Roll 7
 *
 */

public class DigitDiffCalculator {

	int n;
	int smallest;
	int secondSmallest;

	// default constructor
	public DigitDiffCalculator() {
		smallest = 10;
		secondSmallest = 10;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// create a new instance and invoke functions
		DigitDiffCalculator digitDiffCalc = new DigitDiffCalculator();
		digitDiffCalc.getInput();
		digitDiffCalc.findSmallest();
		digitDiffCalc.displayDiff();
	}

	/**
	 * Method to take and validate user input
	 * 
	 * @throws IOException
	 */
	void getInput() throws IOException {
		// Create BufferedReader for user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = 0;
		do {
			System.out.print("Enter a valid 5 digit number: ");
			// read user input
			n = Integer.parseInt(br.readLine());
		} while (n < 10000 || n > 99999); // validate if the number is of 5
											// digits
	}

	/**
	 * Find smallest and second smallest digit within the number
	 */
	void findSmallest() {
		while (n > 0) {
			int dg = n % 10; // getting each digit of the number
			n /= 10;
			if (dg < smallest) { // finding the smallest digit
				secondSmallest = smallest;
				smallest = dg;
			} else if (dg < secondSmallest && dg > smallest)
				// finding the second smallest digit
				secondSmallest = dg;
		}
		//Check if secondSmallest has been detected
		if(secondSmallest == 10) secondSmallest = smallest;
	}

	/**
	 * Display the difference
	 */
	void displayDiff() {
		System.out.println("Difference between smallest and second smallest number is: " + (smallest - secondSmallest));
	}
} // end of Class