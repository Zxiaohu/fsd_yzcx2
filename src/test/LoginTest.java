package test;

import com.fsd.owner.property.model.bean.LoginUserInfo;
import com.fsd.owner.property.presenter.fragment.impl.LoginPersenter;
import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.ui.fragment.ILoginView;

import android.test.AndroidTestCase;

public class LoginTest extends AndroidTestCase implements ILoginView {
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	
	public void test(){
		LoginPersenter persenter = new LoginPersenter(this);
		persenter.doLogin();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return "13797041492";
	}

	@Override
	public String getUserPwd() {
		// TODO Auto-generated method stub
		return "123456";
	}

	@Override
	public void onLoginSuccess(LoginUserInfo userInfo) {
		// TODO Auto-generated method stub
		LogUtil.i("login", "成功");
	}


}
