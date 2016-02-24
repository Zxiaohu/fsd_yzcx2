package com.fsd.owner.property.ui.fragment;

import com.fsd.owner.property.model.bean.UserInfo;


public interface IUserCenterView {

	/**用户登录的操作
	 * @param userinfo_obj **/
	void onUserLogin(UserInfo userinfo_obj);
	/**用户没有登录的操作**/
	void onUserNotLogin();

	
}
