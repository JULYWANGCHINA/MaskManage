package me.quantumti.service.mask.impl;

import me.quantumti.domain.mask.MaskDetail;
import me.quantumti.persistence.mask.MaskDetailMapper;
import me.quantumti.service.mask.MaskDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MaskDetailServiceImpl implements MaskDetailService {
	
	@Autowired
	private MaskDetailMapper maskDetailMapper;

	@Override
	public int add(MaskDetail maskDetail) {
		return maskDetailMapper.add(maskDetail);
	}

}
