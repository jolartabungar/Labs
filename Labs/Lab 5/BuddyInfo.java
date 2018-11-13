/**
 * 
 * @author Jolar Tabungar; 101030060; Lab Section L1
 * @version 2018.09.11
 *
 */
public class BuddyInfo {
	
	private String name;
	private String address;
	private String number;

	public void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		setName("Homer");
		setAddress("100 Wayview Dr.");
		setNumber("613-229-9981");
		
		System.out.println("Hello " + getName() + ".");
		System.out.println("Your address is: " + getAddress());
		System.out.println("Your number is: " + getNumber());
	}
	
	public BuddyInfo(String name, String address, String number) {
		setName(name);
		setAddress(address);
		setNumber(number);
	}
	
	public BuddyInfo() {
		setName(null);
		setAddress(null);
		setNumber(null);
	}
	
	public String toString() {
		return "" + "Name: " + getName() +
				"\nAddress: " + getAddress() +
				"\nPhone #: " + getNumber() +
				"\n\n";
	}
	
	public boolean equals(BuddyInfo o) {
		if (o.toString().equals(this.toString())) {
			return true;
		}
		
		else 
			return false;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param address the address to set
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
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

}
