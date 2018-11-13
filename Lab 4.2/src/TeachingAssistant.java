/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.2
 */
import java.util.Date;

public class TeachingAssistant implements CourseListener {
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
	 * Prompts the TA to proctor
	 * @param e the event created by the prof
	 */
	public void midtermAnnounced(CourseEvent e) {
		Prof prof = (Prof) e.getSource();
		proctor(prof.getMidterm());
		
	}

	@Override
	/**
	 * Prompts the TA to postpone
	 * @param e the event created by the prof
	 */
	public void midtermPostponed(CourseEvent e) {
		Prof prof = (Prof) e.getSource();
		postpone(prof.getMidterm());
		
	}
}
