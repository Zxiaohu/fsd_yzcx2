package com.fsd.owner.property.ui.pagerview;

import android.content.Context;
import android.view.View;

/**
 * Created by zxh on 2016/2/19.
 */
public abstract class BasePager {

    protected View mRooteView;
    protected Context mContext;

    public BasePager(View mRooteView, Context mContext) {
        this.mRooteView = mRooteView;
        this.mContext = mContext;
    }

    /**
     * 初始化view
     * @return
     */
    abstract public View initView();


    /**
     * 填充数据
     */
    abstract public void initData();
}
