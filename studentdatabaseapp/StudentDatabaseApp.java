package studentdatabaseapp;

import java.util.Scanner;

/*
Scenario: You are a Database Administrator for a university and need to create an application 
	  to manage student enrollments and balance.

The application should do the following:
1. Ask the user how many new students will be added to the database
2. The user should be prompted to enter the name and class standing for each student
3. The student should have a 7-digit random student ID
4. A student can enroll in the following courses, for example, 
   History 101
   Mathematics 101
   English 101
   Chemistry 101
   Computer Science 101
5. Each course costs $600 to enroll
6. The student should be able to view their tuition balance and pay the tuition
7. To see the status of the student, we should see their name, student ID, courses enrolled, 
   and tuition balance
*/

public class StudentDatabaseApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ask the user how many new students will be added to the database
		System.out.print("Enter number of new students to enroll: ");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		// create n number of new students
		Student[] students = new Student[number];
		for (int i = 0; i < number; i++) {
			students[i] = new Student();
			students[i].enroll();
			students[i].payTuition();
		}
		
		// display all entered students' info
		for (int i = 0; i < number; i++) {
			students[i].displayInfo();
		}
	}

}
