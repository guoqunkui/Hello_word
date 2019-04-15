package com.jiuqi.np.testClass;

import org.antlr.stringtemplate.language.ActionEvaluator.NameValuePair;

public class User implements org.apache.http.NameValuePair{
	private String Name;
	private String Value;
	public User(String Name, String Value) {
		super();
		this.Name = Name;
		this.Value = Value;
	}
	public String getName() {
		return this.Name;
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return this.Value;
	}
	
}
