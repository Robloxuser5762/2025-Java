package apCSA2025;
public class Movie {
	private int ID;
	private String title, rating;
	
	public Movie() {
		ID = 1000;
		title = "A Movie";
		rating = "Unrated";
	}
	public Movie(int ID, String title, String rating) {
		this.ID = ID;
		this.title = title;
		this.rating = rating;
	}
	
	public int getID() { return ID; }
	public String getTitle() { return title; }
	public String getRating() { return rating; }
	
	public void setID(int ID) { this.ID = ID; }
	public void setTitle(String title) { this.title = title; }
	public void setRating(String rating) { this.rating = rating; }
	
	public double calculateLateFees(int daysLate) {
		return 2.00 * daysLate;
	}
	public boolean equals(Movie otherMovie) {
		if (ID == otherMovie.getID()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "ID: " + ID + "\t Movie Title: " + title + "\t Rating: " + rating;
	}
} // end of class Movie
