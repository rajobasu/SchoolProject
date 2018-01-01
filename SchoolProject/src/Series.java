//Program to print the sum and product of a series
//Program No: 4
//Program Dated: 17.11.2016

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* ClassName: Series 
* Description: Program to print the sum and product of a series 
* 
* 
* @author Rajarshi Basu, Class IX-B, Roll 7
*
*/
public class Series {

	public static void main(String[] args) throws IOException {
		new Series().process();// create a new instance and invoke the primary
								// function
	}

	public void process() throws IOException {
		int userChoice = getUserInput();

		if (userChoice == 0)
			return;

		if (userChoice == 1) {
			printSeriesSum();
		} else {
			printSeriesProduct();
		}

		System.out.println("\n\nEnd. Thank you.");

	}

	public int getUserInput() throws IOException {
		// create a Reader to parse input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get the choice of the user and check if it is a correct one
		int choice = 0;
		System.out.println("==== Menu ====");
		System.out.println("1. Print the Sum of the series");
		System.out.println("2. Print the Product of the series");
		
		System.out.println("");

		do {
			System.out.print("Enter Choice (1/2): ");
			choice = Integer.parseInt(br.readLine());
		} while (choice < 1 || choice > 2);

		
		
		return choice;
	} // End getUserInput

	public void printSeriesSum() throws NumberFormatException, IOException {

		// take the number of terms for input.
		int n = 0;
		// create a Reader to parse input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.print("Enter number of terms: ");
			n = Integer.parseInt(br.readLine());
		} while (n <= 0);

		// take value of X and print the required output.
		System.out.print("Enter value of X :: ");
		double x = Double.parseDouble(br.readLine());
		System.out.println("Value of the sum: " + sumSeries(x, n));
		
		

	}

	public void printSeriesProduct() throws NumberFormatException, IOException {
		// take the number of terms for input.
		int n = 0;
		// create a Reader to parse input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.print("Enter number of terms: ");
			n = Integer.parseInt(br.readLine());
		} while (n <= 0);

		System.out.println("Value of the product: " + prodSeries(n));
		
		
	}

	/**
	 * calculates the sum of the series
	 * 
	 * @param x:
	 *            Value of X
	 * @param n:
	 *            Number of terms
	 * @return: Value of the sum
	 */
	public double sumSeries(double x, int n) {
		double sum = 0;

		int power = 3;
		int numerator = 1;

		// Build the series and accumulate the sum
		while (n-- > 0) {

			sum += numerator / (Math.pow(x, power));

			numerator = power;
			power = power * 3 + 1;
		}

		return sum;
	}

	/**
	 * 
	 * @param n:
	 *            Number of terms
	 * @return: Value of the product of the Series
	 */
	public long prodSeries(int n) {
		long p = 1;
		int ctr = 0;
		int i;
		for (i = 2; ctr < n; i++) {
			if (isPrime(i)) {
				p *= i;
				ctr++;
			}
			if (ctr >= n)
				break;
		}

		return p;
	}

	/**
	 * 
	 * 
	 * @param n
	 * @return true, if n is a prime, false otherwise
	 */
	private boolean isPrime(int n) {
		int i;
		for (i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

}
