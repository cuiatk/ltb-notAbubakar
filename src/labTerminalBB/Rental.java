package labTerminalBB;

public class Rental {
	private Movie _movie;
	private int _daysRented;
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	public int getDaysRented() {
		return _daysRented;
	}
	public Movie getMovie() {
		return _movie;
	}
	
	/**
     * Calculates price for every movie rented with respect to its type & number of days rented.
     * 
     * @param nothing.
     * 
     * @return int
     * 				calculated amount.
     * 	          
     */
	
	double calculateAmount() {
		double currentAmount = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			currentAmount += 2;
			if (getDaysRented() > 2)
				currentAmount += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			currentAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			currentAmount += 1.5;
			if (getDaysRented() > 3)
				currentAmount += (getDaysRented() - 3) * 1.5;
			break;
		}
		return currentAmount;
	}
}
