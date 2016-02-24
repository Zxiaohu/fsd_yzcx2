package com.fsd.owner.property.ui.view.roomchoose;

import com.fsd.owner.property.global.JsonParam;
import com.fsd.owner.property.model.httpdao.impl.room.FetchFloorInfo;
import com.fsd.owner.property.model.httpdao.impl.room.FetchPrecinctInfo;
import com.fsd.owner.property.model.httpdao.impl.room.FetchRoomAllInfo;
import com.fsd.owner.property.model.httpdao.impl.room.FetchRoomInfo;
import com.fsd.owner.property.model.httpdao.impl.room.FetchUnitInfo;
import com.fsd.owner.property.model.httpdao.impl.room.FetchFloorInfo.IFloorDataListener;
import com.fsd.owner.property.model.httpdao.impl.room.FetchPrecinctInfo.IPrecinctListener;
import com.fsd.owner.property.model.httpdao.impl.room.FetchRoomAllInfo.IRoomAllInfoListener;
import com.fsd.owner.property.model.httpdao.impl.room.FetchRoomInfo.IRoomListener;
import com.fsd.owner.property.model.httpdao.impl.room.FetchUnitInfo.IUnitListener;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.LogUtil;
import com.google.gson.Gson;
import android.content.Context;

public class RoomChPresenter implements IPrecinctListener, IFloorDataListener, IUnitListener, IRoomListener, IRoomAllInfoListener {

	private IRoomChView mView;
	private Context mContext;

	private FetchPrecinctInfo fetchPrecinctInfo;
	private FetchFloorInfo fetchFloorInfo;
	private FetchUnitInfo fetchUnitInfo;
	private FetchRoomInfo fetchRoomInfo;
	private FetchRoomAllInfo fetchRoomAllInfo;



	public RoomChPresenter(IRoomChView mView, Context mContext) {
		super();
		this.mView = mView;
		this.mContext = mContext;
		this.fetchPrecinctInfo = new FetchPrecinctInfo(this);
		this.fetchFloorInfo = new FetchFloorInfo(this);
		this.fetchUnitInfo = new FetchUnitInfo(this);
		this.fetchRoomInfo = new FetchRoomInfo(this);
		this.fetchRoomAllInfo = new FetchRoomAllInfo(this);
	}



	/**请求网络获取数据的操作**/
	public void fetchData(){
		/***
		 * 1.获取所有的管理处
		 * 2.获取大楼
		 * 3.获取楼层
		 * 4.获取房间
		 * */
		mView.isloading(true);
		//获取管理处的信息
		fetchPrecinctInfo.sendHttp();
	}



	@Override
	public void onRoomAllInfoSuccess(String response) {
		// TODO Auto-generated method stub
		mView.isloading(false);
		RoomInfo roomInfo= new Gson().fromJson(response,RoomInfo.class);
		//返回roominfo
		mView.onRoomComplete(roomInfo);
	}



	@Override
	public void onRoomDataSuccess(String response) {
		// TODO Auto-generated method stub
		mView.isloading(false);
		LogUtil.e("json",response);
		String []roomid=DataTools.getArr4json(response, JsonParam.RoomID);
		mView.onRoomDataSuccess(roomid, null);
	}



	@Override
	public void onUnitDataSuccess(String response) {
		// TODO Auto-generated method stub
		mView.isloading(false);
		String[][] arr24Json = DataTools.getArr24Json(response, JsonParam.FloorID,JsonParam.FloorName);
		if(arr24Json!=null){
			mView.onUnitDataSuccess(arr24Json[0], arr24Json[1]);
		}
	}



	@Override
	public void onFloorDataSuccess(String response) {
		// TODO Auto-generated method stub
		mView.isloading(false);//没有加载了 
		String[][] arr24Json = DataTools.getArr24Json(response, JsonParam.BuildingID,JsonParam.BuildingName);
		if(arr24Json!=null){
			mView.OnFloorDataSuccess(arr24Json[0], arr24Json[1]);
		}
	}

	@Override
	public void onDataSuccess(String response) {
		// TODO Auto-generated method stub
		mView.isloading(false);
		String[][] arr24Json = DataTools.getArr24Json(response,JsonParam.PrecinctID,JsonParam.PrecinctName);
		if(arr24Json!=null){
			mView.onPrecinctDataSuccess(arr24Json[0],arr24Json[1]);
		}
	}



	public void fetchFloor(String pid) {
		// TODO Auto-generated method stub

		if(!pid.equals("请选择")){
			mView.isloading(true);
			fetchFloorInfo.setPrecinctID(pid);
			fetchFloorInfo.sendHttp();
		}
	}



	public void fetchUnits() {
		// TODO Auto-generated method stub
		String precinctID = mView.getPrecinctID();
		String floorID = mView.getFloorID();
		if(!floorID.equals("请选择")){
			mView.isloading(true);
			fetchUnitInfo.setPidFid(precinctID,floorID);
			fetchUnitInfo.sendHttp();
		} 

	}



	public void fetchRoomInfo() {
		// TODO Auto-generated method stub
		String precinctID = mView.getPrecinctID();
		String floorID = mView.getFloorID();
		String unitID = mView.getUnitID();
		if(!unitID.equals("请选择")){
			mView.isloading(true);
			fetchRoomInfo.setPidFidUid(precinctID,floorID,unitID);
			fetchRoomInfo.sendHttp();
		}
	}


	
	public void getHouseInfo() {
		// TODO Auto-generated method stub
		String precinctID = mView.getPrecinctID();
		String floorID = mView.getFloorID();
		String unitID = mView.getUnitID();
		String roomID = mView.getRoomID();
		if(!roomID.equals("请选择")){
			mView.isloading(true);
			fetchRoomAllInfo.setPidFidUidRid(precinctID, floorID, unitID, roomID);
			fetchRoomAllInfo.sendHttp();
		}
	}
	
}
