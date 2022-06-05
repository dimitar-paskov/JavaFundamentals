/**
 * @author dimitar
 *
 */
package solidExercises.logger.factories;

import solidExercises.logger.interfaces.Factory;
import solidExercises.logger.interfaces.Layout;
import solidExercises.logger.models.SimpleLayout;
import solidExercises.logger.models.XmlLayout;

public class LayoutFactory implements Factory<Layout>{

	@Override
	public Layout produce(String produceData) {
		
		Layout layout = null;
		
		if(produceData.equals("SimpleLayout")) {
			layout = new SimpleLayout();
			
		}else if(produceData.equals("XmlLayout")){
			layout = new XmlLayout();
		}
		

		return layout;
	}

}
