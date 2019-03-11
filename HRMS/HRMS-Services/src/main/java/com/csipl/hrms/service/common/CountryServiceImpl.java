package com.csipl.hrms.service.common;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

@Service("countryService")
@CacheConfig(cacheNames = "hrmsDBCache")
public class CountryServiceImpl {

}
