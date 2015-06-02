package me.quantumti.persistence.security;

import java.util.List;

import me.quantumti.domain.security.SystemUser;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SystemUserMapper {

	String ADD = "INSERT INTO system_user(create_time, name, email, password)"
			+ "VALUES(NOW(), #{U.name}, #{U.email}, #{U.password}) ";

	@Insert(ADD)
	@Options(useGeneratedKeys = true, keyProperty = "U.id")
	int add(@Param("U") SystemUser systemUser);

	String FIND_BY_EMAIL = "SELECT * FROM system_user WHERE email=#{EMAIL}";

	@Select(FIND_BY_EMAIL)
	SystemUser getByEmail(@Param("EMAIL") String email);

	String FIND_BY_EMAIL_PASSWORD = "SELECT * FROM system_user WHERE email=#{EMAIL} and password=#{PASSWORD}";

	@Select(FIND_BY_EMAIL_PASSWORD)
	SystemUser getByEmailAndPassword(@Param("EMAIL") String email,
			@Param("PASSWORD") String password);

	String FIND_BY_NAME = "SELECT * FROM system_user WHERE name=#{NAME}";

	@Select(FIND_BY_NAME)
	SystemUser getByName(@Param("NAME") String name);

	String FIND_BY_NAME_PASSWORD = "SELECT * FROM system_user WHERE name=#{NAME} and password=#{PASSWORD}";

	@Select(FIND_BY_NAME_PASSWORD)
	SystemUser getByNameAndPassword(@Param("NAME") String name,
			@Param("PASSWORD") String password);

	String FIND_ALL = "SELECT * FROM system_user";

	@Select(FIND_ALL)
	List<SystemUser> getUserList();
}
