package me.quantumti.common;

import java.io.Serializable;
import java.util.Date;

public class BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8538872381138823470L;
	
	private int id;
	private int state;
	private Date create_time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
