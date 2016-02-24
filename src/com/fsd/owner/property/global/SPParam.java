package com.fsd.owner.property.global;

/**
 * SPParam
 * @author zxh
 * 存在缓存中的key的名字
 */
public enum SPParam {
	/**用户的手机号**/
	PhoneNum("PhoneNum"),
	/**验证码**/
	YZM("YZM"),
	/**用户信息**/
	UserInfo("userinfo"), TaskListInfo("TaskListInfo"), PROGRESS("PROGRESS");
	private String name;
	private SPParam(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}
