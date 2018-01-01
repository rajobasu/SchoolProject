
//Program to validate a date given by user and also check if year is a leap year
//Program No: 6
//Program Dated: 05.12.2016

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Class DateValid
public class DateValid {

	int mon;
	int day;
	int year;

	public static void main(String[] args) throws NumberFormatException, IOException {

		checkDate();
	}

	/**
	 * Default constructor
	 */
	public DateValid() {
		this.mon = 1;
		this.day = 1;
		this.year = 2015;
	}

	/**
	 * 
	 * Constructor
	 * 
	 * @param mon - month 
	 * @param day - Day
	 * @param year - year
	 */
	public DateValid(int day, int mon, int year) {
		super();
		this.mon = mon;
		this.day = day;
		this.year = year;
	}

	/**
	 * Leap year check function
	 * 
	 * @return true, is the year is a leap year, false otherwise
	 */
	boolean isLeap() {
		return (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0));
	}

	/**
	 * Check for date for its validity
	 * 
	 * @return true, is the date is valid , false otherwise
	 */
	boolean isValid() {
		// checks if the date does not have days or months or year which are not
		// possible in any situation
		if (day > 31 || day < 1 || mon > 12 || mon < 1 || year < 1)
			return false;

		// checks whether the date is within the limit according to each month
		switch (mon) {
		case 1: {
			if (day > 31)
				return false;

			break;
		}
		case 2: {
			if ((day > 28 && !isLeap()) || day > 29)
				return false;
			break;
		}
		case 3: {
			if (day > 31)
				return false;
			break;
		}
		case 4: {
			if (day > 30)
				return false;
			break;
		}

		case 5: {
			if (day > 31)
				return false;
			break;
		}
		case 6: {
			if (day > 30)
				return false;
			break;
		}
		case 7: {
			if (day > 31)
				return false;
			break;
		}
		case 8: {
			if (day > 31)
				return false;
			break;
		}
		case 9: {
			if (day > 30)
				return false;
			break;
		}
		case 10: {
			if (day > 31)
				return false;
			break;
		}
		case 11: {
			if (day > 30)
				return false;
			break;
		}
		case 12: {
			if (day > 31)
				return false;
			break;
		}

		}

		return true;
	}

	/**
	 * creates multiple new objects and checks whether they are valid or not.
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	static void checkDate() throws NumberFormatException, IOException {

		int day, month, year;
		// make a Reader for parsing input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Day: ");
		day = Integer.parseInt(br.readLine());
		System.out.print("Enter Month: ");
		month = Integer.parseInt(br.readLine());

		System.out.print("Enter Year: ");
		year = Integer.parseInt(br.readLine());

		DateValid dt1 = new DateValid();
		DateValid dt2 = new DateValid(day, month, year);

		System.out.println("\nDefault Date:");
		System.out.println("Date\t\t:::\tIs Leap\t:::\tisValid");
		System.out.printf("%s\t:::     %s\t:::     %s \n", dt1.day + "/" + dt1.mon + "/" + dt1.year,
				dt1.isValid() ? (dt1.isLeap() ? "YES" : "NO") : "----", dt1.isValid() ? "YES" : "NO");

		System.out.println("\nUser Entry:");
		System.out.println("Date\t\t:::\tIs Leap\t:::\tisValid");
		System.out.printf("%s\t:::     %s\t:::     %s \n", dt2.day + "/" + dt2.mon + "/" + dt2.year,
				dt2.isValid() ? (dt2.isLeap() ? "YES" : "NO") : "----", dt2.isValid() ? "YES" : "NO");

	}
}