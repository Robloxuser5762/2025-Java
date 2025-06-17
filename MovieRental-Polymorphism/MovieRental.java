package apCSA2025;
public class MovieRental {
	private int customerID, daysLate;
	private String title, genre;
	
	public MovieRental() {
		customerID = 1000;
		title = "A Movie";
		daysLate = 0;
		genre = "Generic";
	}
	public MovieRental(int customerID, String title, int daysLate, String genre) {
		this.customerID = customerID;
		this.title = title;
		this.daysLate = daysLate;
		this.genre = genre;
	}
	
	public double rentalFees() {
		if (genre.equals("Action")) {
			return 3.00 * daysLate;
		} else if (genre.equals("Comedy")) {
			return 2.50 * daysLate;
		} else {
			return 2.00 * daysLate;
		}
	}
	
	public String toString() {
		return "Customer ID: " + customerID + "\t Movie Title: " + title + "\t Days Late: " + daysLate;
	}
} // end of class MovieRental
