/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.16
 */
import javax.swing.DefaultListModel;

public class AddressBookModel extends DefaultListModel<String> {
	
		/**
		 * Constructor for class AddressBook
		 */
		public AddressBookModel() {
			super();
		}

		/**
		 * Adds a BuddyInfo object to the address book
		 * 
		 * @param obuddyInfo
		 */
		public void addBuddy(BuddyInfo obuddyInfo) {
			if (obuddyInfo != null) {
				boolean unique = true;
				
				for (int i = 0; i < this.size(); i ++) {
					if (obuddyInfo.toString().equals(this.get(i)))
						unique = false;
				}
				
				if (unique)
					this.addElement(obuddyInfo.toString());
			}
			
		}
		
		public void editBuddy(int index, BuddyInfo buddy) {
			this.set(index, buddy.toString());
		}
	
		public void removeBuddy(int index) {
			this.remove(index);
		}
		
}
