package me.quantumti.domain.security;

import me.quantumti.common.BaseDomain;

/**
 * 用户角色表
 * 
 * @author july
 *
 */
public class SystemUserRole extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6872945593501610369L;

	private int user_id;
	private int role_id;

	public SystemUserRole() {
	}

	public SystemUserRole(int user_id, int role_id) {
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

}
