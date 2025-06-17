package apCSA2025;
public class Action extends Movie {
	public Action() { super(25089, "Battle for Collectibleville Elimination", "PG-13"); }
	public Action(int ID, String title, String rating) { super(ID, title, rating); }
	
	public double calculateLateFees(int daysLate) {
		return 3.00 * daysLate;
	}
	
	public String toString() {
		return super.toString() + "\t Genre: Action";
	}
} // end of class Action