package com.fsd.owner.property.presenter.fragment.impl;

import android.content.Context;

import com.fsd.owner.property.global.SPParam;
import com.fsd.owner.property.model.httpdao.impl.RegsiterDao;
import com.fsd.owner.property.model.httpdao.impl.RegsiterDao.RegsiterDaoListener;
import com.fsd.owner.property.tools.CheckTools;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.fragment.IReginsterView;

public class RegisterPresenter implements RegsiterDaoListener {

	//注册的接口
	private IReginsterView mView;
	//注册的上下文
	private Context mContext;
	//注册的操作
	private RegsiterDao regsiterDao; 

	/*初始化*/
	public RegisterPresenter(IReginsterView mView, Context mContext) {
		super();
		this.mView = mView;
		this.mContext = mContext;
		regsiterDao = new RegsiterDao(this);
	}

	/**执行验证码的操作**/
	public void executeCheckNum() {
		// TODO Auto-generated method stub
		try{
			//获取用户的手机号码和随机生成验证码,请求发送信息
			String userPhoneNum = mView.getUserPhoneNum();

			//用户的真实手机号
			String userRelNum = SharedPfTools.queryStr(SPParam.PhoneNum); 

			if(CheckTools.isEmpty(new String[]{userPhoneNum})){
				SystemTools.fail("请输入手机号");
			}else if(!userPhoneNum.equals(userRelNum)){//验证用户输入的手机号是否和他的手机号相同
				SystemTools.fail("您输入的手机号与上不匹配,请联系管理员修改手机号");
			}else{
				//生成验证码
				String yzm=DataTools.get4Random();
				//验证码储存到本地
				SharedPfTools.insertData(SPParam.YZM,yzm);

				SystemTools.toastI(yzm);
				//执行验证操作哦
				//regsiterDao.setUnameYzm(userPhoneNum, yzm).sendHttp();
			}
		}catch(Exception exception){
			//执行验证码操作时系统异常
			SystemTools.fail("验证异常");
		}
	}

	@Override
	public void onSmsCheckReadly(String respone) {
		// TODO Auto-generated method stub
		SystemTools.toastI(respone);
	}

	/**注册操作**/
	public void executeRel() {
		// TODO Auto-generated method stub
		try{
			/*获取用户输入的验证码啊*/
			String checkNum = mView.getCheckNum();
			/*获取生成的本地验证码*/
			String checkrelNum=SharedPfTools.queryStr(SPParam.YZM);
			/*判断非空*/
			if(CheckTools.isEmpty(new String[]{checkNum})){
				SystemTools.fail("请输入验证码");
			}else if(!checkNum.equals(checkrelNum)){
				SystemTools.fail("验证失败");
			}else{//验证成功
				mView.CheckSuccess();
			}
		}catch(Exception exception){
			SystemTools.fail("注册异常");
		}
	}
}
