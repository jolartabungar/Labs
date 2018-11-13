/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.16
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class AddressBookController {
	
	private AddressBookView view;
	private AddressBookModel model;
	private String name;
	
	public AddressBookController() {
		createAddressBook();
		view = new AddressBookView(this, model);
	}
	
	/**
	 * Creates a new AddressBook
	 */
	public void createAddressBook() {
		name = JOptionPane.showInputDialog("Enter the name of the Addressbook:");
		
		if (model != null)
			model.removeAllElements();
		else
			model = new AddressBookModel();
	}
	
	/**
	 * Saves the Current Address Book
	 * @throws IOException
	 */
	public void saveAddressBook() throws IOException {
		String s = model.toString();
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("" + name +".txt"));
			out.write(s);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Add a new BuddyInfo object with values prompted from the user
	 */
	public void addBuddy() {
		BuddyInfo currentBuddyInfo = new BuddyInfo();
		
		currentBuddyInfo.setName(JOptionPane.showInputDialog("Enter the buddy's name:"));
		currentBuddyInfo.setAddress(JOptionPane.showInputDialog("Enter the buddy's address:"));
		currentBuddyInfo.setNumber(JOptionPane.showInputDialog("Enter the buddy's phone number:"));
	
		model.addBuddy(currentBuddyInfo);
		
		//enable the disabled menu items
		view.enableMenuItems();
		
	}
	
	public void editBuddy(int index) {
		BuddyInfo currentBuddyInfo = new BuddyInfo();
		
		currentBuddyInfo.setName(JOptionPane.showInputDialog("Edit the buddy's name:"));
		currentBuddyInfo.setAddress(JOptionPane.showInputDialog("Edit the buddy's address:"));
		currentBuddyInfo.setNumber(JOptionPane.showInputDialog("Edit the buddy's phone number:"));
		
		model.editBuddy(index, currentBuddyInfo);
	}
	
	public void removeBuddy(int index) {
		model.removeBuddy(index);
		if (model.isEmpty())
			view.disableMenuItems();
	}
	
	public static void main(String[] arg) {
		AddressBookController control = new AddressBookController();
	}

}
