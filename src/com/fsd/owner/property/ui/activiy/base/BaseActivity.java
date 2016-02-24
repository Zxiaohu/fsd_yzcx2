package com.fsd.owner.property.ui.activiy.base;

import com.fsd.owner.property.tools.ActivityCollector;
import com.fsd.owner.property.tools.LogUtil;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends FragmentActivity {
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		LogUtil.d("BaseActivity", this.getClass().getSimpleName()+"被加载");
		ActivityCollector.addActivity(this);


	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		LogUtil.e("BaseActivity", this.getClass().getSimpleName()+"被销毁");
		ActivityCollector.removeActivity(this);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}
}	
