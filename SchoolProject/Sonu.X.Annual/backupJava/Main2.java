 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class SelSort {
	private int[] arr;

	public void getElements() throws IOException {
		System.out.println("Enter 30 elements ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[30];
		for (int i = 0; i < 30; i++)
			arr[i] = Integer.parseInt(br.readLine());
	}

	public void showElements() {
		System.out.println("The elements are :: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public int indexOfMin(int startIndex) {
		int min = arr[startIndex];
		int indm = startIndex;

		for (int i = startIndex; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				indm = i;
			}
		}
		return indm;
	}

	void selectionSort() {
		int i, pos;
		int temp;
		for (i = 0; i < arr.length; i++) {
			pos = indexOfMin(i);

			temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
		}
	}
}

public class Main2 {
	public static void main(String[] args) throws IOException {
		SelSort ss = new SelSort();
		ss.getElements();
		ss.showElements();
		ss.selectionSort();
		System.out.println("Sorting done.");

		ss.showElements();

	}
}
