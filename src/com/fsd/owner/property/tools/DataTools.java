package com.fsd.owner.property.tools;

import java.util.Random;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fsd.owner.property.global.JsonParam;
import com.fsd.owner.property.global.SPParam;
import com.fsd.owner.property.model.bean.LoginUserInfo;
import com.fsd.owner.property.model.bean.TipInfo;
import com.fsd.owner.property.model.bean.UserInfo;
import com.google.gson.Gson;

public class DataTools {
	
	
	
	
	/**
	 * 根据正则表达式去
	 * @param Reg 正则表达式
	 * @param content 匹配的内容
	 * @return
	 */
	public static boolean isHaveIn(String Reg,String content){
		Pattern pattern=Pattern.compile(Reg);		
		if(pattern.matcher(content).find()){
			return true;
		};
		return false;
	}
	
	
	
	
	/***
	 * 去掉外层的中括号
	 */
	public static String getJsonObj(String str){
		return str.substring(1,str.length()-1);
	}
	/****
	 * 
	 * @param str json字符串
	 * @param class1 将被转化的类
	 * @return 被转化的对象
	 */
	@SuppressWarnings("unchecked")
	public static Object getTipInfo(String str,Class class1){
		return new Gson().fromJson(getJsonObj(str),class1);
	}
	
	/**获取用户信息对象**/
	public static UserInfo getUserInfo(){
		return (UserInfo) DataTools.getTipInfo(SharedPfTools.queryStr(SPParam.UserInfo), UserInfo.class);
	}
	
	/**将json转为2维数组**/
	public static String[][] getArr24Json(String jsonstr,JsonParam key,JsonParam name){
		LogUtil.e("json",jsonstr);
		try {
			JSONArray array = new JSONArray(jsonstr);
			int length = array.length();
			String keys[] = new String[length+1];
			String names[] = new String[length+1];
			keys[0]="请选择";
			names[0]="请选择";
			for (int i = 0; i <length; i++) {
				JSONObject object = array.getJSONObject(i);
				keys[i+1]=object.getString(key.getName());
				names[i+1]=object.getString(name.getName());
			
			}

			return new String[][]{keys,names};


		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.e("json","json解析错误");
		}
		return null;
	}

	
	public static String[] getArr4json(String jsonstr,JsonParam name){
		try {
			JSONArray array = new JSONArray(jsonstr);
			int length=array.length();
			String []arr=new String[length+1];
			arr[0]="请选择";
			for (int i = 0; i < length; i++) {
				JSONObject jsonObject=array.getJSONObject(i);
				arr[i+1]=jsonObject.getString(name.getName());
			}
			return arr;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 生成4位数的验证码
	 * @return
	 */
	public static String get4Random(){

		int max=9999;
		int min=1000;
		Random random = new Random();

		int s = random.nextInt(max)%(max-min+1) + min;

		return s+"";
	}
	
}
