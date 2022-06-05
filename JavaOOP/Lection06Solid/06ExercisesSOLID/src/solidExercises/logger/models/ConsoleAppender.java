/**
 * @author dimitar
 *
 */
package solidExercises.logger.models;

import solidExercises.logger.enums.ReportLevel;
import solidExercises.logger.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

	public ConsoleAppender(Layout layout) {
		super(layout);
	}

	public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
		super(layout, reportLevel);

	}

	@Override
	public void append(String time, String message, ReportLevel reportLevel) {

		super.increaseMessagesCount();
		
		if (this.canAppend(reportLevel)) {

			String output = this.getLayout().format(time, message, reportLevel);
			System.out.println(output);
		}

	}

}
