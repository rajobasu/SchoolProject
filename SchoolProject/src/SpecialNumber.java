//Program to print all special numbers in the range provided by the user
//Program No: 7
//Program Date: 20.12.2016


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* ClassName: SpecialNumber 
* Description: Program to print all special numbers in the range 
* 				provided by the user.
* 
* 
* @author Rajarshi Basu, Class IX-B, Roll 7
*
*/

public class SpecialNumber {

	int[] factorialOf;
	int lower;
	int upper;

	public static void main(String[] args) throws IOException {
		SpecialNumber sc = new SpecialNumber();
		sc.takeInput();
		sc.generateSpecialNumbers();
	}

	public SpecialNumber() {
		precalculateFactorials();
	}
	/**
	 * @param n
	 * @return true, is the number satisfies the condition for being special
	 */
	public boolean isSpecial(int n) {
		int sum = 0;
		int n_copy = n;

		while (n > 0) {
			sum += factorialOf[n % 10];
			n /= 10;
		}

		return sum == n_copy;
	}
	/**
	 * 
	 * @throws IOException
	 * takes and validates the input given by the user
	 */
	public void takeInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// get the lower and upper bound from the user
		do {
			System.out.print("Enter Lower Range: ");
			lower = Integer.parseInt(br.readLine());
			System.out.print("Enter Upper Range: ");
			upper = Integer.parseInt(br.readLine());

		} while (lower > upper || lower < 0);
		
	}
	/**
	 * stores the factorials of the numbers 1-10 before taking the input and stores it in an array
	 */
	private void precalculateFactorials() {
		factorialOf = new int[10];

		factorialOf[0] = 1;
		int i;
		for (i = 1; i < 10; i++) {
			factorialOf[i] = factorialOf[i - 1] * i;
		}

	}
	/**
	 * generates all numbers between lower and the upper range and checks if it is a special number
	 */
	public void generateSpecialNumbers() {
		
		int ctr=0;
		int i;
		for(i=lower;i<=upper;i++){
			if(isSpecial(i)){
				System.out.println(i+ " is a Special Number");
				ctr++;
			}
		}
		// if there are no special numbers , prints a message
		if(ctr==0){
			System.out.println("There are no special numbers in this range !! ");
		}
	} //End generateSpecialNumbers() 
} // End class
