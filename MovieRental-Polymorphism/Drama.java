package apCSA2025;
public class Drama extends Movie {
	public Drama() { super(8332, "Your Typical Drama Show", "PG-13"); }
	public Drama(int ID, String title, String rating) { super(ID, title, rating); }
	
	public double calculateLateFees(int daysLate) {
		return 2.00 * daysLate;
	}
	
	public String toString() {
		return super.toString() + "\t Genre: Drama";
	}
} // end of class Drama
