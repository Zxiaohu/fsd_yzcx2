package com.fsd.owner.property.model.bean;

/**
 * Created by zxh on 2016/2/19.
 */
public class TaskProgress {
    //   TaskProgress paigongrate.asp  派工进度
//    {"id" : "48" , "complainid" : "23" , "remark" : "赵小虎 提交一条派工信息请尽快处理 " , "logindate" : "2016-2-18 13:42:51"
//    json remark进度描述 logindate 时间
    private String id;
    private String complainid;
    private String remark;
    private String logindate;


    public String getRemark() {
        return remark;
    }
    public String getComplainid() {
        return complainid;
    }

    public void setComplainid(String complainid) {
        this.complainid = complainid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }
}
