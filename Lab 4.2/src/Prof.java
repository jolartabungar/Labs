/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.2
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prof {
	private String name; // the name of the prof
	private Date midtermDate; // the midterm date
	private List<CourseListener> courseListeners; // the list of students and TAs

	/**
	 * @param aName the name of the prof
	 */
	public Prof(String aName) {
		this.name = aName;
		courseListeners = new ArrayList<CourseListener>();
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
	 * @param date the date of the midterm to be set
	 */
	public void setMidterm(Date date) {
		this.midtermDate = date;
		//The prof creates the event and sends it
		CourseEvent e = new CourseEvent(this);
		for (CourseListener cl: courseListeners) {
			cl.midtermAnnounced(e);
		}

	}
	
	/**
	 * @param date the date of the midterm to be postponed
	 */
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		//the prof creates the event and sends it
		CourseEvent e = new CourseEvent(this);
		for (CourseListener cl: courseListeners) {
			cl.midtermPostponed(e);
		}

	}
	
	/**
	 * @param cl CourseListener to be added
	 */
	public synchronized void addCourseListener (CourseListener cl){
		courseListeners.add(cl);
	}

	/**
	 * @param cl CourseListener to be removed
	 */
	public synchronized void removeCourseListener (CourseListener cl) {
		courseListeners.remove(cl);
	}


	public static void main(String[] args) {

		//Create the prof, students and TA
		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
	
		//Add the students and TA as CourseListeners
		p.addCourseListener(s);
		p.addCourseListener(s2);
		p.addCourseListener(ta);
	
		//Set Midterm
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		//Postpone Midterm
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}