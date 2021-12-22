
/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description:  A program that automates order transactions, reports, and purchase in the Bradley Beverage Shop.
 * Due: 12/06/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Yei Thek Wang
*/
import java.util.*;

public class BevShop implements BevShopInterface {

	/**
	 * variables
	 */
	private int count_alcohol_drinks = 0;
	private Order currentOrder;
	private ArrayList<Order> list = new ArrayList<Order>();

	@Override
	/**
	 * method to check if the time is valid.
	 * @param time the time when order is made
	 * @return boolean value.
	 */
	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * to check with the limit to order an alcoholic drinks, maximum 3.
	 * @return boolean value.
	 */
	public boolean eligibleForMore() {
		// tests count of drinks
		if (count_alcohol_drinks < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}

		return false;
	}

	@Override
	/**
	 * to check if the customer's age is eligible to order an alcoholic beverage.
	 * @param age the customer's age
	 * @return boolean value
	 */
	public boolean validAge(int age) {
		// tests age of customer
		if (age <= MIN_AGE_FOR_ALCOHOL) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	/**
	 * to create a new order
	 * @param time the time when this order is created.
	 * @param day the day when this order is created.
	 * @param customerName the name of the customer.
	 * @param customerAge the age of the customer.
	 */
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		list.add(currentOrder);
	}

	/**
	 * getter of the current order
	 * @return Order object
	 */
	public Order getCurrentOrder() {
		return currentOrder;
	}

	@Override
	/**
	 * to add a coffee into the order
	 * @param bevName  name of the drink
	 * @param size size of the coffee
	 * @param estraShot do the customer want to add extra shot or not.
	 * @param estraSyrup do the customer want to add syrup or not.
	 */
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	/**
	 * to add the alcoholic order into the customer's order
	 * @param bevName the name of the alcoholic drinks. 
	 * @param size the size of the drinks.
	 */
	public void processAlcoholOrder(String bevName, SIZE size) {
		if (validAge(getCurrentOrder().getCustomer().getAge()) == true) {
			getCurrentOrder().addNewBeverage(bevName, size);
		}
	}

	@Override
	/**
	 * to add the smoothie into the customer's order
	 * @param bevName the name of the smoothie
	 * @param size the size of the drinks.
	 * @param numOfFruits the number of fruits to be added into the smoothie
	 * @param addProtein true if the customer wants to add protein into the smoothie
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	@Override
	/**
	 * to find the order from the arraylist using the order number.
	 * @param orderNo the unique order id of each order
	 * @return int the index of that order.
	 */
	public int findOrder(int orderNo) {
		// for loop for running through orders
		for (int index = 0; index < list.size(); index++) {
			Order order = list.get(index);
			// find correct order based on order number and add those to the accumulator
			if (order.getOrderNo() == orderNo) {
				return index;
			}
		}
		return -1;
	}

	@Override
	/**
	 * to retrieve the total payment of a order
	 * @param orderNo the order number
	 * @return double the cost of the bill
	 */
	public double totalOrderPrice(int orderNo) {
		double totalPrice = 0;
		for (int index = 0; index < list.size(); index++) {
			Order currentOrder = list.get(index);
			if (currentOrder.getOrderNo() == orderNo) {
				totalPrice += currentOrder.calcOrderTotal();
			}
		}
		return totalPrice;
	}

	@Override
	/**
	 * to calculate the total monthly sales
	 * @return double the total amount of sale of the month.
	 */
	public double totalMonthlySale() {
		double totalPrice = 0;
		for (int index = 0; index < list.size(); index++) {
			Order currentOrder = list.get(index);
			totalPrice += currentOrder.calcOrderTotal();
		}
		return totalPrice;
	}
	
	@Override
	/**
	 * This will use the compareTo method with the comparable interface the BevShop
	 * class implements to sort the orders list in ascending order. Uses a selection
	 * sort algorithm.
	 */
	public void sortOrders() {
		list.sort(null);
	}

	/**
	 * return the total num of orders
	 * @return int total num of orders
	 */
	public int totalNumOfMonthlyOrders() {
		int totalCount = list.size();
		return totalCount;
	}

	@Override
	/**
	 * getter of the index of the current order
	 * @return Order object
	 */
	public Order getOrderAtIndex(int index) {
		Order orderAtIndex = list.get(index);
		return orderAtIndex;
	}

	/**
	 * calculates the number of alcoholic drinks in the currently selected order
	 * 
	 * @return alcoholicDrinks
	 */
	public int getNumOfAlcoholDrink() {
		int alcoholicDrinks = 0;
		for (int index = 0; index < list.size(); index++) {
			Order currentOrder = list.get(index);
			alcoholicDrinks = currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
		}
		count_alcohol_drinks = alcoholicDrinks;
		return alcoholicDrinks;
	}

	/**
	 * getter of the max order for alcohol
	 * @return max is 3
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
	 * getter of the legal age to order alcohol
	 * @return int of minimum drinking age 
	 */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * The max num of fruit a customer can buy
	 * @param numOfFruits the number of fruits customer is buying
	 * @return the indication of if the max number of fruits has been reached
	 */
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * toString Method.
	 */
	public String toString() {
		String str = "" + totalMonthlySale();
		for (int index = 0; index < list.size(); index++) {
			Order order = list.get(index);
			str += order.toString();
		}
		return str;
	}

}