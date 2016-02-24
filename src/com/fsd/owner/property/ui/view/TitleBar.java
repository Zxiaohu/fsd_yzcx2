package com.fsd.owner.property.ui.view;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


public class TitleBar extends LinearLayout implements View.OnClickListener {
	private View mRootView;
	@ViewInject(R.id.tv_bar_l)
	private TextView l;
	@ViewInject(R.id.tv_bar_c)
	private TextView c;
	@ViewInject(R.id.tv_bar_r)
	private TextView r;
	private TitleBarListener listener;
	public TitleBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public TitleBar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}
	public void init(){
		mRootView=View.inflate(getContext(), R.layout.titlebar, this);
		ViewUtils.inject(this,mRootView);
	}

	public void setLCR(String l,String c,String r){
		if(l!=null){
			this.l.setVisibility(VISIBLE);
			this.l.setClickable(true);
			this.l.setText(l);
			this.l.setOnClickListener(this);
		}
		if(r!=null){
			this.r.setVisibility(VISIBLE);
			this.r.setClickable(true);
			this.r.setText(r);
			this.r.setOnClickListener(this);
		}
		this.c.setText(c);
	}
	public void setListener(TitleBarListener listener){
		this.listener=listener;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_bar_l:
			//回退
			listener.back();
			break;
		case R.id.tv_bar_r:
			//编辑
			listener.edit();
			break;
		default:
			break;
		}
	}

	public interface TitleBarListener{
		void back();
		void edit();
	}
	/***
	 * 设置中央的标题栏
	 */
	public void setTitle(String text){
		c.setText(text);
	}
}
