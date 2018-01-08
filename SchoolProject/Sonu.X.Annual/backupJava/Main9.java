 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SeriesSum {
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
		System.out.print("Enter the value of \'x\' : ");
		x = Double.parseDouble(br.readLine());
		do {
		    System.out.print("Enter the value of \'n\' : ");
			n = Integer.parseInt(br.readLine());
		} while (n <= 0);
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

public class Main9 {
	public static void main(String[] args) throws IOException {
		SeriesSum ss = new SeriesSum();
		ss.accept();
		ss.calcsum();
		ss.displaysum();
	}
}
