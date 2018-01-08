 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StringModify {
	private String st;

	// constructor
	public StringModify(String st) {
		this.st = st;
	}

	// insert the given string at the required position
	String insertStringAt(String w, int pos) {
		if (pos < 0 || pos >= st.length())
			return "Invalid input";

		return st.substring(0, pos) + w + st.substring(pos);
	}

	// check if the character at the given position is equal to the given
	// character. If so, delete it.
	String deleteCharAt(char w, int pos) {
		if (pos < 0 || pos >= st.length())
			return "Invalid input";
		if (st.charAt(pos) != w)
			return st;
		return st.substring(0, pos) + st.substring(pos + 1);

	}

}

public class Main5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = false;
		do {
			// print the menu.
			System.out.print("Enter a string : ");
			String st = br.readLine();
			StringModify sm = new StringModify(st);
			System.out.println("Menu  ::  ");
			System.out.println("1. Addition of a string at desired position.");
			System.out.println("2. Replacing deleting a position if it contains a specific character.");
			System.out.println("3. Exit.");
			int ch;
			// take the choice.
			do {
				System.out.print("Enter choice : ");

				ch = Integer.parseInt(br.readLine());
			} while (!(ch == 1 || ch == 2 || ch == 3));
			int pos;
			// execute the user choice.
			switch (ch) {
			case 1:
				System.out.println("Enter the string to insert and the position(1-indexed) : ");
				String s = br.readLine();
				pos = Integer.parseInt(br.readLine());
				System.out.println("The modified string is : " + sm.insertStringAt(s, --pos));
				break;
			case 2:
				System.out.println("Enter the character and the desired position where to delete(1-indexed) : ");
				char c = br.readLine().charAt(0);
				pos = Integer.parseInt(br.readLine());
				System.out.println("The modified String is  : " + sm.deleteCharAt(c, --pos));
				break;
			case 3:
				exit = true;
			}

		} while (!exit);
	}
}
