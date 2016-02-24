package com.fsd.owner.property.ui.view.roomchoose;

import com.fsd.owner.property.ui.view.roomchoose.RoomInfo;

public interface IRoomChView {
	
	/***请求管理处完成的操作***/
	void onPrecinctDataSuccess(String []precinctid,String []precinctnames);
	/***请求大楼完成的操作***/
	void OnFloorDataSuccess(String [] floorsid,String [] floorsname);
	/***请求楼层处完成的操作***/
	void onUnitDataSuccess(String [] unitsid,String [] unitsname);
	/***请求房间号处完成的操作***/
	void onRoomDataSuccess(String [] roomsid,String [] roomsname);
	/****请求完成的操作****/
	void onRoomComplete(RoomInfo roomInfo);
	/**获取选择管理处ID**/
	String getPrecinctID();
	/**获取大楼的ID**/
	String getFloorID();
	/**获取大楼单元ID**/
	String getUnitID();
	/**获取房间的ID***/
	String getRoomID();
	/**监控是否在加载**/
	void isloading(boolean isloading);
}
