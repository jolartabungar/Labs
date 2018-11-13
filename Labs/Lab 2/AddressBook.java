import java.util.ArrayList;

/**
 * 
 * @author Jolar Tabungar: 101030060
 * @version 2018.09.18
 * 
 * Lab2 AddressBook Class
 *  
 */
public class AddressBook {
	
	//Array List to contain all added inserted BuddyInfo objects
	private static ArrayList<BuddyInfo> addressBook;
	
	/**
	 * Constructor for class AddressBook
	 */
	public AddressBook() {
		addressBook = new ArrayList<BuddyInfo>();

	}

	/**
	 * Adds a BuddyInfo object to the address book
	 * 
	 * @param obuddyInfo
	 */
	public void addBuddy(BuddyInfo obuddyInfo) {
		if (obuddyInfo != null)
			addressBook.add(obuddyInfo);
	}
	
	/**
	 * Removes the BuddyInfo object at that index
	 * 
	 * @param index the index of the object to be removed
	 */
	public void removeBuddy(int index) {
		if (index >= 0 && index <= addressBook.size())
			addressBook.remove(index);
	}
	
	/**
	 * 
	 * main method()
	 * Create a BuddyInfo object, add it to the address book and then remove it
	 * 
	 */
	public static void main(String[] args) {
		
		BuddyInfo buddy = new BuddyInfo("Jak", "100 First St.", "911");
		
		AddressBook oaddressBook = new AddressBook();
		oaddressBook.addBuddy(buddy);
		oaddressBook.removeBuddy(0);
		
		
	}

	
}
