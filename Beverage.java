
public abstract class Beverage {

	/*
	 * variables
	 */
	public String name;
	public TYPE beverageType;
	public SIZE size;
	public boolean weekend = false;
	private final double BASE_PRICE = 2.0;
	private final double UPSELL_PRICE = 1.0;

	/**
	 * Constructor
	 * 
	 * @param a name of the beverage
	 * @param b type of the beverage (coffee, alcohol, or smoothie)
	 * @param c size of the beverage
	 */
	public Beverage(String a, TYPE b, SIZE c) {
		this.name = a;
		this.beverageType = b;
		this.size = c;
	}

	/**
	 * calculate price, override in other classes
	 * 
	 * @return double value as price
	 */
	public abstract double calcPrice();

	/**
	 * to compare two different objects.
	 * 
	 * @param bev beverage object to be compared
	 * @return boolean value, true if both are the same. false if both are not the
	 *         same.
	 */
	public boolean equals(Object bev) {
		if (!(bev instanceof Beverage)) {
			return false;
		}

		Beverage beverage = (Beverage) bev;

		if (this.beverageType == beverage.beverageType && this.name == beverage.name && this.size == beverage.size) {
			return true;
		}
		return false;
	}

	/**
	 * setter of the name of the beverage
	 * 
	 * @param n String name of the beverage
	 */
	public void setBevName(String n) {
		this.name = n;
	}

	/**
	 * getter of the beverage's name
	 * 
	 * @return String beverage's name
	 */
	public String getBevName() {
		return name;
	}

	/**
	 * setter of the type of the beverage
	 * 
	 * @param t TYPE object
	 */
	public void setType(TYPE t) {
		this.beverageType = t;
	}

	/**
	 * getter of the type
	 * 
	 * @return TYPE object
	 */
	public TYPE getType() {
		return beverageType;
	}

	/**
	 * setter of the size of the beverage
	 * @param s SIZE object
	 */
	public void setSize(SIZE s) {
		this.size = s;
	}

	/**
	 * getter of the size
	 * @return SIZE object
	 */
	public SIZE getSize() {
		return size;
	}

	/**
	 * getter of the price
	 * @return double as base price of the beverage
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}

	/**
	 * @return UPSELL_PRICE for a larger size
	 */
	public double getUPSELL_PRICE() {
		return UPSELL_PRICE;
	}

	/**
	 * to string method.
	 * 
	 * @return String details of the beverage
	 */
	public String toString() {
		String str = "The beverage is " + name + " and it's size is " + size;
		return str;
	}

}