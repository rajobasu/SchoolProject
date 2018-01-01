//Program to calculate the LCM of the digits of the number given by the user.
//        
//Program No: 10
//Program Date: 28.01.2017


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName: DigitLCM 
 * Description: Program to take 3-digit number as input from
 * user and calculate & display the LCM of the individual digits
 * 
 * 
 * @author Rajarshi Basu, Class IX-B, Roll 7
 *
 */
public class DigitLCM {

	int number;

	public static void main(String[] args) throws NumberFormatException, IOException {
		DigitLCM obj = new DigitLCM();
		obj.takeInput();
		obj.processInput();
	}

	/**
	 * 
	 * create a Reader to parse the input, get the input from the user and
	 * validate it.
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 * 
	 */
	public void takeInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Enter a valid 3-digit number :: ");
			number = Integer.parseInt(br.readLine());
		} while (number < 100 || number > 999);
	}

	/**
	 * It searches foor all possible LCM values, form the maximum of the two to
	 * the product of the two, which is the maximum LCM and chooses the lowest
	 * 
	 * @param a - first number
	 * @param b - second number
	 * @return LCM of two numbers
	 */

	public int LCMOf(int a, int b) {
		int i;
		for (i = Math.max(a, b); i <= a * b; i++) {
			if (i % a == 0 && i % b == 0) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * calculates the LCM of all the digits.
	 */
	public void processInput() {
		int lcm = 1;
		while (number > 0) {
			lcm = LCMOf(lcm, number % 10);
			number /= 10;
		}

		System.out.println("LCM  of the digits is " + lcm);
	}
} // end of class
