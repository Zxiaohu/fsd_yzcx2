package com.fsd.owner.property.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zxh on 2016/2/22.
 */
public class MyFragmentPagerAdapter<T extends Fragment> extends FragmentPagerAdapter {

    private List<T> lists;
    public MyFragmentPagerAdapter(FragmentManager fm,List<T> lists) {
        super(fm);
        this.lists=lists;
    }

    @Override
    public Fragment getItem(int i) {
        return lists.get(i);
    }

    @Override
    public int getCount() {
        return lists.size();
    }
}
