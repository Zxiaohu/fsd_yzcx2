package com.fsd.owner.property.presenter.fragment.impl;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Spanned;

import com.fsd.owner.property.model.bean.UserInfo;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.tools.UiTools;
import com.fsd.owner.property.ui.fragment.IUserInfoView;

public class UserInfoPresenter {


	private IUserInfoView mView;
	
	public UserInfoPresenter(IUserInfoView mView) {
		super();
		this.mView = mView;
	}

	/**设置用户的信息**/
	public void setUserInfo(){
		try{
			//获取用户的信息
			UserInfo userInfo=DataTools.getUserInfo();
			mView.setUserInfo(userInfo);
		}catch(Exception exception){
			SystemTools.fail("获取用户信息异常");
		}
	}

	public void exit(Context context){

		try {
			Spanned spanned1=UiTools.getSpanned("#cc4444","退出");
			Spanned spanned2=UiTools.getSpanned("#000000","取消");
			new AlertDialog.Builder(context).setItems(new Spanned[]{spanned1,spanned2}, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					switch (which) {
					case 0:
						//清除所有数据
						SharedPfTools.delAll();
						//退出
						mView.exit();
						break;
					case 1:
						dialog.dismiss();
						break;
					default:
						break;
					}
				}
			}).create().show();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			SystemTools.fail("退出异常");
			e.printStackTrace();
		}

	}

}
