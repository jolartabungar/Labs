
import java.util.ArrayList;

/**
 * 
 * @author Jolar Tabungar: 101030060
 * @version 2018.10.30
 * 
 *          Lab 7 AddressBook Class
 * 
 */
public class AddressBook {

	// Array List to contain all added inserted BuddyInfo objects
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
		if (obuddyInfo != null) {
			boolean unique = true;

			for (int i = 0; i < addressBook.size(); i++) {
				if (obuddyInfo.equals(addressBook.get(i)))
					unique = false;
			}

			if (unique)
				addressBook.add(obuddyInfo);
		}

	}

	/**
	 * Removes the BuddyInfo object at that index
	 * 
	 * @param index
	 *            the index of the object to be removed
	 */
	public void removeBuddy(int index) {
		if (index >= 0 && index <= addressBook.size())
			addressBook.remove(index);
	}

	public String toString() {
		String allBuddies = "";

		for (int i = 0; i < addressBook.size(); i++) {
			allBuddies = allBuddies + addressBook.get(i).toString();
		}

		return allBuddies;
	}
	
	/**
	 * @return the number of buddies in the addressBook
	 */
	public int size() {
		return addressBook.size();
	}
	
	/**
	 * Remove all buddies from the addressBook
	 */
	public void clear() {
		addressBook.clear();
	}
	

}