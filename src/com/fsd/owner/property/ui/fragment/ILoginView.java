package com.fsd.owner.property.ui.fragment;

import com.fsd.owner.property.model.bean.LoginUserInfo;

public interface ILoginView {
	/**获取用户的登录编号**/
	String getUserName();
	/**获取用户的登录的密码**/
	String getUserPwd();
	/**登录成功的的操作**/
	void onLoginSuccess(LoginUserInfo loginUserInfo);

}
