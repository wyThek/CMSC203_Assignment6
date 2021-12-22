public class Smoothie extends Beverage {

	private int numOfFruits;
	private TYPE beverageType = TYPE.SMOOTHIE;
	private boolean proteinPowderUpsell;
	private final double PROTEIN_PRICE = 1.50;
	private final double FRUIT_PRICE = .50;

	/**
	 * Constructor
	 * @param name  name of the smoothie
	 * @param s     size of the smoothie
	 * @param fruits number of fruits to be added into the smoothie
	 * @param p     indication if the smoothie contains protein.
	 */
	public Smoothie(String name, SIZE s, int fruits, boolean p) {
		super(name, TYPE.SMOOTHIE, s);
		this.numOfFruits = fruits;
		this.proteinPowderUpsell = p;
	}

	/**
	 * getter of the num of fruits.
	 * @return int bumber of fruits
	 */
	public int getNumOfFruits() {
		return numOfFruits;
	}

	/**
	 * setter of protein
	 * @param p boolean indication if the drink contains protein.
	 */
	public boolean getAddProtien() {
		return proteinPowderUpsell;
	}

	@Override
	/**
	 * to calculate price of the smoothie according to its customization
	 * @return double the cost of this smoothie
	 */
	public double calcPrice() {
		double totalPrice = 0;
		totalPrice = super.getBasePrice();
		if (this.proteinPowderUpsell == true) {
			totalPrice += PROTEIN_PRICE;
		}
		if (this.getNumOfFruits() > 0) {
			totalPrice += (this.getNumOfFruits() * FRUIT_PRICE);
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
	 * to compare objects
	 * @param ss the object to be compared
	 * @return boolean boolean value to indicate equality
	 */
	public boolean equals(Object otherBev) {
		if (!(otherBev instanceof Smoothie)) {
			return false;
		}
		Smoothie smoothie = (Smoothie) otherBev;
		if (beverageType == smoothie.beverageType && super.name == smoothie.name && this.size == smoothie.size
				&& this.getNumOfFruits() == smoothie.getNumOfFruits()
				&& this.getAddProtien() == smoothie.getAddProtien()) {
			return true;
		}
		return false;
	}

	@Override
	/**
	 * the toString method
	 * @return String string info of the smoothie
	 */
	public String toString() {
		String str = "The beverage is " + super.getBevName() + " and it's size is " + super.getSize() + " it's price "
				+ this.calcPrice();
		return str;
	}

}