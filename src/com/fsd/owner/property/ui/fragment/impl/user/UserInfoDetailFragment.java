package com.fsd.owner.property.ui.fragment.impl.user;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;

import com.fsd.owner.property.R;
import com.fsd.owner.property.model.bean.UserAllInfo;
import com.fsd.owner.property.presenter.fragment.impl.UserInfoDetailPersenter;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.ui.fragment.IUserInfoDetailView;
import com.fsd.owner.property.ui.fragment.base.BaseFragment;
import com.fsd.owner.property.ui.view.SameTabItem;
import com.fsd.owner.property.ui.view.TitleBar;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * Created by zxh on 2016/2/23.
 */
public class UserInfoDetailFragment extends BaseFragment implements IUserInfoDetailView, TitleBar.TitleBarListener {


    //控制器
    private UserInfoDetailPersenter p;
    @ViewInject(R.id.tb_userinfo_detail)
    private TitleBar bar;

    @ViewInject(R.id.sti_r1)
    private SameTabItem sti_r1;
    @ViewInject(R.id.sti_r2)
    private SameTabItem sti_r2;
    @ViewInject(R.id.sti_r3)
    private SameTabItem sti_r3;


    //单列
    private static UserInfoDetailFragment meobj;

    private UserInfoDetailFragment() {
    }

    public static UserInfoDetailFragment getInstance() {
        if (meobj == null) {
            meobj = new UserInfoDetailFragment();
        }
        return meobj;
    }

    @Override
    public View initView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.fragment_userinfo_detail, null);
        ViewUtils.inject(this, mRootView);
        return mRootView;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //初始化p
        p = new UserInfoDetailPersenter(this);
        //初始话标题栏
        initBar();

        //获取业主的详细个人信息啦
        p.getRoomInfo();

    }

    private void initBar() {
        bar.setLCR("返回", "业主详细信息", null);
        bar.setListener(this);
    }

    @Override
    public void back() {
        getActivity().finish();
    }

    @Override
    public void edit() {

    }

    @Override
    public void onInfoSuccess(UserAllInfo userallinfo) {
        if (userallinfo != null) {
            //建筑面积
            String s1=userallinfo.getChargearea();
            //物业费单价
            String s2=userallinfo.getUnitprice();
            //月缴费额
            String s3=userallinfo.getAdministratesum();
            //物业费到期日期
            String s4=userallinfo.getMoneyenddate();
            //水费预存额
            String s5=userallinfo.getWaterBalance();
            //电费预存额
            String s6=userallinfo.getElectricBalance();

            sti_r1.setContent(getTvType("建筑面积",s1),getTvType("物业费单价",s2));
            sti_r2.setContent(getTvType("月缴费额",s3), getTvType("到期时间",s4));
            sti_r3.setContent(getTvType("水费预存款",s5),getTvType("电费预存款",s6));
        }
    }


    private Spanned getTvType(String s1,String s2){
        String pipeistr="<font color="+ ResTools.getStr(R.string.black)
                +">"+s1+":</font>"+"\t<font " +
                "color="+ ResTools.getStr(R.string.bule)+">"+s2+"</font>";

        return Html.fromHtml(pipeistr);
    }


    @Override
    public void onDataFail() {

    }
}
