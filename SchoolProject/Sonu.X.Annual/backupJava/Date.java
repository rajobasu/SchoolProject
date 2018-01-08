 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Date {
	private int dd;
	private int mm;

	Date(int nd, int nm) {
		this.dd = nd;
		this.mm = nm;
	}

	private int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	int dateTodateNumber(Date dt) {
		int sum = dt.dd;
		for (int i = 0; i < dt.mm - 1; i++)
			sum += months[i];
		return sum;
	}

	Date dateNumberTodate(int dt) {
		int sum = 0;
		int ctr = -1;
		while (dt > sum) {
			sum += months[++ctr];
		}
		
		sum -= months[ctr];
		return new Date(dt - sum, ++ctr);
	}

	public void display() {
		System.out.println(dd + "-" + (mm));
	}

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
