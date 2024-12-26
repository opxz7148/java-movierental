package movierental;
/**
 * A movie available for rent.
 */
public class Movie {
	/** The classes of movies. */
	public static final Price REGULAR = new RegularPrice();
	public static final Price NEW_RELEASE = new NewReleasePrice();
	public static final Price CHILDRENS = new ChildrenPrice();
	
	/** movie price code based on classification */
	private Price priceCode;
	/** the title, of course */
	private String title;
	
	/** Initialize a new movie. */
	public Movie(String title, Price priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	/**
	 * @return the priceCode
	 */
	public Price getPriceCode() {
		return priceCode;
	}

	/**
	 * @param priceCode the priceCode to set
	 */
	public void setPriceCode(Price priceCode) {
		this.priceCode = priceCode;
	}
	
	/** Return the movie title */
	public String getTitle() {
		return this.title;
	}
	
	public String toString() {
		return this.title;
	}
}
