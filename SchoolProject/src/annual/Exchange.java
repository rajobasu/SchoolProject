package annual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exchange {

	private String sentence;

	public Exchange(String sentence) {
		this.sentence = sentence.substring(sentence.length() - 1);
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
		return "aeiouAEIOU".indexOf(c) > 0;
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

class Main_04 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a sentence : ");
		String s = br.readLine();
		Exchange e = new Exchange(s);
		System.out.println("sentence after processing is  : " + e.processWord());

	}
}