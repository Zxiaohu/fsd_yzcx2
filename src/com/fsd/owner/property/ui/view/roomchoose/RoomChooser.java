package com.fsd.owner.property.ui.view.roomchoose;

import com.fsd.owner.property.R;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.adapter.impl.RoomSpAdapter;
import com.fsd.owner.property.ui.view.roomchoose.RoomInfo;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

@SuppressWarnings("all")//消除所有的警告信息
public class RoomChooser extends LinearLayout implements IRoomChView{
	
	private View mRootView;//根布局
	//管理处
	@ViewInject(R.id.sp_precinct)
	private Spinner sp_precinct;
	//大楼
	@ViewInject(R.id.sp_floor)
	private Spinner sp_floor;
	//楼层
	@ViewInject(R.id.sp_unit)
	private Spinner sp_unit;
	//房间
	@ViewInject(R.id.sp_room)
	private Spinner sp_room;
	
	@ViewInject(R.id.ly_content)
	private LinearLayout layout;
	private RoomChPresenter presenter;
	
	
	public RoomChooser(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initView(context);
	}
	public RoomChooser(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initView(context);
	}
	
	public RoomChooser(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initView(context);
	}
	/**初始化view**/
	private void initView(Context context){
		mRootView = View.inflate(context, R.layout.room_choose,this);
		ViewUtils.inject(this,mRootView);
		presenter = new RoomChPresenter(this, context);
	}
	
	/**启动控件**/
	public void sartRequest(){
		presenter.fetchData();
	}
	
	private String pid;
	private String fid;
	private String uid;
	private String rid;
	
	@Override
	public void onPrecinctDataSuccess(final String[] precinctid,
			final String[] precinctnames) {
		// TODO Auto-generated method stub
		
		//给管理处填充数据
//		sp_precinct.setAdapter(new ArrayAdapter<String>(
//				getContext(),
//				android.R.layout.simple_expandable_list_item_1,
//				precinctnames));
		
		RoomSpAdapter adapter = new RoomSpAdapter(precinctnames, getContext());
		sp_precinct.setAdapter(adapter);
		//监听选中事件
		sp_precinct.setOnItemSelectedListener(new OnItemSelectedListener() {
	
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				pid = precinctid[position];
				//获取管理区下的大楼
				presenter.fetchFloor(precinctid[position]);
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void OnFloorDataSuccess(final String[] floorsid, String[] floorsname) {
		// TODO Auto-generated method stub
		//给大楼填充数据
		RoomSpAdapter adapter = new RoomSpAdapter(floorsname, getContext());
		sp_floor.setAdapter(adapter);
		
		sp_floor.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				fid = floorsid[position];
				//获取单元的信息
				presenter.fetchUnits();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void onUnitDataSuccess(final String[] unitsid, String[] unitsname) {
		// TODO Auto-generated method stub
		RoomSpAdapter adapter = new RoomSpAdapter(unitsname, getContext());
		sp_unit.setAdapter(adapter);
		
		sp_unit.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				uid=unitsid[position];
				//获取房间的信息
				presenter.fetchRoomInfo();
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	public void onRoomDataSuccess(final String[] roomsid, String[] roomsname) {
		// TODO Auto-generated method stub
		
		RoomSpAdapter adapter = new RoomSpAdapter(roomsid, getContext());
		sp_room.setAdapter(adapter);
		
		sp_room.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				rid=roomsid[position];
				//获取用户的所有数据的操作
				presenter.getHouseInfo();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	@Override
	public String getPrecinctID() {
		// TODO Auto-generated method stub
		return pid;
	}
	@Override
	public String getFloorID() {
		// TODO Auto-generated method stub
		return fid;
	}
	@Override
	public String getUnitID() {
		// TODO Auto-generated method stub
		return uid;
	}
	@Override
	public String getRoomID() {
		// TODO Auto-generated method stub
		return rid;
	}
	@Override
	public void isloading(boolean isloading) {
		// TODO Auto-generated method stub
		if(isloading){
			layout.setVisibility(View.VISIBLE);
		}else{
			layout.setVisibility(View.GONE);
		}
	}
	
	//请求房号完整的监听事件
	private OnRoomInfoCompleteListener listener;
	
	public void setCompleteListener(OnRoomInfoCompleteListener listener){
		this.listener=listener;
	}
	@Override
	public void onRoomComplete(RoomInfo roomInfo) {
		// TODO Auto-generated method stub
		//主要是将最终的结果拿到别处去用
		listener.onRoomInfoSuccess(roomInfo);
	}
	
	public interface OnRoomInfoCompleteListener{
		void onRoomInfoSuccess(RoomInfo roomInfo);
	}
}
