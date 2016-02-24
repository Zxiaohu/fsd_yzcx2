package com.fsd.owner.property.presenter.fragment.impl;
import android.content.Context;

import com.fsd.owner.property.R;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.global.SPParam;
import com.fsd.owner.property.model.bean.UserInfo;
import com.fsd.owner.property.model.httpdao.NewFetchDao;
import com.fsd.owner.property.model.httpdao.NewFetchDao.IHttpListenner;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.HttpTools;
import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.tools.UiTools;
import com.fsd.owner.property.tools.UiTools.IDialogListener;
import com.fsd.owner.property.tools.Validation;
import com.fsd.owner.property.ui.fragment.IPGView;
import com.lidroid.xutils.http.RequestParams;

/***
 * PGPersenter
 * @author zxh
 * 派工的工具类
 */
public class PGPersenter {

	//派工view接口
	private IPGView v;

	//构造函数，初始化v
	public PGPersenter(IPGView v) {
		super();
		this.v = v;
	}

	//设置照片
	public void setPhoto(){	
		//设置选择的照片到界面显示
		v.setPhoto();
	}


	//提交派工单数据
	public void submit(){

		//获取房间的id
		String houseid = v.getHouseId();
		String complainer=DataTools.getUserInfo().getNickname();
		//拍单人的手机号
		String tel=SharedPfTools.queryStr(SPParam.PhoneNum);
		//输入的内容
		String content=Validation.filterStr(v.getContent());
		//主服务项的id和子服务项的id
		String fuwuids[]=v.getFuWuIds();

		//验证表单
		if(Validation.StrisNull(content)){
			SystemTools.fail("请描述一下内容");
			return;
		}else if(Validation.isLengOut(content,100)){
			SystemTools.fail("内容超出最大值");
			return;
		}else if(Validation.StrisNull(houseid)){
			SystemTools.fail("请选择地址");
			return;
		}else{

			try {
				//请求的参数数组
				String paigong_params[]=new String[]{houseid,complainer,tel,content,fuwuids[0],fuwuids[1]};

				for (int i = 0; i < paigong_params.length; i++) {

					LogUtil.e("test", ResTools.getArr(R.array.paigong_param)[i]+"===="+ paigong_params[i]);
				}

				//设置请求的参数
				RequestParams params = HttpTools.getParam(ResTools.getArr(R.array.paigong_param),paigong_params);

				//提交表单信息
				NewFetchDao dao = new NewFetchDao(MyHttpUrl.PAIGONG, params, new IHttpListenner() {

					@Override
					public void success(String r) {
						// TODO Auto-generated method stub
						SystemTools.toastI(r);
						
						//成功后的操作
						v.onSubmitSuccess();
						
					}

					@Override
					public void fail(String arg1) {
						// TODO Auto-generated method stub
						SystemTools.fail(arg1);
					}
				});

				//发送请求
				dao.fetch();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				SystemTools.fail("生成派工单异常！");
			}
		}

	}


	public void setAddress(Context mContext) {
		// TODO Auto-generated method stub

		//获取用户的房子信息
		UserInfo userInfo = DataTools.getUserInfo();
		String strhouse_id = userInfo.getHouse_id();
		String strhouse_name=userInfo.getHouse_name();
		//房间的id
		final String house_id[];
		//房间的name
		final String house_name[];

		//判断是不是多房间的用户
		if(DataTools.isHaveIn("@", strhouse_id)){
			house_id = strhouse_id.split("@");
			house_name =strhouse_name.split("\\|");
		}else{
			house_id = new String[]{strhouse_id};
			house_name =new String[]{strhouse_name};
		}

		//显示对话框
		UiTools.showItemDialog(mContext, house_name, new IDialogListener() {
			@Override
			public void select(int which) {
				// TODO Auto-generated method stub
				v.setAddress(house_id[which],house_name[which]);
			}
		});
	}

}
