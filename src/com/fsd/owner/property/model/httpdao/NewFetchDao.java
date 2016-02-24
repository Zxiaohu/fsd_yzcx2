package com.fsd.owner.property.model.httpdao;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/****
 * 改进网络请求的封装
 * @author zxh
 * 修改了对网络请求的封装
 */
public class NewFetchDao extends RequestCallBack<String>{
	
	private String mURL;//地址
	private RequestParams mParams;//请求的参数
	
	private IHttpListenner listenner;
	
	public NewFetchDao(String mURL,RequestParams mParams,IHttpListenner listenner) {
		this.mURL = mURL;
		this.mParams = mParams;
		this.listenner=listenner;
	}



	/**网络请求**/
	public void fetch(){
		HttpUtils httpUtils = new HttpUtils(6*3000);
		
		httpUtils.send(HttpMethod.POST, mURL, mParams,this);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

	}
	
	@Override
	public void onCancelled() {
		// TODO Auto-generated method stub
		super.onCancelled();
	
	}
	
	@Override
	public void onLoading(long total, long current, boolean isUploading) {
		// TODO Auto-generated method stub
		super.onLoading(total, current, isUploading);

	}
	@Override
	public void onFailure(HttpException arg0, String arg1) {
		// TODO Auto-generated method stub

		listenner.fail(arg1);
	}

	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub

		listenner.success(arg0.result.toString());
	}
	
	/**网络请求完毕后的接口**/
	public interface IHttpListenner{
		void success(String r);
		void fail(String arg1);
	}
}
