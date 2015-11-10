package movierental;

import movierental.domain.*;
/**
 * Demo the use of Customer statement function.
 * @author jim
 *
 */
public class StatementDemo {
	public static void main(String[] args) {
		Movie[] movies = new Movie[] {
				new Movie("CitizenFour", Movie.REGULAR),
				new Movie("Frozen", Movie.CHILDRENS),
				new Movie("Ex Machina", Movie.NEW_RELEASE),
				new Movie("Bridge of Spies", Movie.NEW_RELEASE),
				new Movie("Particle Fever", Movie.REGULAR)
		};
		Customer cust = new Customer("Movie Maniac");
		int days = 1;
		for(Movie m: movies) {
			cust.addRental(new Rental(m, days));
			days++;
		}
		System.out.println( cust.createStatement() );
	}
}
