package movierental;

/**
 * Demo the use of Customer statement function.
 */
public class StatementDemo {
	public static void main(String[] args) {
		Movie[] movies = new Movie[] {
				new Movie("Bridge of Spies", Movie.NEW_RELEASE),
				new Movie("CitizenFour", Movie.REGULAR),
				new Movie("Frozen", Movie.CHILDRENS),
				new Movie("El Camino", Movie.NEW_RELEASE),
				new Movie("Particle Fever", Movie.REGULAR)
		};
		Customer cust = new Customer("Edwin Snowden");
		for(Movie m: movies) {
			cust.addRental(new Rental(m, days));
			days++;
		}
		System.out.println( cust.createStatement() );
	}
}
