package com.fsd.owner.property.global;



/**网络请求的地址**/
public class MyHttpUrl {
	
	public static final String URL_YZ = "http://www.fusaide.com/aspapp/yzcx/";
	public static final String URL = "http://www.fusaide.com/aspapp/wygl/";
	public static final String PHOTO_URL="http://www.fusaide.com/aspapp/upload/";
	
	public static final String ROOT = "?sys=android";
	public static final String APP_LOGIN = URL_YZ +"applogin.asp" + ROOT;// 房号注册
	public static final String LOGIN = URL_YZ + "login.asp" + ROOT;// 普通登录
	public static final String SEND_MSG = URL_YZ + "sendmsg.asp" + ROOT;// 发送短信
	public static final String PING_JIA = URL_YZ + "pingjia.asp" + ROOT;// 发送短信

	public static final String  USER_INFO=URL_YZ+"userinfo.asp"+ROOT;//用户信息
	//上传图片
	public static final String  UPLOAD=URL+"upload.asp"+ROOT;

	public static final String NOTICE = URL + "notice.asp" + ROOT;// 公告
	// 获取管理项的URL
	public static final String PRECINCT = URL + "precinct.asp" + ROOT;
	// 获取收费项的URL
	public static final String MONEYNAME = URL + "moneyname.asp" + ROOT;

	//查询物业费截止日期
	public static final String MONEYENDDATE = URL + "moneyenddate.asp" + ROOT;

	//查询水电费余额
	public static final String BALANCE = URL + "balance.asp" + ROOT;

	//请求收款方式的URL
	public static final String MONEYTYPE = URL + "moneytype.asp" + ROOT;

	//请求票据列表的URL
	public static final String BILL = URL + "bill.asp" + ROOT;

	//请求银行账户的URL
	public static final String BANKACCOUNT = URL + "bankaccount.asp" + ROOT;

	//收费录入
	//public static final String SAVERECORD = "http://192.168.8.32:8080/jsp/rel";

	public static final String SAVERECORD = URL + "saverecord.asp" + ROOT;
	// 查询收费记录的URL
	public static final String REQUESTBYDATE = URL + "requestbydate.asp" + ROOT;
	// 获取大楼项的URL
	public static final String BUILDING = URL + "building.asp" + ROOT;
	// 获取单元楼道的URL
	public static final String FLOOR = URL + "floor.asp" + ROOT;
	// 获取房间号的URL
	public static final String ROOM = URL + "room.asp" + ROOT;

	// 获取用户信息的的URL
	public static final String ROOM_INFO = URL + "roominfo.asp" + ROOT;

	// 诉求记录人的URL
	public static final String RECORDER_APPEAL = URL + "recordman.asp" + ROOT;
	// 诉求时效的URL
	public static final String AGEING_APPEAL = URL + "complainmain.asp" + ROOT
			+ "&catalog=complaintype";
	// 诉求方式的URL
	public static final String MODE_APPEAL = URL + "complainmain.asp" + ROOT
			+ "&catalog=complainform";
	// 保存诉求登记的URL
	public static final String SAVEAPPEAL = URL + "savecomplain.asp" + ROOT;
	//业主信息的URL
	public static final String OWNER_INFO = URL + "roominfo.asp" + ROOT;
	//查询诉求的URL
	public static final String QUERY_APPEAL = URL + "complainlist.asp" + ROOT;

	public static final String PAIGONG_LIST=URL_YZ+"paigonglist.asp"+ROOT;//派工列表
	
	//派工进度
	public static final String PAIGONG_RATE=URL+"paigongrate.asp"+ROOT;
	public static final String PAIGONG_DETAIL=URL+"paigongdetail.asp"+ROOT;
	
	/**
	 * 上传图片
	 */
	public static final String UPLOAD_PICTURE=URL+"upload.asp"+ROOT;

	/**版本信息s**/
	public static final String VERSION = URL + "config.asp" +ROOT+"&configtype=webconfig";
	
	/**配置信息**/
	public static final String CONFIG = URL+"config.asp"+ROOT;
	/**派工信息***/
	public static final String PAIGONG = URL_YZ+"paigong.asp"+ROOT+"&submit=ok";
	/**配置信息**/
	public static final String ALLINFO = URL+"allinfo.asp"+ROOT;
}
