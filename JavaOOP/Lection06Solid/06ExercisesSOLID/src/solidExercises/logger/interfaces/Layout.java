/**
 * @author dimitar
 *
 */
package solidExercises.logger.interfaces;

import solidExercises.logger.enums.ReportLevel;

public interface Layout {

	String format(String time, String message, ReportLevel reportLevel);
	
}
