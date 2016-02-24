package com.fsd.owner.property.ui.fragment.impl.fuwu;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.model.bean.ConfigInfo;
import com.fsd.owner.property.tools.BudleTools;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.tools.UiTools;
import com.fsd.owner.property.ui.activiy.impl.TempActivity;
import com.fsd.owner.property.ui.adapter.CommonAdapter;
import com.fsd.owner.property.ui.adapter.ViewHolder;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.TitleBar;
import com.fsd.owner.property.ui.view.TitleBar.TitleBarListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class PayFragment extends BaseFragment implements TitleBarListener {

	@ViewInject(R.id.tb_fw_pay)
	private TitleBar bar;

	@ViewInject(R.id.gv_subservice)
	private GridView gv_subservice;

	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		mRootView = inflater.inflate(R.layout.fragment_pay, null);
		ViewUtils.inject(this,mRootView);
		return mRootView;
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//获取页面传过来的数据
		Bundle b = getArguments();
		String subservices = b.getString("r");
		final String typeid = b.getString("id");
		final String typename = b.getString("name");

		//设置标题栏内容
		bar.setLCR("返回",typename,null);
		bar.setListener(this);

		//获取字符串中的内容
		final List<ConfigInfo> lists=new Gson().fromJson(subservices, new TypeToken<List<ConfigInfo>>(){}.getType());
		String test[]=new String[lists.size()];
		List<Spanned> list = new ArrayList<Spanned>();

		for (int i = 0; i < lists.size(); i++) {
			test[i]=lists.get(i).getConfigvalue();
			Spanned spanned = UiTools.getSpanned("#33B5E5",lists.get(i).getConfigvalue());
			list.add(spanned);
		}
		//填充listView
		
		
		gv_subservice.setAdapter(new CommonAdapter<Spanned>(mContext,list,R.layout.adapter_uc_item) {

			@Override
			public void convert(ViewHolder helper, Spanned item) {
				// TODO Auto-generated method stub
				TextView tv=helper.getView(R.id.tv_desc);
				tv.setText(item);
			}
		});
		
		//gv_subservice.setAdapter(new ArrayAdapter<Spanned>(mContext, android.R.layout.simple_list_item_1,list));

		//添加点击监听事件
		gv_subservice.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				//获取选中的 配置信息项（包含的是2级服务的数据）
				ConfigInfo configInfo = lists.get(position);

				
				//生成要携带数据的b
				String budle_name2paigong[]=new String[]{typeid,typename,configInfo.getConfigid(),configInfo.getConfigvalue()};

				//Bundle b = BudleTools.getBundle(R.array.budle_key2paigong,budle_name2paigong);
				Bundle b= new Bundle();
				
				//创建要跳转的fragment
				PaiGongFragment paiGongFragment = new PaiGongFragment();

				b.putStringArray("data", budle_name2paigong);
				//携带数据
				paiGongFragment.setArguments(b);

				
				//跳转到派工页
				SystemTools.jumpTActivity(mContext,paiGongFragment);
			}
		});
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		((TempActivity)mContext).finish();
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub

	}

}
