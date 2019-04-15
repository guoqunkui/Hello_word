package com.jiuqi.np.testMethod;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
import com.jiuqi.np.testClass.User;

public class testLogin {
	public static void getResponse(){

		CloseableHttpClient client = HttpClients.createDefault();
		// testGetCookie.getJSESSIONID();
		String url = "http://10.2.7.154:8081/server/api/login";
		HttpPost post = new HttpPost(url);
		post.addHeader("Cookie", testGetCookie.getJSESSIONID());
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new User("username", "XJGLY"));
		list.add(new User("password", "123"));

		// 把参数转化为实体类型
		String result = null;

		try {
			UrlEncodedFormEntity urlentity = new UrlEncodedFormEntity(list, "UTF-8");
			post.setEntity(urlentity);
			CloseableHttpResponse response = client.execute(post);

			HttpEntity entity1 = response.getEntity();
			result = EntityUtils.toString(entity1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//JSONObject json = JSONObject.parseObject(result);
		System.out.println(result);
	}
}
