package movierental;

import java.util.ArrayList;
import java.util.List;

/**
 * A customer who rents movies.
 * The customer object holds information about the
 * movies rented for the current billing period,
 * and can print a statement of his rentals.
 */
public class Customer {
	/** Customer's name. */
	private String name;
	/** Customer's rentals for current billing period. */
	private List<Rental> rentals;
	
	/** Initialize a new customer. */
	public Customer(String name) {
		this.name = name;
		this.rentals = new ArrayList<Rental>();
	}
	
	public void addRental(Rental rental) {
		if (! rentals.contains(rental)) rentals.add(rental);
	}
	
	public String getName() {
		return name;
	}

	/** Print all the rentals in current period, 
	 * along with total charges and reward points.
	 * @return the statement as a String
	 */
	public String statement() {
		double amount = 0; // total charges
		int frequentRenterPoints = 0; // frequent renter points
		StringBuilder stmt = new StringBuilder("Rental Report for "+getName()).append("\n\n");
		// header for details section
		stmt.append(String.format("%-40.40s %4s %-8s\n", "Movie Title", "Days", "Price"));
		
		for(Rental rental: rentals) {
			// award renter points for each rental
			if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) frequentRenterPoints += rental.getDaysRented();
			else frequentRenterPoints++;
			
			// one line of detail for this movie
			double thisAmount = rental.calculatedRentalFee();
			stmt.append(String.format("%-40.40s %3d %8.2f\n", rental.getMovie().getTitle(), rental.getDaysRented(), thisAmount));
			amount += thisAmount;
		}
		// footer: summary of charges
		stmt.append( String.format("%-44.44s %8.2f\n", "Total Charges", amount));
		stmt.append( String.format("%-44.44s %5d\n","Frequent Renter Points earned", frequentRenterPoints) );
		
		return stmt.toString();
	}
}
