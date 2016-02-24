package com.fsd.owner.property.ui.fragment.impl.fuwu;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.model.bean.FuwuItemContent;
import com.fsd.owner.property.model.bean.FuwuItemContent.FuwuItem;
import com.fsd.owner.property.presenter.fragment.impl.FuwuPresenter;
import com.fsd.owner.property.tools.BudleTools;
import com.fsd.owner.property.tools.BudleTools.BParam;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.activiy.impl.TempActivity;
import com.fsd.owner.property.ui.adapter.impl.GVAdapter;
import com.fsd.owner.property.ui.fragment.IFuwuView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.TitleBar;
import com.google.gson.Gson;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class FuwuFragment extends BaseFragment implements IFuwuView {

	/**服务项**/
	@ViewInject(R.id.gv_fuwu_item)
	private GridView gv_fuwu_item;

	/**标题**/
	@ViewInject(R.id.tb_fuwu)
	private TitleBar bar;

	private FuwuPresenter p;

	private ProgressDialog dialog;
	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		mRootView=inflater.inflate(R.layout.fragment_fuwu, null);
		ViewUtils.inject(this,mRootView);
		return mRootView;
	}


	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(dialog!=null&&dialog.isShowing()){

			dialog.dismiss();
		}
	}
	@Override
	public void initData(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		p= new FuwuPresenter(this,mContext);
		//设置标题栏
		bar.setLCR(null,"服务中心", null);
		//获取数据
		String str = ResTools.getStr(R.string.fuwu_item);
		//将数据转化为服务配置的对象
		final FuwuItemContent tipInfo =new Gson().fromJson(str, FuwuItemContent.class);
		//设置服务项的数据
		gv_fuwu_item.setAdapter(new GVAdapter(tipInfo.fuwu_items,mContext));
		//设置服务项的监听事件
		gv_fuwu_item.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				//如果是最后一个就不做处理
				if(tipInfo.fuwu_items.size()-1==position){
					SystemTools.toastI("待开发....");
				}else{
					//获取单个服务项
					FuwuItem fuwuItem = tipInfo.fuwu_items.get(position);
					//跳转到具体的服务请求的页面
					//开启进度条
					dialog = new ProgressDialog(mContext);
					dialog.setMessage("数据加载中...");
					dialog.show();
					//根据主项获取相应的子服务项
					p.getSubS(fuwuItem);

				}
			}
		});
	}

	@Override
	public void onSubData(String r,FuwuItem fuwuItem) {
		// TODO Auto-generated method stub
		//跳转到具体的服务页
		PayFragment payFragment = new PayFragment();
		Bundle b = new Bundle();

		b.putString("r", r);
		b.putString("id", fuwuItem.id);
		b.putString("name", fuwuItem.name);
		payFragment.setArguments(b);

		SystemTools.jumpTActivity(mContext, payFragment);
	}

	@Override
	public void isLoding(boolean b) {
		if(b){
			dialog.show();
		}else{
			dialog.dismiss();
		}
	}

}
