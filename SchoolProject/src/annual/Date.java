package annual;

public class Date {
	private int dd;
	private int mm;

	Date(int nd, int nm) {
		this.dd = nd;
		this.mm = nm;
	}

	private int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	int dateTodateNumber(Date dt) {
		int sum = dt.dd;
		for (int i = 0; i < dt.mm; i++)
			sum += months[dt.mm];
		return sum;
	}

	Date dateTodateNumber(int dt) {
		int sum = 0;
		int ctr = -1;
		while (dt > sum) {
			sum += months[++ctr];
		}
		return new Date(ctr, dt - sum);
	}

	public static void main(String[] args) {
		Date date = new Date(13, 3);
		System.out.println(date.dateTodateNumber(date));
	}
}
