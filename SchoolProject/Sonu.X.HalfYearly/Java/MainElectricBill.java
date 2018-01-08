/**
 * Program: 2
 * Name: ElectricityBillCalculator 
 * Description: Class to calculate the electricity bill amount based on unit consumption
 * 
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */  

// program to calculate the electricity bill of the customer.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ElectricityBillCalculator {

	// take the input.
	void takeInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// take the number of customers.
		int n;
		do {
			System.out.print("Enter number of customers : ");
			n = Integer.parseInt(br.readLine());
		} while (n <= 0);

		// take the information for each of the users.
		while (n-- > 0) {
			// input the name.
			System.out.print("Enter name : ");
			String name = br.readLine();

			// input the number of units consumed.Also check whether the number
			// of units is positive.
			int calls;
			do {
				System.out.print("Enter number of units consumed : ");
				calls = Integer.parseInt(br.readLine());
			} while (calls < 0);

			printBill(name, calls);
		}
	}

	// Print the bill for the customer.
	void printBill(String name, int calls) {
		System.out.println("Name : " + name);
		System.out.println("Bill amt : " + calculateBill(calls));
	}

	// calculate the bill according to the number of calls incurred.
	double calculateBill(int call) {
		double basicBill = calculateBasic(call);
		double finalBill = basicBill + calculateSurcharge(basicBill) + calculateGovtTax(basicBill);

		return finalBill;

	}

	// calculate the basic fare based on the number of calls.
	double calculateBasic(int call) {
		double charge = 0;

		charge = 0.5 * Math.max(0, Math.min(50, call));
		call -= 50;

		charge += 0.85 * Math.max(0, Math.min(120, call));
		call -= 120;

		charge += 1.2 * Math.max(0, Math.min(130, call));
		call -= 130;

		charge += 1.75 * Math.max(0, call);

		return charge;
	}

	// calculate the extra surcharge as according to the amount of the basic
	// tax.
	double calculateSurcharge(double amt) {
		return 0.2 * amt;
	}

	// calculate the extra govt tax as according to the amount of the basic tax.
	double calculateGovtTax(double amt) {
		return 0.155 * amt;
	}

}

public class MainElectricBill {
	public static void main(String[] args) throws IOException {
		ElectricityBillCalculator obj = new ElectricityBillCalculator();
		obj.takeInput();

	}
}