package globant.javabootcamp.finalproject.Exceptions;

/**
 * 
 * Exception thrown when a category is not valid
 *
 */
public class InvalidCategoryException extends Exception{

	/**
	 *  Serialized because the inheritance of a serialized class
	 */
	private static final long serialVersionUID = 7936573110813101809L;
	
	public InvalidCategoryException(){
		super("Invalid Category");
	}
}
