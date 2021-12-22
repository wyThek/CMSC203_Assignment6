import java.util.*;

public class Order implements OrderInterface, Comparable<Object> {

	/*
	 * declare variables
	 */
	public int orderNum;
	private int orderTime;
	private DAY day;
	private Customer newCustomer;
	private ArrayList<Beverage> list = new ArrayList<Beverage>();

	/**
	 * constructor
	 * @param time     the time when this order was made
	 * @param day      the day when this order was made.
	 * @param customer the customer object( contain name and age)
	 */
	public Order(int time, DAY day, Customer customer) {
		this.orderTime = time;
		this.day = day;
		this.newCustomer = customer;
		this.orderNum = randomNum();
	}

	/**
	 * to generate a random order number
	 * @return int random number
	 */
	public int randomNum() {
		Random random = new Random();
		int randNum = random.nextInt(90000) + 10000;
		return randNum;
	}

	@Override
	/**
	 * add a new beverage (for coffee)
	 * @param bevName the name of the coffee
	 * @param extraShot the indication that tells if the coffee contains extra shot
	 * @param extraSyrup the indication that tells if the coffee contains extra syrup
	 */
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		list.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	@Override
	/**
	 * add a new beverage into the order (for Alcoholic drinks)
	 * @param bevName the name of the alcohol
	 * @param size the size of the drink
	 */
	public void addNewBeverage(String bevName, SIZE size) {
		list.add(new Alcohol(bevName, size, isWeekend()));
	}

	@Override
	/**
	 * add a new beverage into the order (for smoothie)
	 * @param bevName the name of the smoothie
	 * @param size size of the beverage
	 * @param numOfFruits the number of fruits
	 * @param addProtein boolean value that indicates if the smoothie contains protein
	 */
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		list.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	/**
	 * getter of order number
	 * @return int order number
	 */
	public int getOrderNo() {
		return orderNum;
	}

	/**
	 * getter of ordered time
	 * @return int order time
	 */
	public int getOrderTime() {
		return orderTime;
	}

	/**
	 * getter of the day
	 * @return DAY object
	 */
	public DAY getOrderDay() {
		return day;
	}

	/**
	 * getter of the customer infos
	 * @return Customer object
	 */
	public Customer getCustomer() {
		Customer deepCustomer = new Customer(newCustomer);

		return deepCustomer;
	}

	@Override
	/**
	 * method to check if today is weekend
	 * @return boolean return false if today is weekdays.
	 */
	public boolean isWeekend() {
		boolean isWeekend = false;
		// if it is Saturday or Sunday the isWeekend variable is set to true
		if (this.day == DAY.SATURDAY || this.day == DAY.SUNDAY) {
			isWeekend = true;
		}
		return isWeekend;
	}

	/**
	 * retrieve the beverage object with item number
	 * @param itemNo index to identify a beverage in the beverage list
	 * @return beverage object
	 */
	public Beverage getBeverage(int itemNo) {
		int index = itemNo;
		Beverage beverage = list.get(index);
		if (beverage == null) {
			return null;
		} else {
			return beverage;
		}
	}

	@Override
	/**
	 * to calculate the total cost of this order
	 * @return double the total amount of this bill.
	 */
	public double calcOrderTotal() {
		double orderTotal = 0;
		for (int index = 0; index < list.size(); index++) {
			Beverage beverage = list.get(index);
			orderTotal += beverage.calcPrice();
		}
		return orderTotal;
	}

	@Override
	/**
	 * to count total number of drinks in this order
	 * @param type the type of the beverage, coffee, alcohol, or smoothie
	 * @return int the total num of beverage within this order.
	 */
	public int findNumOfBeveType(TYPE type) {
		int numOfBeveType = 0;
		for (int index = 0; index < list.size(); index++) {
			Beverage beverage = list.get(index);
			if (beverage.getType() == type) {
				numOfBeveType++;
			}
		}
		return numOfBeveType;
	}


	/**
	 * getter of total item
	 * @return number of beverages
	 */
	public int getTotalItems() {
		int totalItems = 0; 
		totalItems = list.size();
		return totalItems;
	}

	/**
	 * toString methods
	 */
	public String toString() {
		String str = getOrderNo() + "/n" + getOrderTime() + "/n" + getOrderDay() + "/n" + getCustomer() + "/n"
				+ calcOrderTotal() + "/n";
		for (int index = 0; index < list.size(); index++) {
			Beverage beverage = list.get(index);
			str += beverage.toString() + "/n";
		}
		return str;
	}

	@Override
	/**
	 * to compare different order numbers.
	 * @param o the Order object
	 * @return int indication if this order number is greater than the previous order number or not.
	 */
	public int compareTo(Object o) {
		if (this.orderNum == ((Order) o).orderNum) {
			return 0;
		}
		return ((this.orderNum > ((Order) o).orderNum) ? 1 : -1);
	}

}