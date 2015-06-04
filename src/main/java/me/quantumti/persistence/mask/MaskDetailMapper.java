package me.quantumti.persistence.mask;

import me.quantumti.domain.mask.MaskDetail;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface MaskDetailMapper {
	
	String ADD = "INSERT INTO mask_details(create_time, maskName, effect, barCode, maskMin, maskTime, maskMax, address, brand_id)"
			+ "VALUES(NOW(), #{M.maskName}, #{M.effect}, #{M.barCode}, #{M.maskMin}, #{M.maskTime}, #{M.maskMax}, #{M.address}, #{M.brand.id})";
	@Insert(ADD)
	@Options(useGeneratedKeys = true, keyProperty = "M.id")
	int add(@Param("M") MaskDetail maskDetail);
}
