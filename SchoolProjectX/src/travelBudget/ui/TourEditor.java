package travelBudget.ui;

import travelBudget.core.ExpenseManager;

/**
 * This class encapsulates an update operation on the tour details of a trip.
 * 
 * @author rajarshibasu
 *
 */
public class TourEditor {

	/**
	 * updates the existing tour details by taking input from the user.
	 */
	public void update() {
		InputTaker it = new InputTaker();

		ExpenseManager em = ExpenseManager.getInstance();

		System.out.println("");
		System.out.println("==============================================");
		System.out.println(" Travel Budget System : Tour Details");
		System.out.println("==============================================");
		System.out.println("");
		System.out.println(" Tour Name: " + em.getTourName());
		System.out.println("   Details: " + em.getTourDetails());
		System.out.println("");
		System.out.println(" (Enter New Tour Name and Details, hit <enter> for no change)");
		System.out.println("");
		String tourName = it.getInputString("  New Tour Name: ", em.getTourName());
		String tourDetails = it.getInputString("  New Details: ", em.getTourDetails());
		em.updateTourInfo(tourName, tourDetails);

	}

}
