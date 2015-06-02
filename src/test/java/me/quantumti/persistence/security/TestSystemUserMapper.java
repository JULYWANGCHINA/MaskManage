package me.quantumti.persistence.security;

import java.util.ArrayList;
import java.util.List;

import me.quantumti.domain.security.Role;
import me.quantumti.domain.security.SystemUser;
import me.quantumti.service.security.SystemUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext*.xml")
public class TestSystemUserMapper {
	@Autowired
	private SystemUserService systemUserService;

	@Autowired
	private SaltSource saltSource;

	@Test
	public void add() {
		SystemUser u = new SystemUser();
		u.setEmail("admin@admin.com");
		// String encodedPass = new PlaintextPasswordEncoder().encodePassword(
		// "111111", saltSource.getSalt(u));
		u.setPassword("admin");
		u.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.ROLE_ADMIN);
		roles.add(Role.ROLE_USER);
		u.setRoles(roles);
//		systemUserService.add(u);
	}

}
