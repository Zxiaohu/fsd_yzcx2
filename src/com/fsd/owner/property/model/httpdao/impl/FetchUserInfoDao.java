package com.fsd.owner.property.model.httpdao.impl;

import com.fsd.owner.property.global.HttpParam;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.httpdao.SFetchInfoDao;
import com.fsd.owner.property.tools.HttpTools;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
/**
 * FetchInfo
 * @author zxh
 * 从服务器获取
 */
public class FetchUserInfoDao extends SFetchInfoDao {

	/**网络请求监听**/
	private FetchListener listener;
	private String uname;//用户的手机号码
	
	/**设置手机号**/
	public void setUname(String uname){
		this.uname =uname;
	}
	
	/**设置请求监听**/
	public void setFetchListener(FetchListener listener){
		this.listener = listener;
	}
	
	@Override
	public RequestParams setRequestParams() {
		// TODO Auto-generated method stub
		return HttpTools.getParam(HttpParam.UNAME, uname);
	}

	@Override
	public String setRequestUrl() {
		// TODO Auto-generated method stub
		return MyHttpUrl.USER_INFO;
	}
		
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	@Override
	public void onLoading(long total, long current, boolean isUploading) {
		// TODO Auto-generated method stub
		super.onLoading(total, current, isUploading);
	}
	
	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		super.onSuccess(arg0);
		// TODO Auto-generated method stub
		/**用户的信息数据准备成功***/
		listener.onUserInfoReadly(arg0.result.toString());
	}
	
	@Override
	public void onFailure(HttpException arg0, String arg1) {
		// TODO Auto-generated method stub
		super.onFailure(arg0, arg1);
		//获取用户信息失败
	}
	
	/**获取用户信息时的监听**/
	public interface FetchListener{
		void onUserInfoReadly(String userinfo);
	}
}
