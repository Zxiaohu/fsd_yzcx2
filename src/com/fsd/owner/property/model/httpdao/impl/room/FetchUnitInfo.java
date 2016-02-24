package com.fsd.owner.property.model.httpdao.impl.room;

import com.fsd.owner.property.global.HttpParam;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.httpdao.SFetchInfoDao;
import com.fsd.owner.property.tools.HttpTools;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
/****
 * @author zxh
 * 获取管理处信息的
 * 2016年2月1日13:49:16
 */
public class FetchUnitInfo extends SFetchInfoDao {
	private IUnitListener listener;
	
	public FetchUnitInfo(IUnitListener listener){
		this.listener=listener;
	}
	
	public void setPidFid(String pid,String fid){
		commParams = HttpTools.getParam(
				new HttpParam[]{HttpParam.PrecinctID,HttpParam.BuildingID},
				new String[]{pid,fid});
	}
	@Override
	public RequestParams setRequestParams() {
		// TODO Auto-generated method stub
		return commParams;
	}

	@Override
	public String setRequestUrl() {
		// TODO Auto-generated method stub
		return MyHttpUrl.FLOOR;
	}
	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		listener.onUnitDataSuccess(arg0.result.toString());
	}
	public interface IUnitListener{
		void onUnitDataSuccess(String response);
	}
}
