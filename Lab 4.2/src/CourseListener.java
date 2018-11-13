/**
 * @author Jolar Tabungar 101030060
 * @version 2018.10.2
 */
public interface CourseListener {
	
	//Methods to be implemented by Student and TeachingAssistant
	void midtermAnnounced(CourseEvent e);
	
	void midtermPostponed(CourseEvent e);

}
