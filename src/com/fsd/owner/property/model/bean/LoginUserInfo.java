package com.fsd.owner.property.model.bean;

/***
 * 
 * @author zxh
 * 2016年2月15日10:28:15
 * 用户登录时获取的用户信息
 */
public class LoginUserInfo {
	/**标识**/
	private int flag;
	/**提示信息**/
	private String info;
	/**手机号码**/
	private String uname;
	/**用户的昵称**/
	private String nickname;
	/**用户的头像地址**/
	private String photo;
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
