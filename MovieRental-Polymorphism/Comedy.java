package apCSA2025;
public class Comedy extends Movie {
	public Comedy() { super(4429, "Funny joke (ft. Glare)", "PG"); }
	public Comedy(int ID, String title, String rating) { super(ID, title, rating); }
	
	public double calculateLateFees(int daysLate) {
		return 2.50 * daysLate;
	}
	
	public String toString() {
		return super.toString() + "\t Genre: Comedy";
	}
} // end of class Comedy
