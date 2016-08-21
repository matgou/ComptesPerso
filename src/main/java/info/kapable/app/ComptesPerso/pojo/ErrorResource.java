package info.kapable.app.ComptesPerso.pojo;

import java.util.List;
import java.util.Map;

public class ErrorResource extends Pojo {

	private Object code;
	private String message;
	private Map<String, List<String>> constraintList;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ErrorResource(String code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

	public ErrorResource(String code, String message, Map<String, List<String>> constraintList) {
		this.setConstraintList(constraintList);
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

	/**
	 * @return the constraintList
	 */
	public Map<String, List<String>> getConstraintList() {
		return constraintList;
	}

	/**
	 * @param constraintList the constraintList to set
	 */
	public void setConstraintList(Map<String, List<String>> constraintList) {
		this.constraintList = constraintList;
	}

}
