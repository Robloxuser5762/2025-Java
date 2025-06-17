package apCSA2025;
import java.util.ArrayList;
public class MovieMain {
	public static double lateFeesOwed(ArrayList<MovieRental> arrL) {
		double totalFees = 0;
		for (MovieRental element: arrL) {
			totalFees += element.rentalFees();
		}
		return totalFees;
	}
	public static void main(String[] args) {
		Movie movie1 = new Action(1245, "Die Hard", "PG");
		Movie movie2 = new Movie(1246, "A Beautiful Mind", "PG-13");
		Movie movie3 = new Movie(1247, "Avatar", "PG-13");
		Movie movie4 = new Drama(1248, "Hamilton", "PG-13");
		Movie movie5 = new Comedy(1249, "Oceans 11", "G");
		Movie genshinMovie = new Drama();
		genshinMovie.setID(435124);
		genshinMovie.setTitle("Furina de Fontaine");
		genshinMovie.setRating("PG-13");
		System.out.println(genshinMovie.getID());
		System.out.println(genshinMovie.getRating());
		System.out.println(genshinMovie.getTitle());
		System.out.println(genshinMovie.calculateLateFees(8));
		
		System.out.println(movie1);
		System.out.println(movie2);
		System.out.println(movie3);
		System.out.println(movie4);
		System.out.println(movie5);
		System.out.println(movie3.calculateLateFees(8));
		System.out.println(movie5.calculateLateFees(2));
		System.out.println(movie1.equals(movie5));
		
		MovieRental rent1 = new MovieRental(4560, "Hamilton", 2, "Drama");
		MovieRental rent2 = new MovieRental(1239, "Avatar", 5, "Movie");
		MovieRental rent3 = new MovieRental(7311, "A Beautiful Mind", 7, "Movie");
		MovieRental rent4 = new MovieRental(4567, "Die Hard", 1, "Action");
		MovieRental rent5 = new MovieRental(4566, "Ocean 11", 0, "Comedy");
		
		ArrayList<MovieRental> rentList = new ArrayList<>();
		rentList.add(rent1);
		rentList.add(rent2);
		rentList.add(rent3);
		rentList.add(rent4);
		rentList.add(rent5);
		System.out.println(rentList);
		System.out.println(lateFeesOwed(rentList));
	}
} // end of class MovieMain
