/**
 * Program: 7
 * Name: ArrayManipulation
 * Description: Program to delete and update an array.
 *  
 *
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 15-10-2017
 */  
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ArrayManipulation {
	private int[] array;

    // initialize with the given initial array.
	public ArrayManipulation(int[] array) {
		this.array = array;
	}
    
    // remove the element at the given position.
	public void removeEle(int index) {
		index--;
		if (index < 0 || index >= array.length) {
			System.out.println("Invalid index: " + (index + 1));
			return;
		}
		int[] array = new int[this.array.length - 1];
		int ptr = 0;
		for (int i = 0; i < this.array.length; i++) {
			if (i == index)
				continue;

			array[ptr++] = this.array[i];
		}
		this.array = array;
	}

    // display the current version of the array.
	public void displayArray() {
		System.out.print("The array elements are : ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

}
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		do {
			System.out.println("Enter number of elements : ");
			n = Integer.parseInt(br.readLine());
		} while (n <= 0);
		int i;
		int[] arr = new int[n];
		System.out.println("Enter array elements.");
		for (i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		ArrayManipulation am = new ArrayManipulation(arr);
		do {
			System.out.println("Enter next element to delete < 1-indexed>. <-1> to exit.");
			int ch = Integer.parseInt(br.readLine());
			if (ch == -1)
				break;
			am.removeEle(ch);
			am.displayArray();
		} while (true);
		System.out.println("Done.");
	}
}
