package com.fsd.owner.property.ui.fragment.impl.user;

import android.os.Bundle;
import android.support.percent.PercentRelativeLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.global.SPParam;
import com.fsd.owner.property.model.bean.UserInfo;
import com.fsd.owner.property.presenter.fragment.impl.UserCenterPresenter;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.activiy.impl.LoginActivity;
import com.fsd.owner.property.ui.activiy.impl.TempActivity;
import com.fsd.owner.property.ui.fragment.IUserCenterView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.fragment.impl.help.TelsFragment;
import com.fsd.owner.property.ui.fragment.impl.order.TaskListFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class UserCenterFragment extends BaseFragment implements IUserCenterView, OnClickListener{

	
	@ViewInject(R.id.prl_title)
	private PercentRelativeLayout prl_title;
	@ViewInject(R.id.tv_evaluate)
	private TextView tv_evaluate;
	@ViewInject(R.id.tv_details)
	private TextView tv_details;
	@ViewInject(R.id.tv_help)
	private TextView tv_help;
	@ViewInject(R.id.top_right_top)
	private TextView tv_nickname;
	@ViewInject(R.id.top_right_bottom)
	private TextView tv_phone;
	private UserCenterPresenter presenter;
	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		mRootView=inflater.inflate(R.layout.fragment_usercenter, null);
		ViewUtils.inject(this, mRootView);

		return mRootView;
	}


	@Override
	public void initData(Bundle savedInstanceState) {
		presenter = new UserCenterPresenter(this);
		/**初始化**/
		// TODO Auto-generated method stub
		prl_title.setOnClickListener(this);
		tv_details.setOnClickListener(this);
		tv_evaluate.setOnClickListener(this);
		tv_help.setOnClickListener(this);

		//判断用户是否登录
		presenter.setUserIsLogin();

	}


	@Override
	public void onUserNotLogin() {
		// TODO Auto-generated method stub
		SystemTools.jumpActivity(mContext, LoginActivity.class);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.prl_title:
			
			//跳转到个人信息列表
			TempActivity.setFrg4Ac(new UserInfoFragment());
			SystemTools.jumpActivity(mContext, TempActivity.class);
			
			break;
		case R.id.tv_evaluate:
			//跳转到评价界面
			break;
		case R.id.tv_details:
			//跳转到服务列表界面
			SystemTools.jumpTActivity(mContext, new TaskListFragment());
			break;
		case R.id.tv_help:
			//跳转到帮助信息界面
			SystemTools.jumpTActivity(mContext, TelsFragment.getInstance());
			break;
		default:
			break;
		}
	}


	@Override
	public void onUserLogin(UserInfo userinfo_obj) {
		// TODO Auto-generated method stub
		
		
		tv_nickname.setText(userinfo_obj.getNickname());
		tv_phone.setText(SharedPfTools.queryStr(SPParam.PhoneNum));
	
	}
}
