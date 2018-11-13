/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.2
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {
	private String name; //the name of the student
	private Date midterm; //the date of the midterm

	/**
	 * 
	 * @param aName the name of the student
	 */
	public Student(String aName) {
		this.name = aName;
	}

	/**
	 * @return the name of the student
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param date the date of the midterm
	 */
	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	/**
	 * @param date the date of the midterm
	 */
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	
	@Override
	/**
	 * @param o the Observable object, the prof
	 * @param arg the date object
	 */
	public void update(Observable o, Object arg) {
		//Cast arg as a date object
		Date date = (Date) arg;
		//If midterm is not set or is greater than new midterm date, study
		if (midterm == null || midterm.getTime() > date.getTime())
			study((Date) arg);
		//Otherwise, party
		else
			party((Date) arg);
		
	}
}
