
/** @author Jolar Tabungar 101030060
 * @version 2018.10.09
 * 
 * AddressBook GUI
 * Allows the user to create, save and display AddressBook Objects
 * 
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddressBookGUI_MVC {
	
	private static AddressBook currentAddressBook;
	private static BuddyInfo currentBuddyInfo;
	private static String title;
	
	private static JMenuItem createAddressBook;
	private static JMenuItem saveAddressBook;
	private static JMenuItem displayAddressBook;
	
	private static JMenuItem addBuddyInfo;
	
	private AddressBookModel addressBookModel;
	private AddressBookView addressBookView;
	
	static JTextArea displayText;
	
	public static void createGUI() {
		//Create frame and content pane
        JFrame frame = new JFrame("Address Book");
        Container contentPane = frame.getContentPane();
        
        //Set contentPane to BorderLayout
        contentPane.setLayout(new BorderLayout());
        
        //Create the AddressBook Menu bar
        JMenuBar menuBar = new JMenuBar();
        
        //Create the menus
        JMenu addressBookMenu = new JMenu("AddressBook Menu");
        JMenu buddyInfoMenu = new JMenu("BuddyInfo Menu");
        
        //Add the menus
        menuBar.add(addressBookMenu);
        menuBar.add(buddyInfoMenu);
        
        //Create and initialize the menu items with their respective actionListeners
        createAddressBook = new JMenuItem("Create");
        createAddressBook.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        createAddressBook();
                    }
                }
        );
        
        saveAddressBook = new JMenuItem("Save");
        saveAddressBook.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
							saveAddressBook();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    }
                }
        );
        
        displayAddressBook = new JMenuItem("Display");
        displayAddressBook.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        displayAddressBook();
                    }
                }
        );
        
        addBuddyInfo = new JMenuItem("Add");
        addBuddyInfo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addBuddy();
                    }
                }
        );
        
        //Add the menus
        addressBookMenu.add(createAddressBook);
        addressBookMenu.add(saveAddressBook);
        addressBookMenu.add(displayAddressBook);
        
        //Disable unusable menuItems on startup
        disableMenuItems();
        
        buddyInfoMenu.add(addBuddyInfo);
        
        //Initialize the JTextArea displayText
        displayText = new JTextArea(30, 50);
        displayText.setText("NOTHING TO SEE FOR NOW...");
        
        //Add all the components to the contentPane
        contentPane.add(menuBar, BorderLayout.NORTH);
        contentPane.add(displayText, BorderLayout.CENTER);
        
        //Pack the frame and its components and set it visible
        frame.pack();
        frame.setResizable(false);
        frame.setLocation(100, 100);
        frame.setVisible(true);
	}
	
	/**
	 * Enable all menu items
	 */
	public static void enableMenuItems() {
		saveAddressBook.setEnabled(true);
        displayAddressBook.setEnabled(true);
        addBuddyInfo.setEnabled(true);
	}
	
	/**
	 * Disable unusable menu items
	 */
	public static void disableMenuItems() {
		saveAddressBook.setEnabled(false);
        displayAddressBook.setEnabled(false);
        addBuddyInfo.setEnabled(false);
	}
	
	/**
	 * Creates a new AddressBook
	 */
	public static void createAddressBook() {
		title = JOptionPane.showInputDialog("Enter the name of the Addressbook:");
		displayText.setText("Created new AddressBook: " + title);
		displayText.setEditable(false);
		currentAddressBook = new AddressBook();
		
		//enable the disabled menu items
		enableMenuItems();
	}
	
	/**
	 * Saves the Current Address Book
	 * @throws IOException
	 */
	public static void saveAddressBook() throws IOException {
		String s = currentAddressBook.toString();
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("" + title +".txt"));
			out.write(s);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Updates the display with the current iteration of the AddressBook
	 */
	public static void displayAddressBook() {
		displayText.setText(currentAddressBook.toString());
	}
	
	/**
	 * Add a new BuddyInfo object with values prompted from the user
	 */
	public static void addBuddy() {
		currentBuddyInfo = new BuddyInfo();
		
		currentBuddyInfo.setName(JOptionPane.showInputDialog("Enter the buddy's name:"));
		currentBuddyInfo.setAddress(JOptionPane.showInputDialog("Enter the buddy's address:"));
		currentBuddyInfo.setNumber(JOptionPane.showInputDialog("Enter the buddy's phone number:"));
	
		currentAddressBook.addBuddy(currentBuddyInfo);
		
	}
	
	public static void main(String[] args) {
		//Create a new GUI
		createGUI();
	}

}
