package com.fsd.owner.property.presenter.fragment.impl;

import com.fsd.owner.property.R;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.bean.ConfigInfo;
import com.fsd.owner.property.model.httpdao.NewFetchDao;
import com.fsd.owner.property.tools.HttpTools;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.fragment.IHelpView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.http.RequestParams;

import java.util.List;

/**
 * Created by zxh on 2016/2/23.
 */
public class TelsPresenter {
    private IHelpView v;

    public TelsPresenter(IHelpView v) {
        this.v = v;
    }

    public void getData() {
        try {
            //先判断缓存中是否有数据
            String cache = SharedPfTools.queryStr(ResTools.getStr(R.string.office_telinfo));


            if (cache != null) {
                List<ConfigInfo> tels = new Gson().fromJson(cache, new TypeToken<List<ConfigInfo>>() {
                }
                        .getType());
                v.onTelDataSuccess(tels);
            }

            //请求网络小区联系方式的
            RequestParams params = HttpTools.getParam(ResTools.getStr(R.string.configtype), "telephone");
            //请求网络获取各个管理处的数据
            NewFetchDao dao = new NewFetchDao(MyHttpUrl.CONFIG, params, new NewFetchDao.IHttpListenner() {
                @Override
                public void success(String r) {

                    //将数据储存的缓存中
                    SharedPfTools.insertData(ResTools.getStr(R.string.office_telinfo), r);

                    //解析数据
                    List<ConfigInfo> tels = new Gson().fromJson(r, new TypeToken<List<ConfigInfo>>() {
                    }
                            .getType());
                    v.onTelDataSuccess(tels);
                }

                @Override
                public void fail(String arg1) {
                    SystemTools.fail("网络异常,请重试");
                }
            });

            //发送请求
            dao.fetch();
        } catch (Exception e) {
            SystemTools.fail("查询信息异常,请重试");
        }
    }
}
