 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class WordFrequency {

	private String sentence;
	private String[] arr;

	// print the frequencies of all the words.
	public void printAllWords() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Current word : " + arr[i]);
			printFreq(arr[i]);
			System.out.println("----------------------------------------");

		}
	}

	// print the frequency of characters in the words.
	private void printFreq(String word) {
		if (word.length() == 0)
			return;

		// print the frequency of the first character.
		char c = word.charAt(0);
		int ctr = 0;
		// store the new word excluding the occurrences of the first character.
		String nw = "";
		for (int i = 0; i < word.length(); i++) {
			char x = word.charAt(i);
			if (c == x) {
				ctr++;
			} else {
				nw += x;
			}
		}
		System.out.printf("Frequency of \'%s\' is %2d\n", c, ctr);
		// recurse to print frequencies of the remaining characters.
		printFreq(nw);
	}

	// find the sum of the ASCII values of the given word.
	private int ASCIISum(String word) {
		int ctr = 0;
		for (int i = 0; i < word.length(); i++) {
			if ("AEIOU".indexOf(word.charAt(i)) >= 0)
				continue;
			ctr += word.charAt(i);
		}
		return ctr;
	}

	// checks if the first word is greater than the second word using the
	// specified conditions
	private boolean isGreater(String word1, String word2) {
		return ASCIISum(word1) > ASCIISum(word2);
	}

	// swap the i'th and j'th position of the array
	private void swap(int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// sort the array in descending order.
	public void selectionSort() {

		for (int i = 0; i < arr.length - 1; i++) {
			String s = "";
			int k = i;
			for (int j = i; j < arr.length; j++) {
				if (isGreater(arr[j], s)) {
					s = arr[j];
					k = j;
				}
			}
			swap(i, k);
		}
	}

	// construct the array of words from the given sentence
	public void build() {
		int cnt = 0;
		for (int i = 1; i < sentence.length(); i++) {
			if (sentence.charAt(i) != ' ' && sentence.charAt(i - 1) == ' ')
				cnt++;
		}
		cnt++;
		arr = new String[cnt];

		String temp = "";
		sentence = sentence.replace('.', ' ');
		// System.out.println(sentence);
		cnt = 0;
		for (int i = 0; i < sentence.length(); i++) {
			char x = sentence.charAt(i);
			if (x != ' ') {
				temp += x;
			} else {
				if (temp.equals(""))
					continue;

				arr[cnt++] = temp;
				temp = "";
			}
		}

	}

	// take the sentence as input
	public void takeInput() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("Enter a sentence ending with a <.> and in capital letters. ");
			sentence = br.readLine();
		} while (!validate(sentence));
	}

	// validate the string according to the desired rules;
	private boolean validate(String s) {
		return s.endsWith(".") && s.equals(s.toUpperCase());
	}

	// display all the words.
	public void display() {
		if (arr == null)
			build();

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ((i != arr.length - 1) ? " " : ""));
		}
		System.out.println(".");
	}

}

public class Main6 {
	public static void main(String[] args) throws IOException {
		WordFrequency ws = new WordFrequency();
		ws.takeInput();
		ws.build();
		System.out.print("Initial sentence is : ");
		ws.display();
		System.out.println("Frequency of all the words are : ");
		ws.printAllWords();

		ws.selectionSort();
		System.out.print("Sentence after sorting : ");
		ws.display();
	}
}
