package com.csipl.hrms.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.common.State;
import com.csipl.hrms.service.organization.repository.StateRepository;

@Service("stateService")
@CacheConfig(cacheNames = "hrmsDBCache")
public class StateServiceImpl implements StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public List<State> findAllState() {
		return stateRepository.findAllState();
	}

	
}
