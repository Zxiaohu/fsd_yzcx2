package com.fsd.owner.property.presenter.fragment.impl;

import com.fsd.owner.property.R;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.bean.TaskProgress;
import com.fsd.owner.property.model.httpdao.NewFetchDao;
import com.fsd.owner.property.tools.HttpTools;
import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.fragment.ITaskProgressView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.http.RequestParams;

import java.util.List;

public class TaskProgressPresenter {

    private ITaskProgressView v;

    public TaskProgressPresenter(ITaskProgressView v) {
        this.v = v;
    }

    public void getData(final String orderid) {
        try {

            RequestParams papram = HttpTools.getParam(ResTools.getStr(R.string.oderid), orderid);

            //读取缓存中的task进度
            String cacheProgress = SharedPfTools.queryStr("task"+orderid);

            if (cacheProgress != null) {
                //解析结果
                List<TaskProgress> progress = new Gson().fromJson(cacheProgress, new TypeToken<List<TaskProgress>>() {
                }.getType());

                //数据准备完毕
                v.onDataSuccess(progress,false);
            }

            //获取手机号
            NewFetchDao dao = new NewFetchDao(MyHttpUrl.PAIGONG_RATE, papram, new NewFetchDao.IHttpListenner() {
                @Override
                public void success(String r) {
                    LogUtil.e("progress", r);


                    //解析结果
                    List<TaskProgress> progress = new Gson().fromJson(r, new TypeToken<List<TaskProgress>>() {
                    }.getType());


                    //将数据存入缓存
                    SharedPfTools.insertData("task"+orderid, r);


                    //数据准备完毕
                    v.onDataSuccess(progress, true);
                }

                @Override
                public void fail(String arg1) {
                    SystemTools.fail(arg1);
                }
            });

            //发送请求
            dao.fetch();
        }catch (Exception e){
            SystemTools.fail("系统异常");
        }
    }
}
