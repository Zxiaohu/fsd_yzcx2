package com.fsd.owner.property.ui.fragment.impl.user;

import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.tools.BudleTools.BParam;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.activiy.impl.TempActivity;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.TitleBar;
import com.fsd.owner.property.ui.view.TitleBar.TitleBarListener;
import com.fsd.owner.property.ui.view.et.EditextDelete;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class UpDateIFFragment extends BaseFragment implements TitleBarListener {
	
	
	@ViewInject(R.id.tb_update)
	private TitleBar bar;
	@ViewInject(R.id.et_update)
	private EditextDelete et_update;
	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		mRootView=inflater.inflate(R.layout.fragment_update_info_,null);
		ViewUtils.inject(this,mRootView);
		return mRootView;
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//拿到传过来的数据
		Bundle arguments = getArguments();
		//修改的类型
		String flag=arguments.getString(BParam.FLAG.getDes());
		//修改的提示
		String t = arguments.getString(BParam.TIP.getDes());
		//修改的内容
		String c = arguments.getString(BParam.CONTENT.getDes());
		
		//设置标题栏的样式
		bar.setLCR("返回","修改"+t,"保存");
		
		//设置标题栏的监听事件
		bar.setListener(this);
		
		//设置编辑框的样式
		et_update.setText(c);
		
		//将光标移动到最后位置
		Editable etext = et_update.getText();
		Selection.setSelection(etext, etext.length());
		
		
	}

	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		((TempActivity)mContext).finish();
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		SystemTools.toastI("编辑");
		
		//修改的操作
		//根据标记判断
		
	}

}
