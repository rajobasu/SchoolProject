 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Exchange {

	private String sentence;

	public Exchange(String sentence) {
		this.sentence = sentence.substring(0, sentence.length() - 1);
	}

	public String processWord() {
		String res = "";
		String word = "";
		sentence += " ";
		int ctr = 0;
		for (int i = 0; i < sentence.length(); i++) {
			char x = sentence.charAt(i);
			if (x == ' ') {
				ctr++;
				
				res += (ctr % 2 == 1) ? processOddWord(word) : processEvenWord(word);
				res += " ";
				word = "";
			} else {
				word += x;
			}

		}
		return res;
	}

	public boolean isVowel(char c) {
		return "aeiouAEIOU".indexOf(c) >= 0;
	}

	public String processEvenWord(String word) {
		String res = "";
		for (int i = 0; i < word.length(); i++)
			res += word.charAt(word.length() - i - 1);
		return res;
	}

	public String processOddWord(String word) {
		String res = "";
		for (int i = 0; i < word.length(); i++)
			if (isVowel(word.charAt(i)))
				res += word.charAt(i);
		return res;
	}

}

public class Main4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		do {
		    System.out.println("Enter a sentence ending with a <.>: ");
			s = br.readLine();
		} while (!s.endsWith("."));
		Exchange e = new Exchange(s);
		System.out.println("sentence after processing is  : " + e.processWord());

	}
}