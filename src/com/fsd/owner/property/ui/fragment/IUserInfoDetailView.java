package com.fsd.owner.property.ui.fragment;

import com.fsd.owner.property.model.bean.UserAllInfo;

/**
 * Created by zxh on 2016/2/23.
 */
public interface IUserInfoDetailView {
    void onInfoSuccess(UserAllInfo userallinfo);

    void onDataFail();
}
