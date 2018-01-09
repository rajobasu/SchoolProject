package travelBudget.core;

/**
 * Encapsulates the tour details of a single tour and contains informations like
 * tourname, tour details etc.
 * 
 * @author Rajarshi Basu, Samaroha Ghosh class - X B.
 *
 */
public class TourDetails {
	private String tourName;
	private String tourDetails;

	private String[] placesVisited;
	private int numberOfPersons;
	private String fromDate, toDate;

	/**
	 * Default constructor initializing the values to 0 or null.
	 */
	TourDetails() {
		super();
	}

	/**
	 * Creates an object from the given data.
	 * 
	 * 
	 * @param tourName
	 *            - Name of the tour
	 * @param placesVisited
	 *            - stores the list of the places visited.
	 * @param numberOfPersons
	 *            -stores the number of persons going in the trip
	 * @param fromDate
	 *            -stores the starting date of the tour
	 * @param toDate
	 *            - stories the ending date of the tour.
	 */
	TourDetails(String tourName, String[] placesVisited, int numberOfPersons, String fromDate, String toDate) {
		super();
		this.tourName = tourName;
		this.placesVisited = placesVisited;
		this.numberOfPersons = numberOfPersons;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	/**
	 * 
	 * @param tourName
	 *            - The tour name to modify.
	 * @param tourDetails
	 *            - The details of the tour.
	 */
	public void update(String tourName, String tourDetails) {
		this.tourName = tourName;
		this.tourDetails = tourDetails;

	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getTourDetails() {
		// TODO Auto-generated method stub
		return tourDetails;
	}

	public void setTourDetails(String details) {
		// TODO Auto-generated method stub
		this.tourDetails = details;
	}

	public String[] getPlacesVisited() {
		return placesVisited;
	}

	public void setPlacesVisited(String[] placesVisited) {
		this.placesVisited = placesVisited;
	}

	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
