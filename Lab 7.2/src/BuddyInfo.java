/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.30
 * 
 *          Lab 7 BuddyInfo Class
 */
public class BuddyInfo {

	private String name;
	private String address;
	private String number;
	private String greeting;
	private int age;

	public BuddyInfo(String name, String address, String number, String greeting, int age) {
		this.name = name;
		this.address = address;
		this.number = number;
		this.greeting = greeting;
		this.age = age;
	}

	public BuddyInfo(BuddyInfo aBuddy) {
		this.name = aBuddy.getName();
		this.address = aBuddy.getAddress();
		this.number = aBuddy.getNumber();
		this.greeting = aBuddy.getGreeting();
		this.age = aBuddy.getAge();
	}

	public String toString() {
		return 	"Name: " + getName() + 
				" | Address: " + getAddress() + 
				" | Phone #: " + getNumber() + 
				" | Greeting: " + getGreeting() + 
				" | Age: " + getAge();
	}

	public boolean equals(BuddyInfo o) {
		if (o.toString().equals(this.toString())) {
			return true;
		}

		else
			return false;
	}

	/**
	 *
	 * @return true if buddy is over 18, false otherwise
	 */
	public boolean isOver18() {
		if (age >= 18)
			return true;
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return greeting
	 */
	public String getGreeting() {
		return greeting;
	}

	/**
	 * @param greeting
	 *            the greeting to set
	 */
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

}