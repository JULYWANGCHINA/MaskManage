package me.quantumti.persistence.security;

import java.util.List;

import me.quantumti.domain.security.SystemUserRole;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SystemUserRoleMapper {

	String ADD = "INSERT INTO system_user_role(create_time, user_id, role_id)"
			+ "VALUES(NOW(), #{U.user_id}, #{U.role_id}) ";

	@Insert(ADD)
	@Options(useGeneratedKeys = true, keyProperty = "U.id")
	int add(@Param("U") SystemUserRole systemUserRole);

	String FIND_BY_USER = "SELECT * FROM system_user_role WHERE user_id=#{USERID}";

	@Select(FIND_BY_USER)
	List<SystemUserRole> findByUser(@Param("USERID") int userId);

}
