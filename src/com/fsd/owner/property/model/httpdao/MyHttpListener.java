package com.fsd.owner.property.model.httpdao;

/**
 * MyHttpListener
 * @author zxh
 * 网络请求的回调
 */
public abstract class MyHttpListener {
	/**网络请求成功返回的数据**/
	abstract public void onFinish(String result);
	/**网络请求成功失败的数据**/
	abstract public void onFail(String result);
	/**网络正在请求时的操作**/
	public void onStart(){}
	/**网络正在请求时的操作**/
	public void onLoading(long total, long current, boolean isUploading){};
}
