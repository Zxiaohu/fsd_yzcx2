package com.fsd.owner.property.ui.fragment.impl.help;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.fsd.owner.property.R;
import com.fsd.owner.property.model.bean.ConfigInfo;
import com.fsd.owner.property.presenter.fragment.impl.TelsPresenter;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.tools.UiTools;
import com.fsd.owner.property.tools.Validation;
import com.fsd.owner.property.ui.adapter.CommonAdapter;
import com.fsd.owner.property.ui.adapter.ViewHolder;
import com.fsd.owner.property.ui.fragment.IHelpView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.TitleBar;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by zxh on 2016/2/23.
 */
public class TelsFragment extends BaseFragment implements TitleBar.TitleBarListener, IHelpView, AdapterView.OnItemClickListener {

    private static TelsFragment meObj;
    private TelsFragment(){}
    public static TelsFragment getInstance(){
        if(meObj==null){
            meObj=new TelsFragment();
        }
        return meObj;
    }
    @ViewInject(R.id.tb_tel)
    private TitleBar bar;
    @ViewInject(R.id.lv_tels)
    private ListView lv_tels;
    private TelsPresenter p;
    @Override
    public View initView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.fragment_tel,null);
        ViewUtils.inject(this,mRootView);
        return mRootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //初始化p
        p=new TelsPresenter(this);
        //填充标题
        bar.setLCR("返回","客服中心",null);
        bar.setListener(this);

        lv_tels.setOnItemClickListener(this);
        //获取listview的内容信息
        p.getData();
    }

    @Override
    public void back() {
        getActivity().finish();
    }

    @Override
    public void edit() {

    }

    private List<ConfigInfo> tels;
    @Override
    public void onTelDataSuccess(List<ConfigInfo> tels) {
        this.tels=tels;
        if(tels.size()>0) {
            //获取到数据，填充界面
            lv_tels.setAdapter(new CommonAdapter<ConfigInfo>(mContext, tels, R.layout.adapter_tels) {
                @Override
                public void convert(ViewHolder helper, ConfigInfo item) {
                    TextView tv = helper.getView(R.id.tv_desc);
                    String configvalue = item.getConfigvalue();
                    //添加蓝色的按钮

                    Spanned spanned2 = UiTools.getSpanned(ResTools.getStr(R.string.bule),configvalue );

                    tv.setText(spanned2);
                }
            });
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String s = Validation.filterNum(tels.get(position).getConfigvalue());

        //意图：想干什么事
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        //url:统一资源定位符
        //uri:统一资源标示符（更广）

        intent.setData(Uri.parse("tel:" +s));
        //开启系统拨号器
        startActivity(intent);
    }
}
