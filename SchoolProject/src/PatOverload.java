
//Program to print a pattern according to the user input
//Program No: 8
//Program Date: 05.01.2017

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* ClassName: PatOverload 
* Description: Program to take a pattern as user input 
*  and print the number using the pattern 
* 
* 
* @author Rajarshi Basu, Class IX-B, Roll 7
*
*/

public class PatOverload {

	int n;
	char x;

	/**
	 * Default Constructor
	 * 
	 * intitializes only number of terms and sets x to _
	 */
	public PatOverload(int n) {
		this.n = n;
		this.x = '_';
	}

	/**
	 * Constructor
	 * @param n
	 * @param x
	 */
	public PatOverload(int n, char x) {
		super();
		this.n = n;
		this.x = x;
	}

	/**
	 * displays the pattern using the specified character
	 */
	void dispPat() {

		int i, j;
		for (i = 0; i < n; i++) {
			for (j = n - i; j > 0; j--) {
				if (j % 2 == 1) {
					System.out.print(x);
				} else {
					System.out.print(j);
				}
			}
			System.out.println();
		}
	}

	// main method
	public static void main(String[] args) throws NumberFormatException, IOException {
		menu();
	}

	/**
	 * Menu to take user input
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	static void menu() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		
		System.out.println("\n ==== Menu ====");
		System.out.println(" 1> Print Number with default pattern");
		System.out.println(" 2> Print Number with user pattern");
		
		do {
			System.out.print("Enter choice for pattern :: ");
			choice = Integer.parseInt(br.readLine());
		} while ( choice != 1 && choice != 2);// take and validate the user
												// choice

		int n = 0;
		// check and validate the number of terms
		do {
			System.out.print("Enter number of terms :: ");
			n = Integer.parseInt(br.readLine());
		} while (n < 0);

		// instantiate a new object and display pattern as given by the user.
		switch (choice) {
		case 1: {
			new PatOverload(n).dispPat();
			break;
		}

		case 2: {
			System.out.print("Enter a character :: ");
			char c = (char) System.in.read();
			new PatOverload(n, c).dispPat();
			break;
		}

		} //End switch

	} // End menu()
} // End of Class
