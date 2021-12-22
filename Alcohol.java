
public class Alcohol extends Beverage {
	/**
	 * instance variables
	 */
	private final TYPE beverageType = TYPE.ALCOHOL;
	public boolean isWeekend;
	public final double ALCOHOL_PRICE = .60;

	/**
	 * The Alcohol constructor
	 * 
	 * @param name      name of the alcoholic beverage
	 * @param size      size of the beverage
	 * @param isWeekend indication if today is weekend or weekday.
	 */
	public Alcohol(String name, SIZE size, boolean isWeekend) {
		super(name, TYPE.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	@Override
	/**
	 * compare alcohol object
	 * 
	 * @param alc the alcohol object to be compared
	 * @return boolean value of the result.
	 */
	public boolean equals(Object alc) {
		if (!(alc instanceof Alcohol)) {
			return false;
		}
		Alcohol alcohol = (Alcohol) alc;

		if (this.beverageType == alcohol.beverageType && this.name == alcohol.name && this.size == alcohol.size
				&& this.isWeekend == alcohol.isWeekend && this.ALCOHOL_PRICE == alcohol.ALCOHOL_PRICE) {
			return true;
		}
		return false;
	}

	/**
	 * to calculate the price of the alcoholic drinks on different days with different sizes
	 * @return double the price of the alcoholic drinks.
	 */
	public double calcPrice() {

		double totalPrice = 0;
		totalPrice = super.getBasePrice();

		if (isWeekend == true) {
			totalPrice += ALCOHOL_PRICE;
		}
		if (super.getSize() == SIZE.MEDIUM) {
			totalPrice += super.getUPSELL_PRICE();
		}
		if (super.getSize() == SIZE.LARGE) {
			totalPrice += super.getUPSELL_PRICE() * 2;
		}
		return totalPrice;
	}

	@Override
	/**
	 * the toString method.
	 * @return String string details of the price of the alcohol on different days.
	 */
	public String toString() {
		String str = "The beverage is " + super.getBevName() + " and it's size is " + super.getSize() + " it's price "
				+ this.calcPrice();

		return str;
	}

}