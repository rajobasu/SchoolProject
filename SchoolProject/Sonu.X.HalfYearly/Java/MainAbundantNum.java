 /**
 * Program: 6
 * Name: AbundantNumber 
 * Description: Class to print out abundant numbers
 *  
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AbundantNumber {

	// take the input.
	 int takeInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// take the number of terms to print.
		int n = -1;
		while (n <= 0) {
			System.out.print("Enter how many abundant numbers: ");
			n = Integer.parseInt(br.readLine());
		}
		return n;
	}

	// get all the factors of the given number and return their sum.
	int getFactorSum(int n) {
		int sum = 1;
		int i = 1;
		while (i++ > 0) {
			if (n % i == 0) {

				// check whether the number is a factor of n. if so, add both
				// the quotient and the divisor to the sum. Also check that both
				// the quotient and the divisor are no the same.
				if (n / i > i) {
					sum += i;
					sum += n / i;
				} else if (n / i == i) {
					sum += i;
				} else {
					break;
				}
			}
		}
		return sum;
	}

	// check whether the number is a abundant number.
	boolean isAbundant(int n) {
		return getFactorSum(n) > n;
	}

	// check which numbers are the abundant numbers.
	void calcNumbers(int n) {
		int i = 2;
		System.out.print("The first " + n + " abundant numbers are : ");
		while (n > 0) {
			// check if the number is abundant. If so, then print the number.
			if (isAbundant(i++)) {
				System.out.print(i - 1 + " ");
				n--;
			}
		}
		System.out.println();
	}

}

public class MainAbundantNum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		AbundantNumber obj = new AbundantNumber();
		obj.calcNumbers(obj.takeInput());
	}
}
