package com.fsd.owner.property.ui.view;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fsd.owner.property.R;

/**
 * Created by zxh on 2016/2/23.
 */
public class SameTabItem extends LinearLayout {
    //根view
    private View v;
    //左侧的item
    private TextView tv1;
    //右侧的item
    private TextView tv2;
    public SameTabItem(Context context) {
        super(context);
        init(context);
    }

    public SameTabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SameTabItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public SameTabItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    /**初始化view**/
    private void init(Context context) {
        v = View.inflate(getContext(), R.layout.userinfo_detail_item,this);
        tv1= (TextView) v.findViewById(R.id.tv_r1c1);
        tv2= (TextView) v.findViewById(R.id.tv_r1c2);
    }

    /**设置显示的内容**/
    public void setContent(Spanned left, Spanned right){
        tv1.setText(left);
        tv2.setText(right);
    }

}
