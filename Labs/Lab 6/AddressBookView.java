/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.16
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class AddressBookView extends JFrame{

	private AddressBookModel model;
	private AddressBookController controller;
	private JList view;
	
	private JMenuItem createAddressBook;
	private JMenuItem saveAddressBook;
	
	private JMenuItem addBuddyInfo;
	private JMenuItem editBuddyInfo;
	private JMenuItem removeBuddyInfo;
	
	public AddressBookView(AddressBookController controller, AddressBookModel model) {
		super("Address Book");
		
		this.controller =  controller;
		this.model = model;
	    this.subscribeTo(model);
		
		this.getContentPane().setLayout(new BorderLayout());

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
                        controller.createAddressBook();
                    }
                }
        );
        
        saveAddressBook = new JMenuItem("Save");
        saveAddressBook.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
							controller.saveAddressBook();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    }
                }
        );
        
        
        addBuddyInfo = new JMenuItem("Add");
        addBuddyInfo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.addBuddy();
                    }
                }
        );
        
        editBuddyInfo = new JMenuItem("Edit");
        editBuddyInfo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.editBuddy(view.getSelectedIndex());
                    }
                }
        );
        
        removeBuddyInfo = new JMenuItem("Remove");
        removeBuddyInfo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.removeBuddy(view.getSelectedIndex());
                    }
                }
        );
        
        //Add the menus
        addressBookMenu.add(createAddressBook);
        addressBookMenu.add(saveAddressBook);
        
        //Disable unusable menuItems on startup
        disableMenuItems();
        
        buddyInfoMenu.add(addBuddyInfo);
        buddyInfoMenu.add(editBuddyInfo);
        buddyInfoMenu.add(removeBuddyInfo);
        
    
        
        //Add all the components to the contentPane
        this.getContentPane().add(menuBar, BorderLayout.NORTH);
        this.getContentPane().add(view, BorderLayout.CENTER);
        
        //Pack the frame and its components and set it visible
        this.pack();
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setSize(500, 300);
        this.setVisible(true);
	}
	
	public void subscribeTo(AddressBookModel model) {
		view = new JList(model);
	}
	/**
	 * Enable all menu items
	 */
	public void enableMenuItems() {
		saveAddressBook.setEnabled(true);
        removeBuddyInfo.setEnabled(true);
        editBuddyInfo.setEnabled(true);
	}
	
	/**
	 * Disable unusable menu items
	 */
	public void disableMenuItems() {
		saveAddressBook.setEnabled(false);
        removeBuddyInfo.setEnabled(false);
        editBuddyInfo.setEnabled(false);
	}
	
}
