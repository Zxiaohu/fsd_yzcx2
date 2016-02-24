package test;

import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.ui.view.roomchoose.IRoomChView;
import com.fsd.owner.property.ui.view.roomchoose.RoomChPresenter;
import com.fsd.owner.property.ui.view.roomchoose.RoomInfo;

import android.test.AndroidTestCase;

public class MyTest extends AndroidTestCase implements IRoomChView {
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	public void test(){
		RoomChPresenter presenter = new RoomChPresenter(this,mContext);
		presenter.fetchData();
	}
	
	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	@Override
	public void onPrecinctDataSuccess(String[] precinctid,
			String[] precinctnames) {
		// TODO Auto-generated method stub
		for (int i = 0; i < precinctnames.length; i++) {

			LogUtil.e("test",precinctid[i]+precinctnames[i]);
		}
		
	}

	@Override
	public void OnFloorDataSuccess(String[] floorsid, String[] floorsname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUnitDataSuccess(String[] unitsid, String[] unitsname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRoomDataSuccess(String[] roomsid, String[] roomsname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPrecinctID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFloorID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnitID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRoomID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void isloading(boolean isloading) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRoomComplete(RoomInfo roomInfo) {
		// TODO Auto-generated method stub
		
	}
}
