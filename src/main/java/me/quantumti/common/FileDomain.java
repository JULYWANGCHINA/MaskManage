package me.quantumti.common;

import java.io.File;
import java.io.Serializable;
/**
 * 附件实体
 *
 */
public class FileDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2849630462195653105L;

	private File attachment;
	private String attachmentFileName;
	private String attachmentContentType;
	

	public File getAttachment() {
		return attachment;
	}
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
	public String getAttachmentFileName() {
		return attachmentFileName;
	}
	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}
	public String getAttachmentContentType() {
		return attachmentContentType;
	}
	public void setAttachmentContentType(String attachmentContentType) {
		this.attachmentContentType = attachmentContentType;
	}
}
