package com.fsd.owner.property.ui.fragment.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class  BaseFragment extends Fragment{
	
	/**根布局**/
	protected View mRootView;
	/***上下文**/
	protected Context mContext;
	
	/***初始化View***/
	abstract public View initView(LayoutInflater inflater);
	
	/**初始化数据
	 * @param savedInstanceState **/
	abstract public void initData(Bundle savedInstanceState);
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mContext = activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mRootView = initView(inflater);
		return mRootView;
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData(savedInstanceState);
	}
	
	
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		if(mContext!=null){
			mContext=null;
		}
	}
}
