package com.fsd.owner.property.ui.activiy.impl;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.widget.TabHost.OnTabChangeListener;
import com.fsd.owner.property.R;
import com.fsd.owner.property.ui.activiy.IMainView;
import com.fsd.owner.property.ui.activiy.base.BaseActivity;
import com.fsd.owner.property.ui.fragment.impl.fuwu.FuwuFragment;
import com.fsd.owner.property.ui.fragment.impl.user.UserCenterFragment;
import com.fsd.owner.property.ui.view.MyTabItem;


public class MainActivity extends BaseActivity implements IMainView {
	public FragmentTabHost tabHost;
	private final String TAG_FUWU="fuwu";
	private final String TAG_USER_CENTER="user_center";
	
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.setContentView(R.layout.activity_main);

		//初始化tabhost
		initTabhost();


	}
	/**
	 * 初始化tabhost
	 */
	private void initTabhost() {

		//1.初始化tabhost
		tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		tabHost.setup(this, getSupportFragmentManager(),R.id.realtabcontent);

		//2.初始化tabSpec;
		final MyTabItem fuwuTabItem = new MyTabItem(this);
		fuwuTabItem.setTitle("服务");
		fuwuTabItem.setImage(R.drawable.star_green, R.drawable.star_red);
		//添加tab
		tabHost.addTab(tabHost.newTabSpec(TAG_FUWU).setIndicator(fuwuTabItem),
				FuwuFragment.class, null);
		
		//2.初始化tabSpec;
		final MyTabItem usercenterTabItem= new MyTabItem(this);
		usercenterTabItem.setTitle("我的");
		usercenterTabItem.setImage(R.drawable.star_green, R.drawable.star_red);
		//添加tab
		tabHost.addTab(tabHost.newTabSpec(TAG_USER_CENTER).setIndicator(usercenterTabItem),
				UserCenterFragment.class, null);

		usercenterTabItem.setSelect(true);
		tabHost.setCurrentTabByTag(TAG_USER_CENTER);

		//3.监听tabhost选中事件
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			public void onTabChanged(String tabId) {
				fuwuTabItem.setSelect(false);
				usercenterTabItem.setSelect(false);
				if(tabId.equals(TAG_FUWU)){

					fuwuTabItem.setSelect(true);
					tabHost.setCurrentTabByTag(TAG_FUWU);

				}else if(tabId.equals(TAG_USER_CENTER)){
					usercenterTabItem.setSelect(true);
					tabHost.setCurrentTabByTag(TAG_USER_CENTER);
				}
			}
		});
	}
}
