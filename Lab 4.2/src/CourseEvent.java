/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.2
 */
import java.util.Date;
import java.util.EventObject;

public class CourseEvent extends EventObject {

	//The midterm date
	private Date midtermDate;
	
	/**
	 * @param arg the date to be passed
	 */
	public CourseEvent(Object arg) {
		super(arg);
		Prof prof = (Prof) getSource();
		midtermDate = prof.getMidterm();
	}

}
