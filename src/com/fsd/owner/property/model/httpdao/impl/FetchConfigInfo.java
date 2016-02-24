package com.fsd.owner.property.model.httpdao.impl;

import com.fsd.owner.property.global.HttpParam;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.httpdao.SFetchInfoDao;
import com.fsd.owner.property.tools.HttpTools;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;

/****
 * FetchConfigInfo
 * @author zxh
 * 	主服务项 传 configtype="service"  
	子服务项 传 configtype=“subservice“ upid=（service01  日常报修  service02  有偿服务   service03  投诉与建议 ）
	小区联系方式 传configtype=“telephone” 

 */
public class FetchConfigInfo extends SFetchInfoDao{
	
	/***
	 * 
	 * @param confingtype 配置的类型
	 */
	public void setServiceId(String confingtype,String id){
		//生成请求配置项的参数
		commParams=HttpTools.getParam(new HttpParam[]{HttpParam.CONFIGTYPE,HttpParam.UPID},new String[]{confingtype,id});
	}
	
	@Override
	public RequestParams setRequestParams() {
		// TODO Auto-generated method stub
		return commParams;
	}

	@Override
	public String setRequestUrl() {
		// TODO Auto-generated method stub
		return MyHttpUrl.CONFIG;
	}
	
	
	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		super.onSuccess(arg0);
		
	}
	@Override
	public void onFailure(HttpException arg0, String arg1) {
		// TODO Auto-generated method stub
		super.onFailure(arg0, arg1);
		
	}
}
