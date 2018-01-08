/**
 * Program: 3
 * Name: Pattern 
 * Description: Class to display a specific pattern
 * 
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */   

// program to print a pattern as according to the number of lines of input given by the user.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Pattern {

	// take the input.
	int takeInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		while (n <= 0) {
			System.out.print("Enter number of Lines required : ");
			n = Integer.parseInt(br.readLine());
		}
		return n;
	}

	// print the pattern.
	void printPattern(int R) {
		// keep count of the number of rows.
		for (int maxVal = R; maxVal > 0; maxVal--) {

			// for each row, print the row in the proper fashion.
			for (int term = maxVal; term > 0; term--) {
				System.out.print(maxVal - term + 1 + " ");
			}
			repeatCharacter(((maxVal % 2 == 0) ? "# " : "* "), 2 * R + 1 - maxVal * 2);

			for (int term = maxVal; term > 0; term--) {
				System.out.print(term + " ");
			}
			System.out.println();
		}
	}

	// print a single character repeated several times.
	void repeatCharacter(String x, int num) {
		for (int i = 0; i < num; i++) {
			System.out.print(x);
		}
	}
}

public class MainPattern {

	public static void main(String[] args) throws IOException {
		Pattern obj = new Pattern();
		int R = obj.takeInput();
		obj.printPattern(R);
	}
}