package me.quantumti.security;

import me.quantumti.domain.security.SystemUser;
import me.quantumti.service.security.SystemUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceUtil implements UserDetailsService {

	protected MessageSourceAccessor messages = SpringSecurityMessageSource
			.getAccessor();

	@Autowired
	private SystemUserService systemUserService;

	@Override
	public SystemUser loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		return systemUserService.getByName(username);
	}
}
