/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.2
 */
import java.util.Date;

public class Student implements CourseListener {
	private String name; // the name of the student
	private Date midterm; //the date of the midterm

	/**
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
	 * Prompts the student to study
	 * @param e the event created by the prof
	 */
	public void midtermAnnounced(CourseEvent e) {
		Prof prof = (Prof) e.getSource();
		study(prof.getMidterm());
		
	}

	@Override
	/**
	 * Prompts the student to party
	 * @param e the event created by the prof
	 */
	public void midtermPostponed(CourseEvent e) {
		Prof prof = (Prof) e.getSource();
		party(prof.getMidterm());
		
	}
}
