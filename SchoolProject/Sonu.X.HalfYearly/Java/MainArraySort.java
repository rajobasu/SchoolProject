 /**
 * Program: 11
 * Name: ArraySort 
 * Description: Class to sort input array, first half in ascending order, 
 *                  while second half in descending order  
 *  
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class ArraySort {

    private int[] arr;

    // sort the array taken from the user in two different orders sing two
    // different algorithms and then print the array.
    void solve() {

        System.out.println("Original Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // sorting the first half in ascending order using bubblesort.
        bubbleSort(0, arr.length / 2);
        // sorting the second half in descending order using selectionsort.
        selectionSort(arr.length / 2, arr.length - arr.length / 2);

        // printing the sorted array elements.
        System.out.println("Sorted Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    // take the input.
    void takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // get the number of elements in the array and check that it is a
        // positive integer.
        int n;
        do {
            System.out.print("\nEnter number of terms  : ");
            n = Integer.parseInt(br.readLine());
        } while (n <= 0);

        // get the elements of the array.
        arr = new int[n];
        System.out.println("Enter the array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    // sort the given part of the array using the bubblesort algorithm
    void bubbleSort(int offset, int length) {
        for (int pass = length - 1; pass >= 0; pass--) {
            for (int i = 0; i < pass; i++) {
                // swap if the values are in different order.
                if (arr[offset + i] > arr[offset + i + 1]) {
                    int temp = arr[offset + i];
                    arr[offset + i] = arr[offset + i + 1];
                    arr[offset + i + 1] = temp;
                }
            }
        }
    }

    // sort the given part of the array using the selection sort algorithm.
    void selectionSort(int offset, int length) {
        int i, j, max, temp;
        for (i = 0; i < length - 1; i++) {
            max = i;

            // find the index of the maximum value.
            for (j = i + 1; j < length; j++)
                if (arr[offset + j] > arr[offset + max])
                    max = j;

            // swap the elements in incorrect order.
            temp = arr[offset + max];
            arr[offset + max] = arr[offset + i];
            arr[offset + i] = temp;
        }
    }

}

public class MainArraySort {

    public static void main(String[] args) throws IOException {
        ArraySort obj = new ArraySort();
        obj.takeInput();
        obj.solve();
    }

}
