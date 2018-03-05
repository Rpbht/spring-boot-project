package com.rahul.bank.rahulsavingbankgateway.filters;

import org.apache.http.HttpHeaders;
import org.apache.tomcat.util.codec.binary.Base64;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class RequestFIlter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		System.out.println("run");
		RequestContext ctx = RequestContext.getCurrentContext();
		String auth = "rpbht" + ":" + "rpbht123";
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
		String authValue = "Basic " + new String(encodedAuth);
		ctx.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, authValue);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		System.out.println("shouldFilter");
		return true;
	}

	@Override
	public int filterOrder() {
		System.out.println("filterOrder");
		return 1;
	}

	@Override
	public String filterType() {
		System.out.println("filterOrder");
		return "pre";
	}

}
