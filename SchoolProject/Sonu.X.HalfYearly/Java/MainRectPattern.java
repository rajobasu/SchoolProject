 /**
 * Program: 7
 * Name: RectanglePattern 
 * Description: Class to print out a rectangle with user input length, breadth and character 
 *  
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RectanglePattern {

	private int l, b;
	private char x;

	// take the input.
	void takeInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			// take the length and breadth and the character as the input.
			System.out.print("Enter length and breadth and character : ");
			l = Integer.parseInt(br.readLine());
			b = Integer.parseInt(br.readLine());
			x = br.readLine().charAt(0);

		} while (l <= 0 || b <= 0);

	}

	// print the given pattern according to the length, breadth and character
	// given as input.
	void printPattern() {
		// print the first line of the pattern.
		repeatCharacter(x, b);
		System.out.println();
		
		// print the middle lines of the pattern.
		for (int i = 0; i < l - 2; i++) {
			System.out.print(x);
			repeatCharacter(' ', b - 2);
			System.out.println(x);
		}
		
		// print the last line of the pattern.
		repeatCharacter(x, b);
		System.out.println();
	}

	// print the same character the given number of times.
	void repeatCharacter(char x, int num) {
		for (int i = 0; i < num; i++) {
			System.out.print(x);
		}
	}
}

public class MainRectPattern {

	public static void main(String[] args) throws IOException {
		RectanglePattern obj = new RectanglePattern();
		obj.takeInput();
		obj.printPattern();
	}
}
