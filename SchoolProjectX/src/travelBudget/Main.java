package travelBudget;

/*
TODO:
1. Head Adding
2. Save to File
3. Upload from File
4. Add entry for Actuals


*/

import java.io.IOException;

public class Main {
	/**
	 * The starting point of execution.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("------------------------------------");
		System.out.println(" Travel Budget System - Version 1.1 ");
		System.out.println("------------------------------------\n");
		System.out.println("Program Started\n");
		new Menu().execute();
		System.out.println("End.\nGood Bye.\n");

	}

}
