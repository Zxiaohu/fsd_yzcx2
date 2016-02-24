package com.fsd.owner.property.model.httpdao.impl;

import com.fsd.owner.property.global.HttpParam;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.httpdao.SFetchInfoDao;
import com.fsd.owner.property.tools.HttpTools;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;

public class RegsiterDao extends SFetchInfoDao {

	private RegsiterDaoListener listener;
	
	public RegsiterDao(RegsiterDaoListener listener) {
		super();
		this.listener = listener;
	}

	public RegsiterDao setUnameYzm(String uname,String yzm){
		commParams=HttpTools.getParam(
				new HttpParam[]{HttpParam.UNAME,HttpParam.YZM},
				new String[]{uname,yzm});
		return this;
	}
	
	@Override
	public RequestParams setRequestParams() {
		// TODO Auto-generated method stub
		return commParams;
	}
	
	@Override
	public String setRequestUrl() {
		// TODO Auto-generated method stub
		return MyHttpUrl.SEND_MSG;
	}
	
	public interface RegsiterDaoListener{
		/**短信验证完毕返回的数据**/
		void onSmsCheckReadly(String respone);
	}
	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		
		listener.onSmsCheckReadly(arg0.result.toString());
	}
}
