/**
 * Program: 4
 * Name: Exchange
 * Description: Program to perform operations on words and thus modify the sentence
 *
 *  
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 15-10-2017
 */  


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exchange {

	private String sentence;

    // initializes the sentence with the given value.
	public Exchange(String sentence) {
		this.sentence = sentence.substring(0, sentence.length() - 1);
	}

    // process all the words in the sentence and form a new sentence.
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

    // check if the given character is a vowel.
	public boolean isVowel(char c) {
		return "aeiouAEIOU".indexOf(c) >= 0;
	}

    // process the word given assuming it was at a even index.
	public String processEvenWord(String word) {
		String res = "";
		for (int i = 0; i < word.length(); i++)
			res += word.charAt(word.length() - i - 1);
		return res;
	}

    // process the word given assuming it is in a odd place.
	public String processOddWord(String word) {
		String res = "";
		for (int i = 0; i < word.length(); i++)
			if (isVowel(word.charAt(i)))
				res += word.charAt(i);
		return res;
	}

}

 class Main {
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
