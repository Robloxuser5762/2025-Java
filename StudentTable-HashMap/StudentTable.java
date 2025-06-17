package apCSA2025;
import java.util.HashMap;
import java.util.Scanner;
public class StudentTable {
	public static void addStudent(Scanner keyInput, HashMap<Integer, Student> student) {
		System.out.println("Enter the new student's ID number:");
		int ID = keyInput.nextInt();
		keyInput.nextLine();
		System.out.println("Enter the new student's FULL name:");
		String fullName = keyInput.nextLine();
		System.out.println("Enter the new student's birth MONTH:");
		String month = keyInput.next();
		System.out.println("Enter the new student's birth DAY:");
		int day = keyInput.nextInt();
		System.out.println("Enter the new student's birth YEAR:");
		int year = keyInput.nextInt();
		student.put(ID, new Student(ID, fullName, new Date(month, day, year)));
	}
	
	public static void searchID(Scanner keyInput, HashMap<Integer, Student> student) {
		System.out.println("Enter the student's ID number:");
		int searchID = keyInput.nextInt();
		if (student.containsKey(searchID)) {
			System.out.println("Student's found: " + student.get(searchID));
		} else {
			System.out.println("Student not found.");
		}
	}
	
	public static void printHashMap(HashMap<Integer, Student> student) {
		System.out.println(student);
	}
	
	public static int menu(Scanner keyInput) {
		System.out.println("Make a selection from the options below:\n"
			+ "0. END PROCESSING\n"
			+ "1. Add a student\n"
			+ "2. Search for a student by ID number\n"
			+ "3. Print data");
		return keyInput.nextInt();
	}
	
	public static void main(String[] args) {
		Scanner keyInput = new Scanner(System.in);
		HashMap<Integer, Student> students = new HashMap<>(10);
		
		students.put(48951, new Student(48951, "Sean Kalloo", new Date("February", 27, 2006)));
		students.put(48755, new Student(48755, "Franchesca Grace", new Date("November", 12, 2006)));
		students.put(133395, new Student(133395, "Christopher Tong", new Date("September", 22, 2008)));
		// The rest of the students will be added
		
		int choice = menu(keyInput);
		while (choice != 0) {
			switch (choice) {
				case 1: {
					addStudent(keyInput, students);
					break;
				} case 2: {
					searchID(keyInput, students);
					break;
				} case 3: {
					printHashMap(students);
					break;
				} default: { System.out.println("Invalid selection."); }
			}
			choice = menu(keyInput);
		}
		keyInput.close();
		System.out.println("End of processing.");
	} // end of main
} // end of class StudentTable