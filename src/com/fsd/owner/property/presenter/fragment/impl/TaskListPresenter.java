package com.fsd.owner.property.presenter.fragment.impl;

import com.fsd.owner.property.global.HttpParam;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.global.SPParam;
import com.fsd.owner.property.model.bean.TaskInfo;
import com.fsd.owner.property.model.httpdao.NewFetchDao;
import com.fsd.owner.property.model.httpdao.NewFetchDao.IHttpListenner;
import com.fsd.owner.property.tools.HttpTools;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.ui.fragment.ITaskListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.http.RequestParams;

import java.util.List;

public class TaskListPresenter {
	
	//不解释
	private ITaskListView v;
	
	//不解释
	public TaskListPresenter(ITaskListView v) {
		super();
		this.v = v;
	}

	//从服务器获取数据
	public void getData() {
		// TODO Auto-generated method stub
		
		//获取用户的手机号
		String tel= SharedPfTools.queryStr(SPParam.PhoneNum);
		
		//判断缓存中是否有数据
		String cache = SharedPfTools.queryStr(SPParam.TaskListInfo);
		if(cache!=null){
			//获取数据成功后
			List<TaskInfo> tasks = new Gson().fromJson(cache,new TypeToken<List<TaskInfo>>() {}.getType());
			v.setData(tasks,false);
		}
		//设置请求的参数
		RequestParams params = HttpTools.getParam(HttpParam.UNAME,tel);
		//请求网络获取订单的信息
		NewFetchDao dao = new NewFetchDao(MyHttpUrl.PAIGONG_LIST, params, new IHttpListenner() {
			@Override
			public void success(String r) {
				// TODO Auto-generated method stub

				SharedPfTools.insertData(SPParam.TaskListInfo, r);
				
				List<TaskInfo> tasks = new Gson().fromJson(r,new TypeToken<List<TaskInfo>>() {}.getType());
				//将数据存到缓存中去
				
				//获取数据成功后
				v.setData(tasks, true);
				
			}
			
			@Override
			public void fail(String arg1) {
				// TODO Auto-generated method stub
				
			}
		});
		
		dao.fetch();
		
	}

}
