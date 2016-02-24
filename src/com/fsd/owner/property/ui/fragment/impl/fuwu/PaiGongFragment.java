package com.fsd.owner.property.ui.fragment.impl.fuwu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.fsd.owner.property.R;
import com.fsd.owner.property.presenter.fragment.impl.PGPersenter;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.tools.UiTools;
import com.fsd.owner.property.ui.activiy.impl.TempActivity;
import com.fsd.owner.property.ui.fragment.IPGView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.fragment.impl.order.TaskListFragment;
import com.fsd.owner.property.ui.view.SimpleItem;
import com.fsd.owner.property.ui.view.TitleBar;
import com.fsd.owner.property.ui.view.TitleBar.TitleBarListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class PaiGongFragment extends BaseFragment implements TitleBarListener, OnClickListener, IPGView {

	@ViewInject(R.id.tb_pg)
	private TitleBar bar;
	@ViewInject(R.id.et_pg_content)
	private EditText et_content;
	@ViewInject(R.id.si_select_photo)
	private SimpleItem si_photo;

	@ViewInject(R.id.si_select_address)
	private SimpleItem si_address;
	
	@ViewInject(R.id.btn_pg_subit)
	private Button btn_submit;
	//派工p
	private PGPersenter p;
	/**0主服务id，1主服务值，2次级服务id，3次级服务值***/
	private String[] datas;
	private String houseid;

	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		mRootView = inflater.inflate(R.layout.fragment_paigong, null);
		ViewUtils.inject(this,mRootView);
		return mRootView;
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		//初始化派工的p
		p = new PGPersenter(this);
		
		//获取上级页面传过来的数据
		Bundle arguments = getArguments();
		//把上级传过来的数据赋值给成员变量
		datas = arguments.getStringArray("data");
		
		
		//设置派工的标题
		bar.setLCR("返回",datas[1]+">"+datas[3], null);
		bar.setListener(this);

		//设置选择照片的条目的内容
		si_photo.setTAndC("照片","");
		si_photo.setSize(16);
		//设置选择照片监听
		si_photo.setOnClickListener(this);

		//设置选择地址的条目
		si_address.setTAndC("选择地址", "");
		si_address.setSize(16);
		si_address.setOnClickListener(this);
		
		
		//提交按钮的监听事件
		btn_submit.setOnClickListener(this);
		

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		((TempActivity)mContext).finish();
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.si_select_photo:
			//选择照片
			
			break;
		case R.id.si_select_address:
			
			//弹出选择地址的对话框
			p.setAddress(mContext);
			break;
		case R.id.btn_pg_subit:
			//选择地址
			p.submit();
			
			break;
		default:
			break;
		}
	}

	@Override
	public void setPhoto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getHouseId() {
		// TODO Auto-generated method stub
		//返回houseid
		return this.houseid;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		
		return et_content.getText().toString().trim();
	}

	@Override
	public String[] getFuWuIds() {
		// TODO Auto-generated method stub
		//拿到服务的id返回
		String arr[]=new String[]{datas[0],datas[2]};
		return arr;
	}

	@Override
	public void onSubmitSuccess() {
		// TODO Auto-generated method stub
		//跳转到详情页
		SystemTools.jumpTActivity(mContext, new TaskListFragment());
		((TempActivity)mContext).finish();
	}

	@Override
	public void setAddress(String houseid, String housename) {
		// TODO Auto-generated method stub
		//设置房间的id
		this.houseid=houseid;
		//设置地址内容
		si_address.setTAndC("地址", housename);
	}

}
