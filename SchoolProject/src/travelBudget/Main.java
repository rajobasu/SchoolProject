package travelBudget;

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
		System.out.println(" Travel Budget System - Version 1.0 ");
		System.out.println("------------------------------------\n");
		System.out.println("Program Started\n");
		new Menu().execute();
		System.out.println("End.\nGood Bye.\n");

	}

}
