package annual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesSum {
	double x;
	int n;
	double sum;

	int factorial(int n) {
		if (n == 0)
			return 1;

		int res = 1;
		for (int i = 1; i <= n; i++)
			res *= i;
		return res;
	}

	double term(double p, int q) {
		return (double) Math.pow(p, 2 * q - 1) / (double) factorial(q);
	}

	void accept() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the value of /'x/' and /'n/'");
		x = Double.parseDouble(br.readLine());
		n = Integer.parseInt(br.readLine());
	}

	void displaysum() {
		System.out.println("The value of sum is :: " + sum);
	}

	double calcsum() {
		double res = 0;
		for (int i = 1; i <= n; i++) {
			res += term(x, i);
		}
		sum = res;
		return res;
	}
}

class Main_001 {
	public static void main(String[] args) throws IOException {
		SeriesSum ss = new SeriesSum();
		ss.accept();
		ss.calcsum();
		ss.displaysum();
	}
}
