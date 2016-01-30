package day08.ext;
/**
 * 用户已存在异常
 * @author teacher
 *
 */
public class UserExistException extends Exception {

	public UserExistException(){
	}
	public UserExistException(String message){
		super(message);
	}
	public UserExistException(Throwable cause){
		super(cause);
	}
	public UserExistException(String message, Throwable cause){
		super(message, cause);
	}
}
