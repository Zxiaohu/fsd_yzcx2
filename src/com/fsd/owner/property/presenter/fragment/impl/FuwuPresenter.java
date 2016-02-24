package com.fsd.owner.property.presenter.fragment.impl;

import android.content.Context;

import com.fsd.owner.property.global.HttpParam;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.bean.ConfigInfo;
import com.fsd.owner.property.model.bean.FuwuItemContent.FuwuItem;
import com.fsd.owner.property.model.httpdao.NewFetchDao;
import com.fsd.owner.property.model.httpdao.NewFetchDao.IHttpListenner;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.HttpTools;
import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.ui.fragment.IFuwuView;
import com.lidroid.xutils.http.RequestParams;

public class FuwuPresenter {
	private IFuwuView v;
	private NewFetchDao dao;
	private Context context;
	public FuwuPresenter(IFuwuView v,Context context) {
		super();
		this.v = v;
		this.context=context;
	}
	
	//获取子服务项的数据
	public void getSubS(final FuwuItem fuwuItem){
		//设置网络请求的参数
		RequestParams params = HttpTools.getParam(
				new HttpParam[]{HttpParam.CONFIGTYPE,HttpParam.UPID},new String[]{"subservice",fuwuItem.id});

		//v.isLoding(true);
		//实例化
		dao = new NewFetchDao(MyHttpUrl.CONFIG,params,new IHttpListenner() {
			@Override
			public void success(String r) {
				// TODO Auto-generated method stub
				LogUtil.i("config",r);
				//关闭进度框
				v.isLoding(false);
				v.onSubData(r,fuwuItem);
				
			}
			@Override
			public void fail(String arg1) {
				// TODO Auto-generated method stub
				LogUtil.e("config",arg1);
				//关闭进度框
				v.isLoding(false);
			}
		});
		dao.fetch();
	}
}
