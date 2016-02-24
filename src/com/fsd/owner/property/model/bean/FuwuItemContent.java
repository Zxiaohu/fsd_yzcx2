package com.fsd.owner.property.model.bean;

import java.util.List;

/****
 * FuwuItemContent
 * @author zxh
 * 服务项的实体类
 * 2016年2月17日15:40:07
 */
public class FuwuItemContent{
	
	public List<FuwuItem> fuwu_items;
	
	public class FuwuItem{
		public String id;
		public String name;
		public FuwuItem(String id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
	}
}
