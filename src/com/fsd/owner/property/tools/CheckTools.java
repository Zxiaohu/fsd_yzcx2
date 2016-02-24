package com.fsd.owner.property.tools;

import android.text.TextUtils;

/***
 * CheckTools
 * @author zxh
 * 验证工具类
 */
public class CheckTools {

	/**验证非空**/
	public static boolean isEmpty(String[]strArr){
		for (int i = 0; i < strArr.length; i++) {
			if(TextUtils.isEmpty(strArr[i])){
				return true;
			}
		}
		return false;
	}
}
