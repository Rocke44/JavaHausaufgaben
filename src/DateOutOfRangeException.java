
public class DateOutOfRangeException extends RuntimeException {
	public DateOutOfRangeException(){
		super("The Year is out of the range of 1800-2100.");
	}
	
	public DateOutOfRangeException(String message){
		super(message);
	}
	
}
