 /**
 * Program: 12
 * Name: AbundantNumber 
 * Description: Class to input Decimal numbers and print corresponding Octal numbers
 *  
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */   

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class OctalConverter {

    private int[] arr;

    // print all the array elements along with their octal versions.
     void solve() {
         System.out.println("Decimal\t|\tOctal");

         for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t|\t" + toOctal(arr[i]));
        }
    }

    // take the input.
     void takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of terms :");
        int n;

        // take the number of terms and check that it is a positive number.
        do {
            n = Integer.parseInt(br.readLine());
        } while (n <= 0);

        // take all the array elements.
        arr = new int[n];

        System.out.println("Enter the array elements :");
        int i;
        for (i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    // converts the given number into a octal format and returns the string
    // representing that octal number.
    String toOctal(int n) {
        String res = "";

        while (n > 0) {
            res = n % 8 + res;
            n /= 8;
        }

        return res;
    }

}

public class MainOctal {

    public static void main(String[] args) throws IOException {
        OctalConverter obj = new OctalConverter();
        obj.takeInput();
        obj.solve();
    }
}
