package com.fsd.owner.property.ui.fragment;

import com.fsd.owner.property.model.bean.FuwuItemContent.FuwuItem;

public interface IFuwuView {


	void onSubData(String r, FuwuItem fuwuItem);

	void isLoding(boolean b);

	
}
