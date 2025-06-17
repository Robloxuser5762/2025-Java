package apCSA2025;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class StockManagementSystem {
	public static void menu() {
		System.out.println("Choose an option for the menu:\n"
							+ "1. Create stock file\n"
							+ "2. Print stock report\n"
							+ "3. Search for an item by item number in the file\n"
							+ "4. Print the reorder report for the stock file\n"
							+ "5. Add a new record to the stock file\n"
							+ "6. Search for an item by item name in the file\n"
							+ "Make a selection:");
	}
	
	public static void createFile() {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream("Stock.txt"));
		} catch(FileNotFoundException e) {
			System.out.println("Error opening the file Stock.txt!");
			System.exit(0);
		}
		
		outputStream.println("1001 Television 705.85 2");
		outputStream.println("1006 Music center 481.23 21");
		outputStream.println("4003 Laptop computer 269.99 4");
		outputStream.println("2117 Microwave oven 134.67 3");
		outputStream.println("1023 Washing machine 563.55 12");
		outputStream.println("2876 Freezer 896.31 14");
		outputStream.println("1007 Firestick 102.74 25");
		outputStream.close();
	}
	
	public static void printFile() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("Stock.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Stock.txt was either not found or could not be opened!");
			System.exit(0);
		}
		while (inputStream.hasNextLine()) {
			System.out.println(inputStream.nextLine());
		}
		inputStream.close();
	}
	
	public static void numSearchFile(Scanner keyInput) {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("Stock.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Stock.txt was either not found or could not be opened!");
			System.exit(0);
		}
		
		System.out.println("Enter an item number:");
		String itemNum = keyInput.next(), line;
		boolean found = false;
		while (inputStream.hasNextLine() && found == false) {
			line = inputStream.nextLine();
			if (line.indexOf(itemNum) >= 0) {
				found = true;
				System.out.print("Item found in file: \nItem number: " + itemNum);
				line = line.substring(line.indexOf(" ") + 1);
				System.out.print("\nItem name: " + line.substring(0, line.indexOf(" ")));
				line = line.substring(line.indexOf(" ") + 1);
				System.out.println("\nItem price: " + line.substring(0, line.indexOf(" ")));
			}
		}
		if (found == false) {
			System.out.println("Item not found.");
		}
		inputStream.close();
	}

	public static void reorderReport() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("Stock.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Stock.txt was either not found or could not be opened!");
			System.exit(0);
		}
		
		String[] reorderQuantities = {"0", "1", "2", "3", "4",};
		System.out.println("Need reorders for the following items:");
		String line;
		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			for (int i = 0; i < 5; i++) {
				// For the array, you can get rid of it by putting
				// line.parseInt(line.split(" ")[3]) inside the .equals().
				if (line.substring(line.lastIndexOf(" ") + 1).equals(reorderQuantities[i])) {
					System.out.println(line);
				}
			}
		}
		inputStream.close();
	}
	
	public static void addItem(Scanner keyInput) {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream("Stock.txt", true));
		} catch(FileNotFoundException e) {
			System.out.println("Error opening the file Stock.txt!");
			System.exit(0);
		}
		
		System.out.println("Type the item. Add ONE SPACE between the item, name, price, and quantity. Spaces in names are fine.");
		outputStream.print(keyInput.nextLine()); // Catches the enter press from menu
		outputStream.println(keyInput.nextLine() + " ");
		outputStream.close();
		printFile();
	}
	
	public static void nameSearchFile(Scanner keyInput) {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("Stock.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Stock.txt was either not found or could not be opened!");
			System.exit(0);
		}
		
		System.out.println("Enter an item name:");
		String itemName = keyInput.next(), line;
		boolean found = false;
		while (inputStream.hasNextLine() && found == false) {
			line = inputStream.nextLine();
			if (line.indexOf(itemName) >= 0) {
				found = true;
				System.out.print("Item found in file: \nItem number: " + line.substring(0, line.indexOf(" ")));
				line = line.substring(line.indexOf(" ") + 1);
				System.out.print("\nItem name: " + itemName);
				line = line.substring(line.indexOf(" ") + 1);
				System.out.println("\nItem price: " + line.substring(0, line.indexOf(" ")));
			}
		}
		if (found == false) {
			System.out.println("Item not found.");
		}
		inputStream.close();
	}
	
	public static void main(String[] args) {
		Scanner keyInput = new Scanner(System.in);
		menu();
		int choice = keyInput.nextInt();
		while (choice != 0) {
			switch (choice) {
				case 1: {
					createFile();
					break;
				} case 2: {
					printFile();
					break;
				} case 3: {
					numSearchFile(keyInput);
					break;
				} case 4: {
					reorderReport();
					break;
				} case 5: {
					addItem(keyInput); // Passes in keyInput as a parameter to only use one and avoid the hassle of
					// closing each individual one, which can break other Scanners.
					break;
				} case 6: {
					nameSearchFile(keyInput);
					break;
				} default: { System.out.println("Invalid selection."); }
			}
			System.out.println();
			menu();
			choice = keyInput.nextInt();
		}
		keyInput.close();
	} // end of main
} // end of class StockManagementSystem