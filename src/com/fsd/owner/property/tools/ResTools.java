package com.fsd.owner.property.tools;

import com.fsd.owner.property.global.MyApplication;

/****
 * ResourcesTools
 * @author zxh
 * 资源文件管理类
 */
public class ResTools {

	/**获取数组资源**/
	public static String []getArr(int nameid){
		String[] stringArrays=null;
		try{
			stringArrays = MyApplication.getContext().getResources().getStringArray(nameid);
			return stringArrays;
		}catch(Exception exception){
			SystemTools.fail("系统异常");
		}
		return stringArrays;
	}
	
	/**获取字符串资源***/
	public static String getStr(int id){return MyApplication.getContext().getString(id);}
}
