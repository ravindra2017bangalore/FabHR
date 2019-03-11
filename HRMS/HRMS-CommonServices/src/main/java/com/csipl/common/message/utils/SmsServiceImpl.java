package com.csipl.common.message.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.csipl.common.model.Notification;

@Service("smsService")
public class SmsServiceImpl implements SmsService {

	public static final String baseurl = "http://apivm.valuemobo.com/SMS/SMS_ApiKey.asmx/SMS_APIKeyNUC?";
	public static final String apikey = "rvRHvT8LG6U9h1B";
	public static final String msgtext = "";
	public static final String senderid = "CSIPLI";

	public static String getUrlData(String url_val) {

		String websiteData = null;

		try {
			// System.setProperty("java.net.useSystemProxies", "true");
			// Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.5",
			// 8888));
			// java.net.Proxy proxy = new java.net.Proxy(Type.HTTP, new
			// InetSocketAddress("192.168.1.5", 8888));
			URL url = new URL(url_val);

			URLConnection connection = url.openConnection();
			connection.connect();
			InputStream inputstream = connection.getInputStream();
			websiteData = generateString(inputstream);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return websiteData;
	}

	public static String generateString(InputStream stream) {

		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader buffer = new BufferedReader(reader);
		StringBuilder sb = new StringBuilder();
		try {
			String cur;
			while ((cur = buffer.readLine()) != null) {
				sb.append(cur + "\n");
			}

		} catch (Exception e) {
		}
		return sb.toString();
	}

	@Override
	public String sendNotificationBySms(Notification notification, String mobileNumber) {
		String url = null;
		String stst = null;

		System.out.println("======Mobile No.======" + mobileNumber);

		try {

			url = baseurl + "&apiKey=" + URLEncoder.encode(apikey, "UTF-8") + "&cellNoList="
					+ URLEncoder.encode(mobileNumber, "UTF-8") + "&msgtext="
					+ URLEncoder.encode(notification.getNotificationText(), "UTF-8") + "&senderid="
					+ URLEncoder.encode(senderid, "UTF-8");
			System.out.println("=======url=" + url);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		stst = getUrlData(url);

		return stst;

	}
}
