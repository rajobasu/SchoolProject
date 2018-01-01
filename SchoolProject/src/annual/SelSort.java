package annual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelSort {
	private int[] arr;

	public SelSort() {

	}

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
			System.out.println(arr[i] + " ");

	}

	public int indexOfMin(int startIndex) {
		int min = 1000000000;
		int indm = 0;

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
		int small, temp;
		for (i = 0; i < arr.length; i++) {
			pos = indexOfMin(i);
			small = arr[pos];
			temp = arr[i];
			arr[i] = small;
			arr[pos] = temp;
		}
	}
}
