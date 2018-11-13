/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.2
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class Prof extends Observable {
	private String name; //the name of the prof
	private Date midtermDate; //the date of the midterm

	/**
	 * @param aName the name of the prof
	 */
	public Prof(String aName) {
		this.name = aName;
	}

	/**
	 * @return the date of the midterm
	 */
	public Date getMidterm() {
		return this.midtermDate;
	}

	/**
	 * @return the name of the prof
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param date the date the midterm is set to
	 */
	public void setMidterm(Date date) {
		//Set midterm date and notify students and TAs
		this.midtermDate = date;
		setChanged();
		notifyObservers(date);
	}
	
	/**
	 * @param date the date the midterm is postponed to
	 */
	public void postponeMidterm(Date date){
		//Set midterm date and notify students and TAs
		this.midtermDate = date;
		setChanged();
		notifyObservers(date);
	}

	public static void main(String[] args) {

		///Create prof, students and TAs
		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		//Add the observers
		p.addObserver(s);
		p.addObserver(s2);
		p.addObserver(ta);
	
		//Set the midterm date
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		//Postpone the midterm
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
