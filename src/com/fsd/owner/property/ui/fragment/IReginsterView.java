package com.fsd.owner.property.ui.fragment;

public interface IReginsterView {
	/**设置用户选择的信息**/
	void setUserInfo(String []userinfo);
	/**获取用户输入的手机号**/
	String getUserPhoneNum();
	/**获取用户输入的验证码**/
	String getCheckNum();
	/**验证成功**/
	void CheckSuccess();
}
