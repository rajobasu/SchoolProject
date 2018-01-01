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
		System.out.println("Program started");
		new Menu().execute();
		System.out.println("End.");

	}

}
