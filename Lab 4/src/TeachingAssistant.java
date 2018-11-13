/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.2
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class TeachingAssistant implements Observer {
	private String name; //the name of the TA
	private Date midterm; //the date of the midterm

	/**
	 * @param aName the name of the TA
	 */
	public TeachingAssistant(String aName) {
		this.name = aName;
	}

	/**
	 * @return the name of the TA
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param date the date of the midterm
	 */
	public void proctor(Date date){
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	/**
	 * @param date the date of the midterm
	 */
	public void postpone(Date date){
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}

	@Override
	/**
	 * @param o the observable object, the prof
	 * @param arg the date Object
	 */
	public void update(Observable o, Object arg) {
		//Cast arg as a date object
		Date date = (Date) arg;
		//If the midterm is not set or is greater than new midterm date, proctor
		if (midterm == null || midterm.getTime() > date.getTime())
			proctor((Date) arg);
		//Otherwise, postpone
		else
			postpone((Date) arg);
		
	}
}
