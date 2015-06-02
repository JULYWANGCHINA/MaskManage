package me.quantumti.service.security.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import me.quantumti.domain.security.Role;
import me.quantumti.domain.security.SystemUser;
import me.quantumti.domain.security.SystemUserRole;
import me.quantumti.persistence.security.SystemUserMapper;
import me.quantumti.persistence.security.SystemUserRoleMapper;
import me.quantumti.service.security.SystemUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SystemUserServiceImpl implements SystemUserService {
	@Autowired
	private SystemUserMapper systemUserMapper;
	@Autowired
	private SystemUserRoleMapper systemUserRoleMapper;
	@Resource
	private ShaPasswordEncoder shaPasswordEncoder;
	@Resource
	private SaltSource saltSource;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * me.quantumti.service.security.s#add(me.quantumti.domain.security.SystemUser
	 * )
	 */
	@Override
	public void add(SystemUser systemUser) {

		// String encodedPass = new PlaintextPasswordEncoder().encodePassword(
		// systemUser.getPassword(), "test");
		String encodedPass = shaPasswordEncoder.encodePassword(
				systemUser.getPassword(), saltSource.getSalt(systemUser));
		systemUser.setPassword(encodedPass);
		int count = systemUserMapper.add(systemUser);
		if (count > 0 && systemUser.getRoles() != null
				&& systemUser.getRoles().size() > 0) {
			for (Role role : systemUser.getRoles()) {
				SystemUserRole systemUserRole = new SystemUserRole(
						systemUser.getId(), role.getValue());
				systemUserRoleMapper.add(systemUserRole);
			}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see me.quantumti.service.security.s#getByName(java.lang.String)
	 */
	@Override
	public SystemUser getByName(String name) {
		SystemUser systemUser = systemUserMapper.getByName(name);
		List<Role> roles = new ArrayList<Role>();
		if (systemUser != null && systemUser.getId() != 0) {
			List<SystemUserRole> systemUserRoles = systemUserRoleMapper
					.findByUser(systemUser.getId());
			if (systemUserRoles != null && systemUserRoles.size() > 0) {
				for (SystemUserRole systemUserRole : systemUserRoles) {
					roles.add(Role.getRolesByBit(systemUserRole.getRole_id()));
				}
				systemUser.setRoles(roles);
			}
		}
		return systemUser;

	}

	@Override
	public SystemUser getByNameAndPassword(String name, String password) {
		SystemUser systemUser = systemUserMapper.getByNameAndPassword(name,
				password);
		List<Role> roles = new ArrayList<Role>();
		if (systemUser != null && systemUser.getId() != 0) {
			List<SystemUserRole> systemUserRoles = systemUserRoleMapper
					.findByUser(systemUser.getId());
			if (systemUserRoles != null && systemUserRoles.size() > 0) {
				for (SystemUserRole systemUserRole : systemUserRoles) {
					roles.add(Role.getRolesByBit(systemUserRole.getRole_id()));
				}
			}
		}
		return systemUser;
	}

	@Override
	public List<SystemUser> getSystemUsers() {
		return systemUserMapper.getUserList();
	}

}
