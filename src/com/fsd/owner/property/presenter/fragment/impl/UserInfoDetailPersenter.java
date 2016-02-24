package com.fsd.owner.property.presenter.fragment.impl;

import com.fsd.owner.property.R;
import com.fsd.owner.property.global.MyHttpUrl;
import com.fsd.owner.property.model.bean.UserAllInfo;
import com.fsd.owner.property.model.bean.UserInfo;
import com.fsd.owner.property.model.httpdao.NewFetchDao;
import com.fsd.owner.property.tools.DataTools;
import com.fsd.owner.property.tools.HttpTools;
import com.fsd.owner.property.tools.LogUtil;
import com.fsd.owner.property.tools.ResTools;
import com.fsd.owner.property.tools.SharedPfTools;
import com.fsd.owner.property.tools.SystemTools;
import com.fsd.owner.property.ui.fragment.IUserInfoDetailView;
import com.google.gson.Gson;
import com.lidroid.xutils.http.RequestParams;

/**
 * Created by zxh on 2016/2/23.
 */
public class UserInfoDetailPersenter {
    private IUserInfoDetailView v;

    public UserInfoDetailPersenter(IUserInfoDetailView v) {
        this.v = v;
    }

    /**
     * 获取业主的详细信息
     **/
    public void getRoomInfo() {
        try {
            //是否是多房间
            boolean isMroeHouse = false;





            /***
             *
             * allinfo.asp 根据房号查询业主信息
             对接参数 PrecinctID BuildingID FloorID  RoomID houseid（房间id） operate操作（roominfo，moneyinfo）
             返回
             moneyinof  收费信息
             flag，info,
             moneynameid 收费项目
             summoney 金额
             opusername 操作者
             moneydate 缴费时间
             moneyenddate 缴费截止日期remark 备注

             roominfo  房间信息
             flag||info||chargearea 面积 unitprice 单价 administratesum 月缴额
             额 moneyenddate物业费到期时间 faxnumber 联系方式2 email、loginpassword 登录密码
             remak 备注 WaterBalance 水费余额 ElectricBalance 电费余额  ResidentType 房间类型
             （housename 房间名 houseid 帐号 roominfo已经有值）
             *
             * **/


            //查看缓存中有
            String cache = SharedPfTools.queryStr(ResTools.getStr(R.string.allinfo));
            if(cache!=null){
                //解析结果
                parseResult(cache);
            }
            //获取用户的信息
            UserInfo userInfo = DataTools.getUserInfo();

            //判断用户是否拥有多间房间
            //获取用户的id
            String houseid = userInfo.getHouse_id();
            String housename = userInfo.getHouse_name();
            //判断是不是多房间的用户
            String[] house_id;
            String[] house_name;

            if (DataTools.isHaveIn("@", houseid)) {
                house_id = houseid.split("@");
                house_name = houseid.split("\\|");
                //是多房间
                isMroeHouse = true;
            } else {
                house_id = new String[]{houseid};
                house_name = new String[]{housename};
                //不是多房间
                isMroeHouse = false;
            }

            //最终过滤出的id
            String[] last_houseid = house_id[0].split("\\|");


            //设置请求的参数的值
            String pValues[] = {last_houseid[0], last_houseid[1], last_houseid[2],
                    last_houseid[3], last_houseid[0] + last_houseid[1] + last_houseid[2] + last_houseid
                    [3], "roominfo"};


            //生成请求的参数
            RequestParams param = HttpTools.getParam(ResTools.getArr(R.array.allinfos_keys), pValues);

            //请求工具
            NewFetchDao dao = new NewFetchDao(MyHttpUrl.ALLINFO, param, new NewFetchDao.IHttpListenner() {
                @Override
                public void success(String r) {
                    LogUtil.e("allinfo", r);
                    //将数据存储到本地
                    SharedPfTools.insertData(ResTools.getStr(R.string.allinfo),r);

                    //解析结果
                    parseResult(r);
                }

                @Override
                public void fail(String arg1) {
                    SystemTools.fail("请求信息失败");
                    v.onDataFail();
                }
            });

            //发送请求
            dao.fetch();
        } catch (Exception e) {
            SystemTools.fail("请求全部信息异常");
        }
    }

    /**解析结果***/
    private void parseResult(String cache) {
        UserAllInfo userallinfo=new Gson().fromJson(DataTools.getJsonObj(cache),UserAllInfo.class);
        v.onInfoSuccess(userallinfo);
    }
}
