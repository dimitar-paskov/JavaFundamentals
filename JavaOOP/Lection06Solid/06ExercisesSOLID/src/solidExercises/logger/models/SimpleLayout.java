/**
 * @author dimitar
 *
 */
package solidExercises.logger.models;

import solidExercises.logger.enums.ReportLevel;
import solidExercises.logger.interfaces.Layout;

public class SimpleLayout implements Layout{

	@Override
	public String format(String time, String message, ReportLevel reportLevel) {
		
		return String.format("<%s> - <%s> - <%s>", time, reportLevel.toString(), message);
	}

	
	
	
}
