
public class Coffee extends Beverage {
	private TYPE beverageType = TYPE.COFFEE;
	private boolean shotOfCoffee;
	private boolean extraSyrup;
	private final double EXTRA_SHOT_PRICE = .50;
	private final double EXTRA_SYRUP_PRICE = .50;

	/**
	 * constructor
	 * @param name  name of the drink
	 * @param s     the size of the drink
	 * @param shot  boolean value to indicate if it contains extra shot
	 * @param syrup boolean value to indicate if it contains extra syrup
	 */
	public Coffee(String name, SIZE s, boolean shot, boolean syrup) {
		super(name, TYPE.COFFEE, s);
		this.shotOfCoffee = shot;
		this.extraSyrup = syrup;
	}

	@Override
	/**
	 * to calculate the price of the coffee drink
	 * @return the price of the drink
	 */
	public double calcPrice() {
		double totalPrice = super.getBasePrice();
		if (this.shotOfCoffee == true) {
			totalPrice += .50;
		}
		if (this.extraSyrup == true) {
			totalPrice += .50;
		}
		if (super.getSize() == SIZE.MEDIUM) {
			totalPrice += super.getUPSELL_PRICE();
		}
		if (super.getSize() == SIZE.LARGE) {
			totalPrice += super.getUPSELL_PRICE() * 2;
		}
		return totalPrice;
	}

	/**
	 * if the customer get an extra shot of coffee
	 * @return boolean indication of extra shot 
	 */
	public boolean getExtraShot() {
		return shotOfCoffee;
	}

	/**
	 * setter of the shot
	 * @return boolean indication if it contains syrup
	 */
	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	/**
	 * getter of the cost
	 * @return double as the price of the drink
	 */
	public double getEXTRA_SHOT_PRICE() {
		return EXTRA_SHOT_PRICE;
	}

	/**
	 * getter of the cost when syrup is added
	 * @return double as the price of the drink
	 */
	public double getEXTRA_SYRUP_PRICE() {
		return EXTRA_SYRUP_PRICE;
	}

	/**
	 * to check equality of the coffee objects
	 * @param otherBev the object to be compared
	 * @return the boolean value of the result
	 */
	public boolean equals(Object otherBev) {
		if (!(otherBev instanceof Coffee)) {
			return false;
		}
		Coffee coffee = (Coffee) otherBev;
		if (beverageType == coffee.beverageType && super.name == coffee.name && this.size == coffee.size
				&& this.shotOfCoffee == coffee.shotOfCoffee && this.extraSyrup == coffee.extraSyrup) {
			return true;
		}
		return false;
	}

	/**
	 * the toString method which return a string of info about the coffee drink.
	 * @return String info of the coffee.
	 */
	public String toString() {
		String str = "The beverage is " + getBevName() + " and it's size is " + getSize() + " it's price "
				+ calcPrice();
		return str;
	}

}