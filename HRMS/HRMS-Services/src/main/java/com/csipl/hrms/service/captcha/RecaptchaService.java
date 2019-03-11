package com.csipl.hrms.service.captcha;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.captcha.util.RecaptchaUtil;


@Service
public class RecaptchaService {

	@Value("${google.recaptcha.secret}") String recaptchaSecret;
	private static final String GOOGLE_RECAPTCHA_VERIFY_URL =
			"https://www.google.com/recaptcha/api/siteverify";
	@Autowired RestTemplateBuilder restTemplateBuilder;
	
	public String verifyRecaptcha(String ip, String recaptchaResponse){
		System.out.println("Inside verifyRecaptcha------");
		Map<String, String> body = new HashMap<>();
		body.put("secret", recaptchaSecret);
		body.put("response", recaptchaResponse);
		body.put("remoteip", ip);
		//log.debug("Request body for recaptcha: {}", body);
		ResponseEntity<Map> recaptchaResponseEntity = 
				restTemplateBuilder.build()
				.postForEntity(GOOGLE_RECAPTCHA_VERIFY_URL+
						"?secret={secret}&response={response}&remoteip={remoteip}", 
						body, Map.class, body);
		//log.debug("Response from recaptcha: {}", recaptchaResponseEntity);
		Map<String, Object> responseBody = recaptchaResponseEntity.getBody();
		boolean recaptchaSucess = (Boolean)responseBody.get("success");
		if ( !recaptchaSucess) {
			List<String> errorCodes = (List)responseBody.get("error-codes");
			String errorMessage = errorCodes.stream()
					.map(s -> RecaptchaUtil.RECAPTCHA_ERROR_CODE.get(s))
					.collect(Collectors.joining(", "));
			System.out.println("--------Error--------");
			return errorMessage;
		}else {
			System.out.println("--------StringUtils.EMPTY--------");
			return StringUtils.EMPTY;
		}
	}
}