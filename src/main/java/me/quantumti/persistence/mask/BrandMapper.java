package me.quantumti.persistence.mask;

import me.quantumti.domain.mask.Brand;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;


public interface BrandMapper {

	String ADD = "INSERT INTO brand(create_time, brand_name)"
			+ "VALUES(NOW(), #{B.brand_name})";
	@Insert(ADD)
	@Options(useGeneratedKeys = true, keyProperty = "B.id")
	int add(@Param("B") Brand brand);
}
