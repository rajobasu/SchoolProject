/**
 * Program: 9
 * Name: SeriesSum
 * Description: Program to find the sum of a series.
 *  
 *
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 15-10-2017
 */   

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesSum {
	double x;
	int n;
	double sum;

    // calculate the factorial of the given number.
	int factorial(int n) {
		if (n == 0)
			return 1;

		int res = 1;
		for (int i = 1; i <= n; i++)
			res *= i;
		return res;
	}

    // calculate the value of a given term.
	double term(double p, int q) {
		return (double) Math.pow(p, 2 * q - 1) / (double) factorial(q);
	}

    // accept the input from the user.
	void accept() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the value of \'x\' : ");
		x = Double.parseDouble(br.readLine());
		do {
		    System.out.print("Enter the value of \'n\' : ");
			n = Integer.parseInt(br.readLine());
		} while (n <= 0);
	}

    // display the sum of the series.
	void displaysum() {
		System.out.println("The value of sum is :: " + sum);
	}

    // calculate the sum of the series.
	double calcsum() {
		double res = 0;
		for (int i = 1; i <= n; i++) {
			res += term(x, i);
		}
		sum = res;
		return res;
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		SeriesSum ss = new SeriesSum();
		ss.accept();
		ss.calcsum();
		ss.displaysum();
	}
}
