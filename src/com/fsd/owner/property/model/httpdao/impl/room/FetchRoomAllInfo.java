package com.fsd.owner.property.model.httpdao.impl.room;

import com.fsd.owner.property.global.HttpParam;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.httpdao.SFetchInfoDao;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.HttpTools;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;

public class FetchRoomAllInfo extends SFetchInfoDao {

	private IRoomAllInfoListener listener;
	
	public FetchRoomAllInfo(IRoomAllInfoListener listener){
		this.listener=listener;
	}
	
	public void setPidFidUidRid(String pid,String fid,String uid,String rid){
		commParams = HttpTools.getParam(
				new HttpParam[]{HttpParam.PrecinctID,HttpParam.BuildingID,HttpParam.FloorID,HttpParam.RoomID}, 
				new String[]{pid,fid,uid,rid});
	}
	
	@Override
	public RequestParams setRequestParams() {
		// TODO Auto-generated method stub
		return commParams;
	}

	@Override
	public String setRequestUrl() {
		// TODO Auto-generated method stub
		return MyHttpUrl.ROOM_INFO;
	}
	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		super.onSuccess(arg0);
		listener.onRoomAllInfoSuccess(DataTools.getJsonObj(arg0.result.toString()));
	}
	public interface IRoomAllInfoListener{
		void onRoomAllInfoSuccess(String response);
	}
}
