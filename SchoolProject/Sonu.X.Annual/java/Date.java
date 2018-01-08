/**
 * Program: 3
 * Name: Date
 * Description: Program to manipulate Date.
 *  
 *
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 15-10-2017
 */   


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Main class for Date
class Date {
	private int dd;
	private int mm;

	//Constructor
	Date(int nd, int nm) {
		this.dd = nd;
		this.mm = nm;
	}

	private int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// Convert Date to dateNumber
	int dateTodateNumber(Date dt) {
		int sum = dt.dd;
		for (int i = 0; i < dt.mm - 1; i++)
			sum += months[i];
		return sum;
	}

	// Convert dataNumber to Date
	Date dateNumberTodate(int dt) {
		int sum = 0;
		int ctr = -1;
		while (dt > sum) {
			sum += months[++ctr];
		}
		
		sum -= months[ctr];
		return new Date(dt - sum, ++ctr);
	}

	// Display the date and month
	public void display() {
		System.out.println(dd + "-" + (mm));
	}

	//Accept input from user
	public void accept() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		do {
		    System.out.println("Enter date Number between 0 and 365 : ");
			n = Integer.parseInt(br.readLine());
		} while (n < 1 || n > 365);
		new Date(0, 0).dateNumberTodate(n).display();
	}

	public static void main(String[] args) throws IOException {
		new Date(0, 0).accept();
	}

}
