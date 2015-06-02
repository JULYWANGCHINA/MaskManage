package me.quantumti.domain.security;

public enum Role {
	ROLE_USER(1), // 普通用户
	ROLE_ADMIN(2);// 系统管理员

	private int value;

	Role(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public static Role getRolesByBit(int bit) {
		Role role = null;
		switch (bit) {
		case 1:
			role = Role.ROLE_USER;
			break;
		case 2:
			role = Role.ROLE_ADMIN;
			break;
		}
		return role;
	}

}
