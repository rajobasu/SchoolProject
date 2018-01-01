//Program to print the details of the student who scores the lowest on average
//Program No: 9
//Program Date: 16.01.2017

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* ClassName: StudentAverage 
* Description: Program to print the details of the student 
* 					who scores the lowest on average.
* 
* 
* @author Rajarshi Basu, Class IX-B, Roll 7
*
*/

public class StudentAverage {

	String lowest_name;
	int lowest_roll;
	double lowest_avg;

	public static void main(String[] args) throws NumberFormatException, 
													IOException 
	{
		StudentAverage obj = new StudentAverage();
		obj.takeInput();
		obj.displayLowest();
	}

	/**
	 * Default Constructor
	 */
	public StudentAverage() {
		lowest_avg = 101;// this needs to be greater than any possible marks.
	}

	
	/**
	 * Get user Input
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	void takeInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfStudents = 0;
		do {
			System.out.print("Enter number of students :: ");
			numberOfStudents = Integer.parseInt(br.readLine());
		} while (numberOfStudents <= 0);

		while (numberOfStudents-- > 0) {
			// get the name and roll number of the student.
			System.out.print("Enter name of Student :: ");
			String temp_name = br.readLine();
			int temp_roll;
			do {
				System.out.print("Enter roll number :: ");
				temp_roll = Integer.parseInt(br.readLine());
			} while (temp_roll <= 0);
			
			// get the three marks of the student and validate it 
			int marks1 = 0;
			do {
				System.out.print("Enter marks for subject 1 :: ");
				marks1 = Integer.parseInt(br.readLine());
			} while (marks1 < 0 || marks1 > 100);

			int marks2 = 0;
			do {
				System.out.print("Enter marks for subject 2 :: ");
				marks2 = Integer.parseInt(br.readLine());
			} while (marks2 < 0 || marks2 > 100);
			int marks3 = 0;
			do {
				System.out.print("Enter marks for subject 3 :: ");
				marks3 = Integer.parseInt(br.readLine());
			} while (marks3 < 0 || marks3 > 100);

			// calculate the average amrks of the student
			double avgm = marks1 + marks2 + marks3;
			avgm /= 3;

			if (avgm < lowest_avg) {// update the information of the student getting the lowest marks till
				lowest_avg = avgm;
				lowest_name = temp_name;
				lowest_roll = temp_roll;
			}
		}
	}

	/**
	 * displays the informations of the person who scores the lowest marks
	 */
	void displayLowest() {
		System.out.println(":::::  Person Scoring Lowest  :::::");
		System.out.println("Name             : " + lowest_name);
		System.out.println("Roll             : " + lowest_roll);
		System.out.println("Average Marks    : " + lowest_avg);
		System.out.println("Point            : " + getPoint());

	}

	/**
	 * 
	 * @return Point according to the average marks scored by the student
	 */
	int getPoint() {
		if (lowest_avg >= 85)
			return 1;
		else if (lowest_avg >= 75)
			return 2;
		else if (lowest_avg >= 60)
			return 3;
		else if (lowest_avg >= 40)
			return 4;
		else
			return 5;
	}

} // End Class
