package com.fsd.owner.property.ui.fragment.impl.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.model.bean.TaskProgress;
import com.fsd.owner.property.presenter.fragment.impl.TaskProgressPresenter;
import com.fsd.owner.property.ui.adapter.CommonAdapter;
import com.fsd.owner.property.ui.adapter.ViewHolder;
import com.fsd.owner.property.ui.fragment.ITaskProgressView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.lv.MyListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 *
 */
public class TaskProgressFragment extends BaseFragment implements ITaskProgressView, MyListView.OnRefreshListener {

    @ViewInject(R.id.lv_task_progress)
    private MyListView lv_progress;

    //中控器
    private TaskProgressPresenter p;
    private String mOrderid;
    private CommonAdapter<TaskProgress> mProgressAdapter;

    //单列模式
    private TaskProgressFragment() {}
    private static TaskProgressFragment me=null;
    //静态工厂方法
    public static TaskProgressFragment getInstance() {
        if (me == null) {
            me = new TaskProgressFragment();
        }
        return me;
    }

    @Override
    public View initView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.fragment_taskprogress, null);
        ViewUtils.inject(this, mRootView);
        return mRootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //初始化
        p = new TaskProgressPresenter(this);

        lv_progress.setonRefreshListener(this);
        //获取orderId
        mOrderid = getArguments().getString("orderid");
        //获取数据
        p.getData(mOrderid);

    }


    private int index = 1;

    private List<TaskProgress> progress;
    @Override
    public void onDataSuccess(List<TaskProgress> progress, boolean b) {
        this.progress=progress;


        //从网络请求的通知刷新完毕
        if (b) {
            //刷新完毕
            lv_progress.onRefreshComplete();

        }

        //创建adapter
        mProgressAdapter = new
                CommonAdapter<TaskProgress>(mContext, this.progress, R.layout.adapter_task_progress) {
                    @Override
                    public void convert(ViewHolder helper, TaskProgress item) {

                        TextView head = helper.getView(R.id.tv_task_progress_id);
                        TextView tip = helper.getView(R.id.tv_task_progress_tip);
                        TextView time = helper.getView(R.id.tv_task_progress_time);

                        head.setText("态");
                        tip.setText(item.getRemark());
                        time.setText(item.getLogindate());

                    }
                };


        if (progress != null) {

            //创建适配器
            lv_progress.setAdapter(mProgressAdapter);

            //通知更新数据
            mProgressAdapter.notifyDataSetChanged();

        }


    }

    @Override
    public void onRefresh() {
        p.getData(mOrderid);
    }
}
