package com.fsd.owner.property.presenter.fragment.impl;
import com.fsd.owner.property.global.SPParam;
import com.fsd.owner.property.model.bean.LoginUserInfo;
import com.fsd.owner.property.model.bean.TipInfo;
import com.fsd.owner.property.model.httpdao.impl.LoginDao;
import com.fsd.owner.property.model.httpdao.impl.LoginDao.LoginListener;
import com.fsd.owner.property.presenter.fragment.ILoginPersenter;
import com.fsd.owner.property.tools.CheckTools;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.fragment.ILoginView;
import com.google.gson.Gson;
/**
 * LoginPersenter
 * @author xiaohu
 * 登录的中控类
 */
public class LoginPersenter implements ILoginPersenter, LoginListener {

	private ILoginView mView;
	private LoginDao loginDao;
	public LoginPersenter(ILoginView mView) {
		super();
		this.mView = mView;
		loginDao = new LoginDao();
		//设置监听事件
		loginDao.setLoginLister(this);
	}

	@Override
	public void doLogin() {
		// TODO Auto-generated method stub

		try{

			String name=mView.getUserName();
			String pwd =mView.getUserPwd();
			//非空验证
			if(CheckTools.isEmpty(new String[]{name,pwd})){
				SystemTools.fail("请输入完整信息");
			}else{
				//服务器验证
				loginDao.setNameAndPwd(new String[]{name,pwd});
				//发送验证
				loginDao.sendHttp();
			}
		}catch(Exception exception){
			SystemTools.fail("登录异常");
		}
	}

	@Override
	public void onLoginResonseReal(String result) {
		// TODO Auto-generated method stub
		try{
		LogUtil.e("login",result);

		//处理一下结果判断是不是成功了
		LoginUserInfo UserInfo = (LoginUserInfo) DataTools.getTipInfo(result,LoginUserInfo.class);
		
		if(UserInfo.getFlag()==1){//成功了
			
			//将登录的信息储存起来
			SharedPfTools.insertData(SPParam.PhoneNum,UserInfo.getUname());
			mView.onLoginSuccess(UserInfo);
		}else{//失败的操作
			SystemTools.fail(UserInfo.getInfo());
		}
		}catch(Exception exception){
			SystemTools.fail("登录异常,稍后重试！");
		}
	}
}
