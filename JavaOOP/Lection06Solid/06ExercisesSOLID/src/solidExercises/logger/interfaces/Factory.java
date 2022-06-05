/**
 * @author dimitar
 *
 */
package solidExercises.logger.interfaces;

public interface Factory<T> {

	T produce(String produceData);
	
}
