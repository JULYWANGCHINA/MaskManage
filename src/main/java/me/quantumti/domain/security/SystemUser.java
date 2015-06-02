package me.quantumti.domain.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import me.quantumti.common.BaseDomain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SystemUser extends BaseDomain implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 180123550009464153L;

	public SystemUser() {
	}

	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	private String password;
	private List<Role> roles;
	private String name;
	private String email = "";

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		if (roles != null && roles.size() > 0) {
			for (Role role : roles) {
				if (role == null)
					continue;
				auths.add(new SimpleGrantedAuthority(role.name()));
			}
		}
		return auths;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public boolean getAdmin() {
		boolean result = false;
		for (Role role : roles) {
			if (role == Role.ROLE_ADMIN) {
				result = true;
			}
		}
		return result;
	}

}
