package com.fsd.owner.property.ui.activiy.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.ui.activiy.ITaskView;
import com.fsd.owner.property.ui.activiy.base.BaseActivity;
import com.fsd.owner.property.ui.adapter.MyFragmentPagerAdapter;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.fragment.impl.order.TaskDetailFragment;
import com.fsd.owner.property.ui.fragment.impl.order.TaskProgressFragment;
import com.fsd.owner.property.ui.view.TitleBar;
import com.fsd.owner.property.ui.view.TitleBar.TitleBarListener;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/***
 * TaskActivity
 *
 * @author zxh
 *         订单详情页
 */
public class TaskActivity extends BaseActivity implements ITaskView, TitleBarListener, ViewPager.OnPageChangeListener, View.OnClickListener {

    @ViewInject(R.id.tb_task_detail)
    private TitleBar bar;

    @ViewInject(R.id.tv_task_left)
    private TextView tv_bar_left;

    @ViewInject(R.id.tv_task_right)
    private TextView tv_bar_right;

    @ViewInject(R.id.vp_task_content)
    private ViewPager vp_content;

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private List<BaseFragment> mFragments;
    @Override
    protected void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        this.setContentView(R.layout.activity_task);
        ViewUtils.inject(this);
        initData();
    }

    private void initData() {
        // TODO Auto-generated method stub


        //初始化 fragmentmanager
        manager = getSupportFragmentManager();

        //初始化 fragmentTransaction事物
       // transaction=manager.beginTransaction();



        //初始化fragments
        mFragments = new ArrayList<BaseFragment>();

        //获取从上级页面获取的 数据
        Intent data = getIntent();
        String orderid = data.getStringExtra("orderid");


        TaskProgressFragment fragment1= TaskProgressFragment.getInstance();
        Bundle b = new Bundle();
        b.putString("orderid",orderid);
        fragment1.setArguments(b);

        TaskDetailFragment fragment2 = TaskDetailFragment.getInstance();

        mFragments.add(fragment1);
        mFragments.add(fragment2);
        vp_content.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),mFragments));

        vp_content.setOnPageChangeListener(this);
        vp_content.setCurrentItem(0);


//
//        transaction.add(R.id.fl_task_content,fragment1);
//
//        transaction.commit();

        tv_bar_left.setText("派工进度");
        tv_bar_right.setText("派工详情");
        //默认选中第一项
        setTvState(true,tv_bar_left);
        setTvState(false,tv_bar_right);
        bar.setLCR("返回",null, null);
        bar.setTitle(getResources().getString(R.string.task_prigress));
        bar.setListener(this);
        tv_bar_left.setOnClickListener(this);
        tv_bar_right.setOnClickListener(this);

    }

    @Override
    public void back() {
        // TODO Auto-generated method stub
        this.finish();
    }

    @Override
    public void edit() {
        // TODO Auto-generated method stub
        //缺省的
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if(i==0){
            setTvState(true,tv_bar_left);
            setTvState(false,tv_bar_right);
            bar.setTitle(getResources().getString(R.string.task_prigress));
        }else if(i==1){
            setTvState(false,tv_bar_left);
            setTvState(true,tv_bar_right);
            bar.setTitle(getResources().getString(R.string.task_detail));
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    //设置选中状态
    private void setTvState(boolean isSelect,TextView tv){
        if(isSelect) {
            tv.setTextColor(getResources().getColor(R.color.green));
        }else{
            tv.setTextColor(getResources().getColor(R.color.black));
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.tv_task_left){
            vp_content.setCurrentItem(0);
        }else if(id==R.id.tv_task_right){
            vp_content.setCurrentItem(1);
        }
    }
}
