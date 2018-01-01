//Program to calculate the income tax as per the income slab
//Program No: 2
//Program Date: 08.11.2016

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: TaxCalculator Description: Class to calculate the income tax as per tax
 * rule for various income slab
 * 
 * @author Rajarshi Basu, Class IX-B, Roll 7
 *
 */
public class TaxCalculator {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new TaxCalculator().processInput();// instantiate object and run
	}

	void processInput() throws NumberFormatException, IOException {
		// make a Reader for parsing input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0; // n is the number of entities for which we have to calculate
					// the tax

		System.out.print("\n==== Tax Calculator ====\n");
		do {
			System.out.print("Enter Number of Persons: ");
			n = Integer.parseInt(br.readLine());
		} while (n < 0); // check that n is not less than 0;
		System.out.println("===============================================");

		int i = 1;
		while (i <= n) {
			// Initialize the variables with default values
			int age = 0;
			String gender = "";

			System.out.println("Enter details for person: " + i);
			do {
				System.out.print("  Enter Age: ");
				age = Integer.parseInt(br.readLine());
			} while (age <= 0); // check so that age of the person is not less
								// than 1;

			do {
				System.out.print("  Enter Gender (M or F): ");
				gender = br.readLine();
				gender = gender.toUpperCase();
			} while (!gender.equals("M") && !gender.equals("F"));// check that
																	// the
																	// gender is
																	// a valid
																	// one

			if (age < 65 && gender.equals("M")) {// check if the information
													// given by the user is
													// adequate or if he is in
													// the wrong category
				double income = 0;// set income to 0;
				do {
					System.out.print("  Enter Income : ");
					income = Double.parseDouble(br.readLine());
				} while (income < 0); // check that the user enters a valid
										// income
				// print the tax, the user is liable to pay
				System.out.println("  Tax on income is: Rs. " + calculateTax(income));

				// increase the count
				i++;
				System.out.println("===============================================");
			} else {
				// print that the user is in the wrong category

				System.out.println("Wrong category !!");
				// decrease the loop counter so that this user is not
				// counted as one of the N persons for whom we have to
				// Calculate the income tax
				System.out.println("-----------------");

			}
		} // End While
		System.out.println("End. Thank you.");
	}

	/**
	 * calculate the tax amount
	 * 
	 * @param amt
	 * @return tax payable on amount given
	 */
	double calculateTax(double amt) {

		// no tax if income is less than or equal to 160000
		if (amt <= 160000) {
			return 0;
		}

		if (amt <= 500000) {
			return 0.1 * (amt - 160000);
		}

		if (amt <= 800000) {
			return 0.2 * (amt - 500000) + 34000;
		}

		return 0.3 * (amt - 800000) + 94000;
	}
} // End of class