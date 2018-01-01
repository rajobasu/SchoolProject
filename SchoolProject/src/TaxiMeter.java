//Program to calculate the taxi fare and print the bill to the traveller
//Program No: 3
//Program Date: 08.11.2016

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: TaxiMeter Description: Class to calculate the taxi fare and print the
 * bill to the traveller
 * 
 * 
 * @author Rajarshi Basu, Class IX-B, Roll 7
 *
 */
public class TaxiMeter {

	String taxiNumber;
	String destinationName;
	int kmTravelled;

	int billAmt;

	public static void main(String[] args) throws IOException {

		// instantiate the class and invoke the functions

		TaxiMeter tmeter = new TaxiMeter();
		tmeter.getInput();
		tmeter.calculateBill();
		tmeter.printBill();

	}

	void getInput() throws IOException {
		// Create BufferedReader for user input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get destination from user
		System.out.print("Enter Destination: ");
		destinationName = br.readLine();

		// get Taxi number from user
		System.out.print("Enter Taxi Number: ");
		taxiNumber = br.readLine();

		// get distance from user and validate
		do {

			System.out.print("Enter distance travelled in kilometers: ");
			kmTravelled = Integer.parseInt(br.readLine());
		} while (kmTravelled < 0);

	}

	/**
	 * method to calculate the bill amount
	 */
	void calculateBill() {

		int kmTravel = kmTravelled;
		if (kmTravel > 0)
			billAmt += 20; // bill amount for the first 1 km traveled
		kmTravel -= 1;

		if (kmTravel > 0)
			billAmt += 10 * Math.min(5, kmTravel); // bill amount for the next 5
													// km traveled
		kmTravel -= Math.min(5, kmTravel);

		if (kmTravel > 0)
			billAmt += 12 * Math.min(10, kmTravel); // bill amount for the next
													// 12 km traveled
		kmTravel -= Math.min(10, kmTravel);

		billAmt += 15 * (kmTravel); // bill amount for the above 16 km traveled

	}

	/**
	 * Print the bill with details
	 */
	void printBill() {

		System.out.println("");
		System.out.println("==== Taxi Bill ====");
		System.out.println("Destination        : " + destinationName);
		System.out.println("Taxi Number        : " + taxiNumber);

		System.out.println("Distance Travelled : " + kmTravelled + " km");
		System.out.println("Bill in Rs         : " + billAmt);
		System.out.println("===================\nThank You.");

	}
} // End of class