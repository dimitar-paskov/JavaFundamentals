/**
 * @author dimitar
 *
 */
package solidExercises.logger.models;

import solidExercises.logger.enums.ReportLevel;
import solidExercises.logger.interfaces.Layout;

public class XmlLayout implements Layout {

	@Override
	public String format(String time, String message, ReportLevel reportLevel) {

		return String.format(
		"<log>\n" + 
				"<date>%s</date>\n" +
				"<level>%s</level>\n" +
				"<message>%s</message>\n" +
		"</log>", time, reportLevel.toString(), message);
	}

}
