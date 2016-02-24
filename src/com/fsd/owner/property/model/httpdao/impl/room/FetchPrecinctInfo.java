package com.fsd.owner.property.model.httpdao.impl.room;

import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.httpdao.SFetchInfoDao;
import com.fsd.owner.property.tools.DataTools;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
/****
 * @author zxh
 * 获取管理处信息的
 * 2016年2月1日13:49:16
 */
public class FetchPrecinctInfo extends SFetchInfoDao {

	private IPrecinctListener listener;
	
	public FetchPrecinctInfo(IPrecinctListener listener) {
		// TODO Auto-generated constructor stub
		this.listener=listener;
	}
	@Override
	public RequestParams setRequestParams() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String setRequestUrl() {
		// TODO Auto-generated method stub
		return MyHttpUrl.PRECINCT;
	}
	
	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		//super.onSuccess(arg0);
		listener.onDataSuccess(arg0.result.toString());
	}
	
	public interface IPrecinctListener{
		/****这个json已经去掉中括号啦***/
		void onDataSuccess(String response);
	}
	
}
