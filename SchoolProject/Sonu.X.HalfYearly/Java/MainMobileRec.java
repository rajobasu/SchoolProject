 /**
 * Program: 8
 * Name: MobileRecord 
 * Description: Class to input and update mobile numbers of users
 *  
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */ 


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class MobileRecord {

    private String[] names;
    private long[] mobNums;

    // take the input.
    void takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        // take the number of terms.
        System.out.println("Enter number of users : ");
        do {
            n = Integer.parseInt(br.readLine());
        } while (n <= 0);

        names = new String[n];
        mobNums = new long[n];
        // take all the input names and mobile numbers
        System.out.println("Enter names and mobile numbers elenents : ");
        int i;
        for (i = 0; i < n; i++) {
            System.out.println("Enter data for user " + (i+1));
            names[i]   = br.readLine();
            mobNums[i] = Long.parseLong(br.readLine());
            
            if(!checkNumberValidity(mobNums[i]))
                i--;
            
        }

        // sort the arrays as according to the names using the bubblesort
        // algorithm.
        bubbleSort();

        int q;
        System.out.println("Enter number of changes : ");
        do {
            q = Integer.parseInt(br.readLine());
        } while (q <= 0);

        while (q-- > 0) {
            // process the queries one by one.
            System.out.println("Enter the name and the mobile number to update ");
            String name = br.readLine();
            long number = Long.parseLong(br.readLine());

            if (!checkNumberValidity(number) || !update(name, number)) 
                q++;
            
        }
        // print the output arrays.
        printArrays();

    }

    boolean checkNumberValidity(long n) {
        int ctr = 0;
        while ((n /= 10) > 0)
            ctr++;
        return ctr < 10;
    }

    // print the arrays serially.
    public void printArrays() {
        System.out.println();
        for (int i = 0; i < names.length; i++) {
            System.out.println("\nData for User "+(i+1)+ "\nName: "+names[i] + "\nMobile: " + mobNums[i]);
        }
        System.out.println();
    }

    // update the number of the given person using his name to search.
    public boolean update(String name, long number) {
        int index = binarySearch(name, 0, names.length);
        if (index == -1) {
           return false;
        }

        mobNums[index] = number;
        return true;
    }

    // sort both the arrays according to the field in the array storing the
    // names of the users.
    public void bubbleSort() {
        for (int pass = names.length - 1; pass >= 0; pass--) {
            for (int i = 0; i < pass; i++) {
                // swap the names if order is reversed.
                if (names[i].compareTo(names[i + 1]) > 0) {
                    
                        String temp1 = names[i];
                        names[i] = names[i + 1];
                        names[i + 1] = temp1;
                    

                    
                        long temp2 = mobNums[i];
                        mobNums[i] = mobNums[i + 1];
                        mobNums[i + 1] = temp2;
                    
                }
            }
        }
    }

    // binary search the given value in the array containing the names of all
    // the users.
    public int binarySearch(String val, int l, int r) {
        int mid = l + (r - l) / 2;

        switch (names[mid].compareTo(val)) {
        case 1:
            return binarySearch(val, l, mid);
        case 0:
            return mid;
        case -1:
            return binarySearch(val, mid + 1, r);
        }

        return -1;
    }

}

public class MainMobileRec {
    public static void main(String[] args) throws IOException {
        new MobileRecord().takeInput();
    }
}
