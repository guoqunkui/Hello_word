package com.jiuqi.np.testMethod;

import java.io.IOException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class testGetCookie {
	
		public static String getJSESSIONID() {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost get = new HttpPost("http://10.2.7.154:8081/server/loginStrategy/meta/getLoginOption");
		CloseableHttpResponse response=null;
		try {
			response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// System.out.println(result);
//			Header[] header=response.getHeaders("Set-Cookie");
//			for(Header cookie:header) {
//				System.out.println(cookie.getValue());
//			}
		Header header = response.getFirstHeader("Set-Cookie");
		String str=header.getValue();
		String[] str1=str.split(";");
		return str1[0];
		
	
		}
}
