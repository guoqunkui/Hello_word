package com.jiuqi.np.testMethod;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostMethod {
	public static void main(String[] args) {
		CloseableHttpClient client=HttpClients.createDefault();
		
		String url="http://10.2.7.154:8081/server/loginStrategy/meta/getLoginOption";
		
		//String url="http://10.2.7.154:8081/server/api/login";
		HttpPost post=new HttpPost(url);
		
		String result=null;
		try {
			CloseableHttpResponse response=client.execute(post);
			
			HttpEntity entity2=response.getEntity();
			result = EntityUtils.toString(entity2,Charset.forName("GBK"));
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
		
		System.out.println(result);
	}
	
}
