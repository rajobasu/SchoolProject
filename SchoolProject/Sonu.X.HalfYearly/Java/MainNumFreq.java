 /**
 * Program: 5
 * Name: NumberFrequency 
 * Description: Class to print out the frequency of composite numbers in an array
 *  
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */ 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NumberFrequency {

	private int[] array;
	private boolean[] marked;

	// print the frequencies of the elements in the array one by one.
	void solve() {
		int numComp = 0;
		for (int i = 0; i < array.length; i++)
			if (!isPrime(array[i])) {

				numComp++;
				int freq = checkFrequency(array[i]);
				if (freq > 0) {
					System.out.println("frequency of composite number " + array[i] + " is : " + freq);
				}
			}

		if (numComp == 0) {
			System.out.println("No composite number are present.");
		}
	}

	// for any given number, check the frequency of the number in the array. by
	// incrementing a counter each time that number is encountered in the array.
	public int checkFrequency(int x) {
		int num = 0;
		for (int i = 0; i < array.length; i++) {
			if (marked[i])
				continue;

			if (array[i] == x) {
				num++;
				marked[i] = true;
			}
		}

		return num;
	}

	// take and then store the input.
	public void takeInput() throws IOException {
	    
	    // input number of ter.
		System.out.print("Enter number of terms:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;

		// take the number of elements and check that the number is positive.
		do {
			n = Integer.parseInt(br.readLine());
		} while (n <= 0);

		array = new int[n];
		marked = new boolean[n];

		// input the array elements.
		System.out.println("Enter the elements ");

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
	}

	// check if a number is prime by seeing if the number is divisible by any
	// other number other than 1 or itself.
	public boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}

public class MainNumFreq {
	public static void main(String[] args) throws IOException {
		NumberFrequency obj = new NumberFrequency();
		obj.takeInput();
		obj.solve();
	}

}
