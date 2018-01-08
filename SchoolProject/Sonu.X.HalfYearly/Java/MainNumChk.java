/**
 * Program: 4
 * Name: NumberCheck 
 * Description: Class to test if the sum of the smallest and largest digit of the 
 *              given number is composite number or not 
 * 
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */   

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NumberCheck {

	// take the input.
	int takeInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// get the number of terms and check that it is more than 0.
		int n = 0;
		do {
			System.out.print("Enter a 5 digit number  : ");
			n = Integer.parseInt(br.readLine());
		} while (!(n > 9999 && n < 100000));
		return n;

	}

	// extract all the digits of the number and then return the smallest digit.
	int getSmallestDigit(int n) {
		int min = 10;
		while (n > 0) {
			min = Math.min(min, n % 10);
			n /= 10;
		}
		return min;
	}

	// extract all the digits of the number and then return the largest digit.
	int getLargestDigit(int n) {
		int max = 0;
		while (n > 0) {
			max = Math.max(max, n % 10);
			n /= 10;
		}
		return max;
	}

	// check if a number is prime by seeing if the number is divisible by any
	// other number other than 1 or itself.
	boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

}

public class MainNumChk {
	public static void main(String[] args) throws IOException {
		NumberCheck obj = new NumberCheck();
		int n = obj.takeInput();
		System.out.println("number is " + ((obj.isPrime(obj.getLargestDigit(n) + obj.getSmallestDigit(n))) ? "not" : "")
				+ " composite");
	}

}
