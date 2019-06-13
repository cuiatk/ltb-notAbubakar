package labTerminalBB;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
		private String _name;
		private int frequentRenterPoints = 0;
		private Vector<Rental> _rentals = new Vector<Rental>();
		public Customer (String name){
			_name = name;
		};
		public void addRental(Rental arg) {
			_rentals.addElement(arg);
		}
		public String getName (){
			return _name;
		};
		
		public int frequentRenterPointss (){
			return frequentRenterPoints;
		};
		
		/*
		 * TODO 4		20 Marks
		 * Identify the bad smells in the statement method and refactor the code
		 * In case you add a new method also provide specifications for new method
		 * after refactoring all test cases must still be passed
		 * Commit after each change and include a meaningful message about the change you made
		 * e.g. Method Move methodName();
		 * 
		 */
		
		/**
		 * TODO 3		10 Marks
		 * Provide suitable specification for statement method 
		 */
		
		/**
	     * Prints the overall bill generated.
	     * 
	     * @param nothing.
	     * 
	     * @return String
	     * 				all information about customer purchasing.
	     * 	          
	     */
		
		public String statement() {
		double totalAmount = 0;
		
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			
			Rental each = (Rental) rentals.nextElement();
			
			//determine amounts for each line
			double currentAmount = calculateAmount(each);
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&&
					each.getDaysRented() > 1) frequentRenterPoints ++;
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(currentAmount) + "\n";
			totalAmount += currentAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) +
				"\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
		+
		" frequent renter points";
		return result;
	}
		
		
		private double calculateAmount(Rental each) {
			double currentAmount = 0;
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				currentAmount += 2;
				if (each.getDaysRented() > 2)
					currentAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				currentAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				currentAmount += 1.5;
				if (each.getDaysRented() > 3)
					currentAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
			return currentAmount;
		}
}
