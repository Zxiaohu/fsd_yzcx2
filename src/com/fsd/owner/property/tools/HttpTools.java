package com.fsd.owner.property.tools;

import com.fsd.owner.property.global.HttpParam;
import com.lidroid.xutils.http.RequestParams;

/***
 * HttpTools
 * @author zxh
 * 网络请求工具
 * 2016年1月29日14:29:44
 */
public class HttpTools {

	//private static RequestParams params;

	/**根据两个数组动态的生成请求参数**/
	
	/**
	 * @param key 请求的key
	 * @param value 具体的值
	 * @return
	 */
	public static RequestParams getParam(HttpParam key,String value){
		RequestParams params = new RequestParams();
		params.addBodyParameter(key.getName(),value);
		return params;
	}
	
	
	public static RequestParams getParam(HttpParam []keys,String[] values){
		RequestParams params = new RequestParams();
		for (int i = 0; i < keys.length; i++) {
			params.addBodyParameter(keys[i].getName(),values[i]);
		}
		return params;
	}
	
	/****
	 * 
	 * @param keys 
	 * @param values
	 * @return
	 */
	public static RequestParams getParam(String []keys,String []values){
		RequestParams params = new RequestParams();
		for (int i = 0; i < values.length; i++) {
			params.addBodyParameter(keys[i],values[i]);
		}
		return params;
	}

	public static RequestParams getParam(String key,String value){
		RequestParams params = new RequestParams();
			params.addBodyParameter(key,value);
		return params;
	}
}
