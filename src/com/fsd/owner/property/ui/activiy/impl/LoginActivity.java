package com.fsd.owner.property.ui.activiy.impl;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;

import com.fsd.owner.property.R;
import com.fsd.owner.property.ui.activiy.base.BaseActivity;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.fragment.impl.login.LoginFragment;
import com.fsd.owner.property.ui.fragment.impl.login.RegisterFragment;
import com.fsd.owner.property.ui.view.viewpager.MyViewPager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
/***
 * LoginActivity
 * @author zxh
 * 主界面activity
 */
public class LoginActivity extends BaseActivity implements OnPageChangeListener {

	@ViewInject(R.id.vp_content)
	public MyViewPager vp_content;

	List<BaseFragment> mFragments;

	FragmentPagerAdapter adapter;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_login);
		ViewUtils.inject(this);

		//初始化fragment
		initFragments();

		//初始化 fragment适配器
		adapter=new MyPagerAdater(getSupportFragmentManager(),mFragments);

		if(adapter!=null){
			vp_content.setAdapter(adapter);
		}

		//设置不能滚动，并添加监听事件
		vp_content.setCanScroll(false).setOnPageChangeListener(this);
	}

	//初始化fragment
	private void initFragments() {
		// TODO Auto-generated method stub
		mFragments = new ArrayList<BaseFragment>();
		LoginFragment loginFragment = new LoginFragment();
		RegisterFragment registerFragment = new RegisterFragment();
		mFragments.add(loginFragment);
		mFragments.add(registerFragment);
	}


	/****
	 * 
	 * @author xiaohu
	 *
	 */
	class MyPagerAdater extends FragmentPagerAdapter{

		private List<BaseFragment> fragments;

		public MyPagerAdater(FragmentManager fm,List<BaseFragment> fragments) {
			super(fm);
			// TODO Auto-generated constructor stub
			this.fragments=fragments;
		}


		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fragments.size();
		}
	}


	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		/*
		 * 对页面的位置进行控制
		 * 登录页不允许滚动
		 * 注册页允许滚动
		 * */
		if(arg0==0){
			vp_content.setCanScroll(false);
		}else{
			vp_content.setCanScroll(true);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		int currentItem = vp_content.getCurrentItem();
		if(currentItem==0){
			return super.onKeyDown(keyCode, event);
		}else{
			vp_content.setCurrentItem(0);
			return false;
		}
	}
}
