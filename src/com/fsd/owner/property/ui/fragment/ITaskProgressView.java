package com.fsd.owner.property.ui.fragment;

import com.fsd.owner.property.model.bean.TaskProgress;

import java.util.List;

public interface ITaskProgressView {

    void onDataSuccess(List<TaskProgress> progress, boolean b);
}
