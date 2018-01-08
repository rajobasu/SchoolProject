/**
 * Program: 8
 * Name: WordSort
 * Description: Program to sort the words of a sentence.
 *  
 *
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 15-10-2017
 */  
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordSort {

	private String sentence;
	private String[] words;

    // initialize the variables with the given values.
	public WordSort(String sentence) {
		this.sentence = sentence;
	}

    // build the array of words from the sentence.
	public void build() {
		String word = "";
		int ctr = 0;

		sentence += " ";
		for (int i = 0; i < sentence.length(); i++)
			if (sentence.charAt(i) == ' ')
				ctr++;
		words = new String[ctr];
		ctr = 0;
		for (int i = 0; i < sentence.length(); i++) {
			char x = sentence.charAt(i);
			if (x == ' ') {
				words[ctr++] = word;
				word = "";
			} else {
				word += x;
			}
		}
	}

    // get the sum of ASCII values of the characters of a word.
	public int getWordCharSum(String word) {
		int sum = 0;
		for (int i = 0; i < word.length(); i++)
			sum += word.charAt(i);
		return sum;
	}
    // check if the first word is logically greater than the second word.
	private boolean isGreater(String s1, String s2) {
		return getWordCharSum(s1) > getWordCharSum(s2);
	}

    // sort the words according to selection sort logic.
	public void selectionSort() {
		int i, j, pos;
		String small, temp;
		for (i = 0; i < words.length; i++) {
			small = words[i];
			pos = i;
			for (j = i + 1; j < words.length; j++) {
				if (isGreater(words[j], small)) {
					small = words[j];
					pos = j;
				}
			}
			temp = words[i];
			words[i] = small;
			words[pos] = temp;
		}
	}

    // print all the words in the array.
	public void printWords() {
		System.out.println("The words in the sentence are :: ");
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
		}
		System.out.println();
	}
}

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a sentence");
		WordSort ws = new WordSort(br.readLine());
		ws.build();
		ws.printWords();

		ws.selectionSort();
		System.out.println("Sorting done.");
		ws.printWords();
	}
}
