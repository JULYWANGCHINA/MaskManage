package me.quantumti.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author SP
 * email发送实体类
 *
 */
public class EmailSend implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 5299111662583078371L;	
	
	public static final Integer SEND_SUCCESS=1,SNED_ERROR=2;

	private String id;
	
	private String emailUrl;
	
	private Date createTime;
	
	private String subject;

	private String content;
	
	private Integer pushState;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailUrl() {
		return emailUrl;
	}

	public void setEmailUrl(String emailUrl) {
		this.emailUrl = emailUrl;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPushState() {
		return pushState;
	}

	public void setPushState(Integer pushState) {
		this.pushState = pushState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}




}
