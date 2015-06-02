package me.quantumti.service.security;

import java.util.List;

import me.quantumti.domain.security.SystemUser;

public interface SystemUserService {

	public abstract void add(SystemUser systemUser);

	public abstract SystemUser getByName(String name);

	public abstract SystemUser getByNameAndPassword(String name, String password);

	public abstract List<SystemUser> getSystemUsers();

}