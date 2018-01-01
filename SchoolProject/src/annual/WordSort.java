package annual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordSort {
	private String sentence;
	private String[] words;

	public WordSort(String sentence) {
		this.sentence = sentence;
	}

	public void buildWordArray() {
		String word = "";
		int ctr = 0;
		int ctrW = 0;
		sentence += " ";
		for (int i = 0; i < sentence.length(); i++)
			if (sentence.charAt(i) == ' ')
				ctrW++;
		words = new String[ctrW];

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

	public int getWordCharSum(String word) {
		int sum = 0;
		for (int i = 0; i < word.length(); i++)
			sum += word.charAt(i);
		return sum;
	}

	private boolean isGreater(String s1, String s2) {
		return getWordCharSum(s1) > getWordCharSum(s2);
	}

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

	public void printWords() {
		System.out.println("The words in the sentence are :: ");
		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
		}
	}

}

class Main_08 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a sentence");
		WordSort ws = new WordSort(br.readLine());
		ws.buildWordArray();
		ws.printWords();

		ws.selectionSort();
		System.out.println("Sorting done.");
		ws.printWords();
	}
}