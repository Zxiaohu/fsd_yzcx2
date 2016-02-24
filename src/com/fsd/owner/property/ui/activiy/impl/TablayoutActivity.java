package com.fsd.owner.property.ui.activiy.impl;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fsd.owner.property.R;
import com.fsd.owner.property.ui.activiy.base.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxh on 2016/2/22.
 */
public class TablayoutActivity extends BaseActivity{

    @ViewInject(R.id.tabs)
    private TabLayout tab_layout;
    @ViewInject(R.id.vp_view)
    private ViewPager vp;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(R.layout.activity_helper);
        ViewUtils.inject(this);
        mInflater= LayoutInflater.from(this);




        view1=mInflater.inflate(R.layout.fragment_task_details,null);

        view2=mInflater.inflate(R.layout.fragment_task_details,null);



        mViewList.add(view1);

        mViewList.add(view2);


        //添加页卡标题
        mTitleList.add("客服电话");
        mTitleList.add("电子邮箱");


        tab_layout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式

        tab_layout.addTab(tab_layout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        tab_layout.addTab(tab_layout.newTab().setText(mTitleList.get(1)));


        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        vp.setAdapter(mAdapter);//给ViewPager设置适配器
        tab_layout.setupWithViewPager(vp);//将TabLayout和ViewPager关联起来。
        tab_layout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器



    }

    public class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }
    }

}
