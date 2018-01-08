/**
 * Program: 2
 * Name: SelSort
 * Description: Program to sort the array of integers
 *  
 *
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 15-10-2017
 */  
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelSort {
	private int[] arr;

     // accept the elements of the array from the user.
	public void getElements() throws IOException {
		System.out.println("Enter 30 elements ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[30];
		for (int i = 0; i < 30; i++)
			arr[i] = Integer.parseInt(br.readLine());
	}

     // display all the elements of the array.
	public void showElements() {
		System.out.println("The elements are :: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
     
     
     // find the index of the minimum value from the given index to the end of the array.
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
     
     // sort the given array using the selection sort logic.
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

class Main {
	public static void main(String[] args) throws IOException {
		SelSort ss = new SelSort();
		ss.getElements();
		ss.showElements();
		ss.selectionSort();
		System.out.println("Sorting done.");

		ss.showElements();

	}
}
