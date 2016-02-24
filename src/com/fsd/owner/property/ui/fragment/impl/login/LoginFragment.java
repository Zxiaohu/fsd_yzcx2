package com.fsd.owner.property.ui.fragment.impl.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.model.bean.LoginUserInfo;
import com.fsd.owner.property.presenter.fragment.impl.LoginPersenter;
import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.activiy.impl.LoginActivity;
import com.fsd.owner.property.ui.activiy.impl.MainActivity;
import com.fsd.owner.property.ui.fragment.ILoginView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.et.EditextDelete;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/****
 * 
 * LoginFragment
 * @author zxh
 * 2016年2月1日10:44:39
 * 登录的fragment
 *
 */
public class LoginFragment extends BaseFragment implements OnClickListener,ILoginView {

	@ViewInject(R.id.et_name)
	private EditextDelete et_name;
	@ViewInject(R.id.et_pwd)
	private EditextDelete et_pwd;
	@ViewInject(R.id.btn_login)
	private Button btn_login;
	@ViewInject(R.id.tv_rel)
	private TextView btn_rel;
	private LoginPersenter persenter;
	
	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		mRootView = inflater.inflate(R.layout.fragment_login, null);
		ViewUtils.inject(this,mRootView);
		return mRootView;
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		//初始化登录的p
		persenter = new LoginPersenter(this);
		btn_login.setOnClickListener(this);
		btn_rel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		LogUtil.e("test","我登录了");
		switch (v.getId()) {
		case R.id.btn_login://登录
			persenter.doLogin();
			break;
		case R.id.tv_rel:
			((LoginActivity)mContext).vp_content.setCurrentItem(1);
			break;
		default:
			break;
		}
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return et_name.getText().toString();
	}

	@Override
	public String getUserPwd() {
		// TODO Auto-generated method stub
		return et_pwd.getText().toString();
	}

	@Override
	public void onLoginSuccess(LoginUserInfo loginUserInfo) {
		// TODO Auto-generated method stub
		SystemTools.jumpActivity(mContext,MainActivity.class);
		((LoginActivity)mContext).finish();
	}


	

}
