package com.fsd.owner.property.ui.view;

import com.fsd.owner.property.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SimpleItem extends LinearLayout {
	private View mRootView;
	private TextView tv_tip;
	private TextView tv_content;
	public SimpleItem(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public SimpleItem(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public SimpleItem(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
	}
	
	private void init(Context context){
		mRootView=View.inflate(context, R.layout.uinfo_item, this);
		tv_tip=(TextView) mRootView.findViewById(R.id.tv_uinfo_tip);
		tv_content=(TextView) mRootView.findViewById(R.id.tv_uinfo_content);
	}
	
	public void setTAndC(String t,String c){
		tv_tip.setText(t);
		tv_content.setText(c);
	}
	public String getT(){
		return tv_tip.getText().toString().trim();
	}
	public String getC(){
		return tv_content.getText().toString().trim();
	}
	public void setSize(int dimen){
		tv_tip.setTextSize(dimen);
		tv_content.setTextSize(dimen);
	}
}
