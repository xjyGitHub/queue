package util;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -258121851685217352L;

	private int state;
	private T data;
	private String message;
	
	public JsonResult(){
		
	}	
	public JsonResult(T t){
		state = 1;
		data = t;
		message="";
	}
	
	public JsonResult(Throwable e){
		state = 0;
		data = null;
		message = e.getMessage();
	}
	
	public JsonResult(int state, 
			Throwable e) {
		this.state = state;
		this.message = e.getMessage();
		this.data = null;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
		
}
