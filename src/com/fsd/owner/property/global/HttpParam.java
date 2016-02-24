package com.fsd.owner.property.global;

/****
 * HttpParam
 * @author zxh
 * 网络请求的参数
 */
public enum HttpParam {
	/**配置类型**/
	CONFIGTYPE("configtype"),
	/**主服务的id**/
	UPID("upid"),
	/**管理处id**/
	PrecinctID("PrecinctID"),
	/**大楼处id**/
	BuildingID("BuildingID"),
	/**单元处id**/
	FloorID("FloorID"),
	/***房间id**/
	RoomID("RoomID"),
	/**手机号**/
	UNAME("uname"),
	/**验证登录的密码**/
	UPWD_LOGIN("upwd"),
	/**昵称**/
	NICKNAME("nickname"),
	/**积分**/
	SCORE("score"),
	/**头像**/
	PHOTO("photo"),
	/**地址**/
	ADDRESS("address"),
	/**房间id**/
	HOUSE_ID("houseid"),
	/**房间的名字**/
	HOUSE_NAME("housename"),
	/***密码**/
	PASSWORD("password"),
	/**旧密码**/
	OLDPASSWORD("oldpassword"),
	/**详情**/
	DETAILS("details"),
	/**用户的编号**/
	/***业主姓名**/
	MASTERNAME("mastername"),
	/***验证码**/
	YZM("yzm"),
	/**操作类型**/
	OPERATE("operate");
	
	private String name;
	private HttpParam(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}
