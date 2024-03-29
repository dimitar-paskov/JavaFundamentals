/**
 * @author dimitar
 *
 */
package solidExercises.logger.interfaces;

import solidExercises.logger.enums.ReportLevel;

public interface Appender {
	
	void append(String time, String message, ReportLevel reportLevel);
	void setReportLevel(ReportLevel reportLevel);

}
