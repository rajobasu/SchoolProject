/**
 * Program: 1
 * Name: Employee 
 * Description: Class to calculate the income tax for Employees as per tax
 *              rule for various income slab
 * 
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */  

// program to calculate the tax.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Employee {

    private int pan;
    private String name;
    private double taxIncome;
    private double tax;

    // take the input
    void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            // get the pan id number.
            System.out.print("Enter pan ID : ");
            pan = Integer.parseInt(br.readLine());
            // get the name.
            System.out.print("Enter name : ");
            name = br.readLine();
            // get the taxable income.
            System.out.print("Enter taxable income : ");
            taxIncome = Double.parseDouble(br.readLine());

            // get out of the loop if all the information are valid.
            if (taxIncome > 0 && pan > 0)
                break;

        } while (true);
    }

    // calculate the tax as per the income of the user.
    void calc() {
        if (taxIncome <= 1_00_000) {
            tax = 0;
        } else if (taxIncome <= 1_50_000) {
            tax = 0.1 * (taxIncome - 1_00_000);
        } else if (taxIncome <= 2_50_000) {
            tax = 0.2 * (taxIncome - 1_50_000) + 6_000;
        } else {
            tax = 0.3 * (taxIncome - 2_50_000) + 27_000;
        }
    }

    // display the detailed information of the user.
    void display() {
        System.out.println("Pan Number        Name       Tax-Income       Tax");
        System.out.println(pan + "        " + name + "        " + taxIncome + "       " + tax);
    }

}

public class MainEmp {
    public static void main(String[] args) throws IOException {
        Employee obj = new Employee();
        obj.input();
        obj.calc();
        obj.display();
    }
}
