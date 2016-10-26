
public class InvalidDateException extends RuntimeException {
	public InvalidDateException(){
		super("This is not a valid date.");
	}
	
	public InvalidDateException(String message){
		super(message);
	}
}
