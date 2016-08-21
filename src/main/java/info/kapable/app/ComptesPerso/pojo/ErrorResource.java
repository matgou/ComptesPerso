package info.kapable.app.ComptesPerso.pojo;

import javax.persistence.Entity;

public class ErrorResource extends Pojo {

	private Object code;
	private String message;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ErrorResource(String code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

	/**
	 * @return the code
	 */
	public Object getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Object code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
