package com.fsd.owner.property.ui.activiy.impl;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.fsd.owner.property.R;
import com.fsd.owner.property.ui.activiy.ITempView;
import com.fsd.owner.property.ui.activiy.base.BaseActivity;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
/*****
 * TempActivity
 * @author zxh
 * 这个activity是用来承载fragment的activity
 * 根据不同的标记动态的加载fragment
 */
public class TempActivity extends BaseActivity implements ITempView {
	
	private static BaseFragment baseFragment;
	
	private FragmentManager mFragmentManager;
	private FragmentTransaction mFragmentTransaction;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_temp);
		
		mFragmentManager = getSupportFragmentManager();
		mFragmentTransaction =mFragmentManager.beginTransaction();
			
		//设置动画效果
		mFragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
				
		//填充fragment并提交
		mFragmentTransaction.add(R.id.fl_content, baseFragment);
		mFragmentTransaction.commit();
	}
	
	/**为activity设置fragment**/
	public static void setFrg4Ac(BaseFragment baseFragment){
		TempActivity.baseFragment=baseFragment;
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	
}
