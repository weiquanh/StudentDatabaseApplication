package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private String classStanding;
	private String studentID;
	private String courses = "";
	private double tuitionBalance;
	private static int courseCost = 600;
	
	// constructor: prompt to enter name and year of each student
	public Student() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Student's First Name: ");
		this.firstName = input.nextLine();
		
		System.out.print("Enter Student's Last Name: ");
		this.lastName = input.nextLine();
		
		System.out.print("1) Freshman \n2) Sophmore \n3) Junior \n4) Senior"
				+ "\nEnter Student's Class Standing(choose number above): ");
		switch(input.nextInt()) {
			case 1:
				this.classStanding = "Freshman";
				break;
			case 2:
				this.classStanding = "Sophmore";
				break;
			case 3:
				this.classStanding = "Junior";
				break;
			case 4:
				this.classStanding = "Senior";
				break;
		}
		
		setStudentID();
		
//		System.out.println("Student " + firstName + " " + lastName + " - Grade " 
//				+ year + " - SID " + studentID);
	}
	
	// generate random 7-digit student ID
	private void setStudentID() {
		String studentIDSet = "0123456789";
		char[] studentID = new char[7];
		for (int i = 0; i < studentID.length; i++) {
			int rand = (int) (Math.random() * studentIDSet.length());
			studentID[i] = studentIDSet.charAt(rand);
		}
		this.studentID =  new String(studentID);
	}
	
	// enroll courses
	public void enroll() {
		while (true) {
			System.out.print("Enter A Course To Enroll(Q to quit): ");
			Scanner input = new Scanner(System.in);
			String course = input.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n	" + course;
				tuitionBalance += courseCost;
			} else {
				break;
			}
		}
//		System.out.println("Student Enrolled In: " + courses);
//		System.out.println("Tuition Balance: " + tuitionBalance);
	}
	
	// view balance
	public void viewBalance() {
		System.out.println("Current Tuition Balance is $" + tuitionBalance);
	} 
	
	// pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter the Amount to pay: $");
		Scanner input = new Scanner(System.in);
		double payment = input.nextDouble();
		tuitionBalance -= payment;
		System.out.println("Thank You for the Payment of $" + payment);
		viewBalance();
	}
	
	// see status
	public void displayInfo() {
		System.out.println("Student Name: " + firstName + " " + lastName +
				"\nClass Standing: " + classStanding +
				"\nStudentID: " + studentID +
				"\nCourses Enrolled: " + courses + 
				"\nTuition Balance: $" + tuitionBalance);
	}
}
