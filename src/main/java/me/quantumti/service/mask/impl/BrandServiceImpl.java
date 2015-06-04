package me.quantumti.service.mask.impl;

import me.quantumti.domain.mask.Brand;
import me.quantumti.persistence.mask.BrandMapper;
import me.quantumti.service.mask.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandMapper brandMapper;

	@Override
	public int add(Brand brand) {
		return brandMapper.add(brand);
	}

}
