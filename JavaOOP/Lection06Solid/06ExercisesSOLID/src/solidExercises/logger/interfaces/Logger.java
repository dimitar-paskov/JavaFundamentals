/**
 * @author dimitar
 *
 */
package solidExercises.logger.interfaces;

import solidExercises.logger.enums.ReportLevel;

public interface Logger {
	
	void log(String time, String message, ReportLevel reportLevel);
//	void logInfo(String time, String message);
//	void logWarning(String time, String message);
//	void logError(String time, String message);
//	void logCritical(String time, String message);
//	void logFatal(String time, String message);

}
