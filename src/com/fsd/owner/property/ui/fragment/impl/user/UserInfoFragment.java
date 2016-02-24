package com.fsd.owner.property.ui.fragment.impl.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fsd.owner.property.R;
import com.fsd.owner.property.model.bean.UserInfo;
import com.fsd.owner.property.presenter.fragment.impl.UserInfoPresenter;
import com.fsd.owner.property.tools.ActivityCollector;
import com.fsd.owner.property.tools.BudleTools;
import com.fsd.owner.property.tools.BudleTools.BParam;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.fragment.IUserInfoView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.SimpleItem;
import com.fsd.owner.property.ui.view.TitleBar;
import com.fsd.owner.property.ui.view.TitleBar.TitleBarListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class UserInfoFragment extends BaseFragment implements IUserInfoView,OnClickListener, TitleBarListener{


	@ViewInject(R.id.iv_head)
	private ImageView iv_head;
	@ViewInject(R.id.tb_userinfo)
	private TitleBar bar;
	@ViewInject(R.id.si_nickname)
	private SimpleItem si_nickname;
	@ViewInject(R.id.si_address)
	private SimpleItem si_address;
	@ViewInject(R.id.si_houseinfo)
	private SimpleItem si_houseinfo;
	@ViewInject(R.id.si_score)
	private SimpleItem si_score;
	@ViewInject(R.id.si_update_pwd)
	private SimpleItem si_pwd;
	/**顶部头像**/
	@ViewInject(R.id.ry_head)
	private RelativeLayout ry_head;
	/**注销按钮**/
	@ViewInject(R.id.btn_exit)
	private Button btn_exit;

	private UserInfoPresenter mPresenter;
	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		mRootView=inflater.inflate(R.layout.fragment_userinfo,null);
		ViewUtils.inject(this,mRootView);
		initCurrentView();
		return mRootView;
	}

	private void initCurrentView() {
		// TODO Auto-generated method stub


	}

	@Override
	public void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//初始化p
		mPresenter = new UserInfoPresenter(this);
		bar.setLCR("返回","信息详情", "更多");
		bar.setListener(this);
		//设置用户信息
		mPresenter.setUserInfo();

		/*点击事件*/
		//昵称
		si_nickname.setOnClickListener(this);
		//地址 
		si_address.setOnClickListener(this);
		//住址
		si_houseinfo.setOnClickListener(this);
		//积分
		si_score.setOnClickListener(this);
		//密码
		si_pwd.setOnClickListener(this);
		//头像
		ry_head.setOnClickListener(this);

		//注销
		btn_exit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.si_nickname:
			//更新昵称
			update("update_nickname",si_nickname.getT(),si_nickname.getC());
			break;
		case R.id.ry_head:

			break;
		case R.id.si_houseinfo:
			//查看住址的详细信息

			break;
		case R.id.si_address:
			//更新收货地址操作
			update("update_address",si_address.getT(),si_address.getC());
			break;
		case R.id.si_update_pwd:
			//修改密码
			
			break;
		case R.id.si_score:

			break;
		case R.id.btn_exit://退出
			mPresenter.exit(mContext);
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 * @param simpleItems view控件
	 * @param tips 描述
	 * @param contents 內容
	 */
	public void setContent(SimpleItem [] simpleItems,String []tips,String [] contents){
		for (int i = 0; i < tips.length; i++) {
			simpleItems[i].setTAndC(tips[i],contents[i]);
		}
	}

	@Override
	public void setUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		setContent(
				new SimpleItem[]{si_nickname,si_houseinfo,si_address,si_score,si_pwd}, 
				ResTools.getArr(R.array.userinfo_item),
				new String[]{userInfo.getNickname(),userInfo.getHouse_name(),userInfo.getAddress(),userInfo.getScore(),""});
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

		ActivityCollector.finshAll();

	}

	/**
	 * 跳转修改
	 * @param flag 修改的类型
	 * @param t
	 * @param c
	 */
	public void update(String flag,String t,String c){
		//修改信息的fragment
		UpDateIFFragment u = new UpDateIFFragment();
		//设置传的参数值
		u.setArguments(BudleTools.setStr(new BParam[]{BParam.FLAG,BParam.TIP,BParam.CONTENT},new String[]{flag,t,c}));
		//跳转的方法
		SystemTools.jumpTActivity(mContext,u);
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		getActivity().finish();
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		/***跳转到更多的用户信息详情的查询***/
		UserInfoDetailFragment userInfoDetailFragment = UserInfoDetailFragment.getInstance();
		SystemTools.jumpTActivity(getActivity(),userInfoDetailFragment);
	}
}
