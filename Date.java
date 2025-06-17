package apCSA2025;
import java.util.Scanner;
public class Date {
	private String month;
	private int day, year;
	
	// Constructors
	public Date() {
		month = "January";
		day = 1;
		year = 1900;
	}
	public Date(int mInt, int d, int y) {
		setDate(mInt, d, y);
	}
	public Date(String mStr, int d, int y) {
		setDate(mStr, d, y);
	}
	public Date(int y) {
		setDate(1, 1, y);
	}
	public Date(Date myDate) {
		if (myDate == null) {
			System.out.println("FATAL Date error!");
			System.exit(0);
		}
		month = myDate.month;
		day = myDate.day;
		year = myDate.year;
	}
	
	// Accessors
	public int getDay() { return day; }
	public String getMonth() { return month; }
	public int getYear() { return year; }
	
	// Mutators
	public void setDate(int mInt, int d, int y) {
		if (dateOK(mInt, d, y)) {
			month = monthName(mInt);
			day = d;
			year = y;
		} else {
			System.out.println("FATAL Date error!");
			System.exit(0);
		}
	}
	public void setDate(String mStr, int d, int y) {
		if (dateOK(mStr, d, y)) {
			month = mStr;
			day = d;
			year = y;
		} else {
			System.out.println("FATAL Date error!");
			System.exit(0);
		}
	}
	public void setDate(int y) {
		setDate(1, 1, y);
	}
	public void setDay(int d) { day = d; }
	public void setMonth(int mInt) {
		if (mInt <= 0 || mInt > 12) {
			System.out.println("FATAL Date error!");
			System.exit(0);
		} else {
			month = monthName(mInt);
		}
	}
	public void setYear(int y) {
		if (year < 1000 || year > 9999) {
			System.out.println("FATAL Date error!");
			System.exit(0);
		} else {
			year = y;
		}
	}
	
	// Helper methods
	public String monthName(int mInt) {
		switch (mInt) {
			case 1: return "January";
			case 2: return "February";
			case 3: return "March";
			case 4: return "April";
			case 5: return "May";
			case 6: return "June";
			case 7: return "July";
			case 8: return "August";
			case 9: return "September";
			case 10: return "October";
			case 11: return "November";
			case 12: return "December";
			default: {
				System.out.println("FATAL Date error!");
				System.exit(0);
				return "Error";
			}
		}
	}
	// Private helper methods!!!
	private boolean dateOK(int mInt, int d, int y) {
		return ((mInt >= 1 && mInt <= 12) && (d >= 1 && d <= 31) && (y >= 1000 && y <= 9999));
	}
	private boolean dateOK(String mStr, int d, int y) {
		return ((mStr.equals("January") || mStr.equals("February") ||
				mStr.equals("March") || mStr.equals("April") ||
				mStr.equals("May") || mStr.equals("June") ||
				mStr.equals("July") || mStr.equals("August") ||
				mStr.equals("September") || mStr.equals("October") ||
				mStr.equals("November") || mStr.equals("December")) &&
				(d >= 1 && d <= 31) && (y >= 1000 && y <= 9999));
	}
	public boolean equals(Date bDay) {
		return (month.equals(bDay.month) && day == bDay.day && year == bDay.year);
	}
	public void readInput() {
		boolean condition = true;
		Scanner keyInput = new Scanner(System.in);
		while (condition) {
			System.out.println("Enter the name of the month, day, and year:");
			String m = keyInput.next();
			int d = keyInput.nextInt();
			int y = keyInput.nextInt();
			if (dateOK(m, d, y)) {
				setDate(m, d, y);
				condition = false;
			} else {
				System.out.println("Invalid date.");
			}
		}
		keyInput.close();
	}
	public String toString() { return month + " " + day + " " + year; }
} // end of class Date