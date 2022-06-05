/**
 * @author dimitar
 *
 */
package solidExercises.logger.factories;

import solidExercises.logger.interfaces.Appender;
import solidExercises.logger.interfaces.Factory;
import solidExercises.logger.interfaces.Logger;
import solidExercises.logger.models.MessageLogger;

public class LoggerFactory implements Factory<Logger>{

	private AppenderFactory appenderFactory;
	
	public LoggerFactory() {
		this.appenderFactory = new AppenderFactory();
	}
	
	@Override
	public Logger produce(String produceData) {
		
		String[]  tokens =  produceData.split(System.lineSeparator());
		
		Appender[] appenders = new Appender[tokens.length];
		
		
		for (int i = 0; i < appenders.length; i++) {
			appenders[i] = this.appenderFactory.produce(tokens[i]); 
 			
		}
		
		return new MessageLogger(appenders);
	}
	

}
