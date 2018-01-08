 /**
 * Program: 9
 * Name: Power 
 * Description: Class to calculate the power of any positive number
 *  
 * @author Rajarshi Basu, Class X-B, Roll 7
 * Date: 10-06-2017
 */ 

class Power {
	private int x;
	private int power;

	// assign the respective values to the fields.
	public Power(int x, int power) {
		this.x = x;
		this.power = power;
	}

	// assign the value given to both the fields.
	public Power(int cmnVal) {
		this.x = cmnVal;
		this.power = cmnVal;
	}

	// display the final result, or error message in case the data is invalid.

	void calculate() {
		if (x <= 0) {
			System.out.println("Invalid Data");
		} else if (power < 0) {
			// calculate the denominator first, and then take its reciprocal.
			//System.out.print("The value of "+x+" raised to the power of "+power+" is=");
			System.out.println(1.0 / pow(x, -power));
		} else {
			//System.out.print("The value of "+x+" raised to the power of "+power+" is=");
			System.out.println(pow(x, power));
		}
	}

	// calculate the power of a number using a divide and conquer approach.
	int pow(int val, int pow) {
		if (pow == 0)
			return 1;
		if (pow % 2 == 0)
			return pow(val, pow / 2) * pow(val, pow / 2);

		return pow(val, pow - 1) * val;
	}
}



public class MainPower {

	public static void main(String[] args) {
		int x = 2;
		int power = 4;
	    
	    System.out.print("The value of "+x+" raised to the power of "+power+" is: " );
	    new Power(x, power).calculate();
		x= 22; power=4;
	    System.out.print("The value of "+x+" raised to the power of "+power+" is: " );
	    new Power(x, power).calculate();

		x= -2; power=4;
	    System.out.print("The value of "+x+" raised to the power of "+power+" is: " );
	    new Power(x, power).calculate();

		x= 2; power= -4;
	    System.out.print("The value of "+x+" raised to the power of "+power+" is: " );
	    new Power(x, power).calculate();

	}

}
