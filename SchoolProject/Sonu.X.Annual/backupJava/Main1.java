 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class WordShift {

	private String originalWord;
	private String shiftedWord;
	private int shiftIndex;

	public WordShift(String word, int shiftIndex) {
		this.originalWord = word;
		this.shiftedWord = "";
		this.shiftIndex = shiftIndex;
	}

	public void shift() {

		String res = "";
		for (int i = 0; i < originalWord.length(); i++) {
			char c = originalWord.charAt(i);
			// detect if the char is a number or Caps A-Z or small a-z
			/*
			 * 0==48, 9==57 , a=97 , z=122, A=65, Z=90
			 */
			if (c >= 48 && c <= 57) {
				res += shiftNumber(c);
			} else {

				res += shiftLetter(c);
			}
		}
		shiftedWord = res;
	}

	public char shiftLetter(char c) {
		if (c >= 97 && c <= 122) // range of ascii for small caps a to z
			return (char) ((c - 'a' + shiftIndex) % 26 + 'a');
		else
			return (char) ((c - 'A' + shiftIndex) % 26 + 'A');

	}

	public char shiftNumber(char c) {
		return (char) ((c - '0' + shiftIndex) % 10 + '0');
	}

	public void displayOriginal() {
		System.out.println("The original word is : " + originalWord);
	}

	public void displayShifted() {
		System.out.println("The shifted word is  : " + shiftedWord);
	}

}

public class Main1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int shift;
		boolean ok = true;

		do {
			ok = true;
			System.out.print("Enter only one word : ");
			s = br.readLine().trim();
			for (int i = 0; i < s.length(); i++) {
				char x = s.charAt(i);
				if (!((x >= '0' && x <= '9') || (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')))
					ok = false;
			}
			if (!ok)
				System.out.println("Non alphanumeric character detected!");
		} while (!ok);
		do {
			System.out.println("Enter number of places to shift by ");
			shift = Integer.parseInt(br.readLine());
		} while (shift < 0);

		WordShift ws = new WordShift(s, shift);
		ws.displayOriginal();
		ws.shift();
		ws.displayShifted();
	}
}
