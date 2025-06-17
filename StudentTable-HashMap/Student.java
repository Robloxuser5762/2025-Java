package apCSA2025;
// This Student class is more advanced than all other previous versions of the class.
public class Student {
	private int ID;
	private String name;
	private Date hireDate;
	
	public Student() {
		ID = 1000;
		name = "Jen Samuels";
		hireDate = new Date();
	}
	public Student(int i, String n, Date hDate) {
		if (n == null || hDate == null) {
			System.out.println("FATAL error creating student!");
			System.exit(0);
		}
		ID = i;
		name = n;
		hireDate = hDate;
	}
	
	public int getID() { return ID; }
	public String getName() { return name; }
	public Date getHireDate() { return hireDate; }
	
	/** Precondition: newName is not null */
	public void setName(String n) {
		if (n == null) {
			System.out.println("FATAL error!");
			System.exit(0);
		}
		name = n;
	}
	/** Precondition: newDate is not null */
	public void setHireDate(Date hDate) {
		if (hDate == null) {
			System.out.println("FATAL error!");
			System.exit(0);
		}
		hireDate = hDate;
	}
	
	public String toString() { return (getID() + " " + getName() + " " + getHireDate().toString()); }
} // end of class Student