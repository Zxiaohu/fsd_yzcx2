package com.fsd.owner.property.ui.fragment.impl.order;

import android.graphics.Color;
import android.os.Bundle;
import android.support.percent.PercentRelativeLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.tools.UiTools;
import com.fsd.owner.property.ui.fragment.ITaskDetailView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 派工详情页
 *
 * @author zxh
 *         2016年2月22日09:04:50
 */
public class TaskDetailFragment extends BaseFragment implements ITaskDetailView {


    @ViewInject(R.id.pry_taskdetail)
    private PercentRelativeLayout content;

    //单列模式
    private TaskDetailFragment() {
    }

    private static TaskDetailFragment me = null;

    //静态工厂方法
    public static TaskDetailFragment getInstance() {
        if (me == null) {
            me = new TaskDetailFragment();
        }
        return me;
    }



    @Override
    public View initView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.fragment_task_details, null);
        ViewUtils.inject(this, mRootView);
        return mRootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //List<TextView> items = new ArrayList<TextView>();
        int childCount = content.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TextView tv = (TextView) content.getChildAt(i);
            String randColorCode = "#"+UiTools.getRandColorCode();
            tv.setBackgroundColor(Color.parseColor(randColorCode));
        }


    }
}
