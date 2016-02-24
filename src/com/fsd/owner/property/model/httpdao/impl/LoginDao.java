package com.fsd.owner.property.model.httpdao.impl;

import com.fsd.owner.property.global.HttpParam;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.httpdao.SFetchInfoDao;
import com.fsd.owner.property.tools.HttpTools;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;

/**
 * @author xiaohu
 * 
 */
public class LoginDao extends SFetchInfoDao {

	private LoginListener lister;
	/**设置用户名和密码**/
	public void setNameAndPwd(String [] values){
		commParams = HttpTools.getParam(new HttpParam[]{HttpParam.UNAME,HttpParam.UPWD_LOGIN},values);
	}
	public void setLoginLister(LoginListener listener){
		this.lister =listener;
	}
	@Override
	public RequestParams setRequestParams() {
		// TODO Auto-generated method stub
		return commParams;
	}

	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		super.onSuccess(arg0);
		/**成功的返回监听**/
		lister.onLoginResonseReal(arg0.result.toString());
	}
	
	@Override
	public String setRequestUrl() {
		// TODO Auto-generated method stub
		return MyHttpUrl.LOGIN;
	}
	
	public interface LoginListener{
		void onLoginResonseReal(String result);
	}
}
