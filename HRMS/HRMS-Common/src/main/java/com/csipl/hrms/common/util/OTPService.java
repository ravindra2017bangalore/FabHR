package com.csipl.hrms.common.util;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class OTPService {

	private static final Logger logger = LoggerFactory.getLogger(OTPService.class);
	// cache based on username and OPT MAX 8
	private static final Integer EXPIRE_MINS = 2;
	private LoadingCache<String, Integer> otpCache;
	private static final Random generator = new Random();

	public OTPService() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});

	}

	/*
	 * This method is used to push the opt number against Key. Rewrite the OTP if it
	 * exists Using user id as key
	 */
	public Integer generateOtp(String key) {
		int otp = 100000 + generator.nextInt(900000);
		String cacheKey = key.toUpperCase();
		otpCache.put(cacheKey, otp);
		return otp;
	}

	/*
	 * This method is used to return the OPT number against Key->Key values is
	 * username
	 */
	public int getOtp(String key) {
		try {
			String cacheKey = key.toUpperCase();
			ConcurrentMap<String, Integer> laodCache = otpCache.asMap();
			
			for (Map.Entry<String, Integer> entry : laodCache.entrySet()) {
				String cache = entry.getKey().toString();
				Integer value = entry.getValue();
				logger.info("key: " + cache + " value: " + value);
			}

			return otpCache.get(cacheKey);
		} catch (Exception e) {
			return 0;
		}
	}

	/* This method is used to clear the OTP catched already */
	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}
}
