package com.fsd.owner.property.ui.fragment;

public interface IPGView {

	void setPhoto();

	String getHouseId();

	String getContent();

	String[] getFuWuIds();

	void onSubmitSuccess();

	void setAddress(String houseid, String housename);

	
	//设置选择的照片
	
	//提交完成后的操作
	
	
}
