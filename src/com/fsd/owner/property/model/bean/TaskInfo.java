package com.fsd.owner.property.model.bean;

/***
 * 
 * 
 * TaskInfo
 * @author zxh
 * 派工信息
 *
 */
public class TaskInfo {
	private String id;//id
	private String pressstate;//状态
	private String content;//内容
	private String ComplainDate;//时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPressstate() {
		return pressstate;
	}
	public void setPressstate(String pressstate) {
		this.pressstate = pressstate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComplainDate() {
		return ComplainDate;
	}
	public void setComplainDate(String complainDate) {
		ComplainDate = complainDate;
	}
	
}
