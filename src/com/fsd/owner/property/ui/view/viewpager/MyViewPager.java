package com.fsd.owner.property.ui.view.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {

	private boolean isCanScroll=false; 
	
	public MyViewPager setCanScroll(boolean isCanScroll){
		this.isCanScroll=isCanScroll;
		return this;
	}
	
	public MyViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		if(isCanScroll){
			return super.onTouchEvent(arg0);
		}else{			
			return isCanScroll;
		}
	}
}
