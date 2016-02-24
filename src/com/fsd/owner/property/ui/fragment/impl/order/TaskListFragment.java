package com.fsd.owner.property.ui.fragment.impl.order;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.model.bean.TaskInfo;
import com.fsd.owner.property.presenter.fragment.impl.TaskListPresenter;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.activiy.impl.MainActivity;
import com.fsd.owner.property.ui.activiy.impl.TaskActivity;
import com.fsd.owner.property.ui.activiy.impl.TempActivity;
import com.fsd.owner.property.ui.adapter.CommonAdapter;
import com.fsd.owner.property.ui.adapter.ViewHolder;
import com.fsd.owner.property.ui.fragment.ITaskListView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.TitleBar;
import com.fsd.owner.property.ui.view.TitleBar.TitleBarListener;
import com.fsd.owner.property.ui.view.lv.MyListView;
import com.fsd.owner.property.ui.view.lv.MyListView.OnRefreshListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

public class TaskListFragment extends BaseFragment implements ITaskListView, TitleBarListener, OnRefreshListener, OnItemClickListener {

	private TaskListPresenter p;
	@ViewInject(R.id.tb_task_list)
	private TitleBar bar;
	@ViewInject(R.id.lv_task_list)
	private MyListView lv_list;
	private BaseAdapter taskAdapter;
	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		mRootView = inflater.inflate(R.layout.fragment_tasklist, null);
		ViewUtils.inject(this, mRootView);
		return mRootView;
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		p= new TaskListPresenter(this);
		
		//设置标题栏
		bar.setLCR("返回","详情列表",null);
		bar.setListener(this);

		//添加刷新事件
		lv_list.setonRefreshListener(this);

		//请求网络获取数据
		p.getData();
		
		
		//设置list的点击事件
		lv_list.setOnItemClickListener(this);
		

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		((TempActivity)mContext).finish();
		SystemTools.jumpActivity(mContext,MainActivity.class);
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub

	}


	private List<TaskInfo> tasks;

	@Override
	public void setData(List<TaskInfo> tasks, boolean b) {
		// TODO Auto-generated method stub

		this.tasks=tasks;


		if(b){
			//通知刷新完成
			lv_list.onRefreshComplete();
		}


		//创建适配器
		taskAdapter =new CommonAdapter<TaskInfo>(mContext,this.tasks,R.layout.details_list) {
			@Override
			public void convert(ViewHolder helper, TaskInfo item) {
				// TODO Auto-generated method stub
				TextView tv1=helper.getView(R.id.tv_type);
				TextView tv2=helper.getView(R.id.tv_content);
				TextView tv3=helper.getView(R.id.tv_date);			
				tv1.setText(item.getPressstate());
				tv2.setText(item.getContent());
				tv3.setText(item.getComplainDate());
			}
		};

		if(taskAdapter!=null){
			//通知适配器更改数据
			taskAdapter.notifyDataSetChanged();
			//设置适配器
			lv_list.setAdapter(taskAdapter);

		}
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		//获取数据
		p.getData();
	}

	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub



		//跳转到详情页
		Intent intent =new Intent(mContext, TaskActivity.class);
		intent.putExtra("orderid",this.tasks.get(position-1).getId());
		startActivity(intent);
		
	}

}
