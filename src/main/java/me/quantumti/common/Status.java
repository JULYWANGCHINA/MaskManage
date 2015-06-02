package me.quantumti.common;

import java.io.Serializable;

/**
 * 状态实体类
 * 
 * @author july
 * 
 */
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8500170062514383188L;

	public static final String CODE_SUCCESS = "0000", CODE_ERROR = "0001";

	private String code;
	private String message;
	
	public Status(int count, String message){
		if (count == 0) {
			this.code = "0001";
		} else {
			this.code = "0000";
		}
		this.message = message;
	}

	
	public Status(String message){
		this.code = "0001";
		this.message = message;
	}
	
	public Status() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
