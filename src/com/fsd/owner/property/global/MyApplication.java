package com.fsd.owner.property.global;
import java.util.Map;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyApplication extends Application {
	
	public static Map<String, Long> map;
	private static Context context;//全局context对象

	public void onCreate() {
		super.onCreate();
		this.context= getBaseContext();
	}
	
	/**
	 * 获取全局SharedPreferences
	 * @return
	 */
	public static SharedPreferences getSharedPreferences(){
		return PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	
	/**
	 * 获取全局的context
	 * @return
	 */
	public static Context getContext(){	
		return context;
	}
}
