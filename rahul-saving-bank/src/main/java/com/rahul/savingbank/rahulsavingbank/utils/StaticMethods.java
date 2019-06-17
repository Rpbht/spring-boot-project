package com.rahul.savingbank.rahulsavingbank.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

public class StaticMethods {

	public static HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			private static final long serialVersionUID = -2926514742836624882L;

			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}
}
