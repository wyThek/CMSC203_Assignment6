
public class Customer {

	private int age;
	private String name;

	/**
	 * Constructor
	 * @param name name of the customer
	 * @param age  age of the customer
	 */
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * overloading constructor with different parameter.
	 * @param c Customer object
	 */
	public Customer(Customer c) {
		this.name = c.name;
		this.age = c.age;
		Customer deepCustomer = new Customer(c.getName(), c.getAge());
	}

	/**
	 * setter for customer name
	 * @param n string name of the customer
	 */
	public void setName(String n) {
		this.name = n;
	}

	/**
	 * getter of the name of the customer
	 * @return String as the name of the customer
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter of the age
	 * @param a age of the customer
	 */
	public void setAge(int ageSet) {
		age = ageSet;
	}

	/**
	 * getter of the age 
	 * @return int as the age of the customer
	 */
	public int getAge() {
		return age;
	}

	@Override
	/**
	 * the toString method
	 * @return String info of the customer
	 */
	public String toString() {
		String str = "";
		str += "Customer name: " + getName();
		str += "Customer age: " + getAge();
		return str;
	}

}