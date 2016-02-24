package com.fsd.owner.property.model.httpdao;

import android.app.ProgressDialog;
import android.content.Context;

import com.fsd.owner.property.tools.SystemTools;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * SFetchInfoDao
 * @author zxh
 * 从服务器获取信息的抽象类
 */
public abstract class SFetchInfoDao extends RequestCallBack<String>{
	
	protected RequestParams commParams;
	
	/***设置context**/
	private Context mContext;
	
	/**xutils的请求工具类**/
	private HttpUtils mHttpUtils;
	
	/**网络请求的参数**/
	private RequestParams mParams;
	
	/**网络请求的URL**/
	private String mUrl;
	
	/**是否显示dialog**/
	private boolean isShowDialog=false;

	/**进度对话框**/
	private ProgressDialog progressDialog;
	
	/**设置请求的参数**/
	abstract public RequestParams setRequestParams();
	
	/**设置请求的Url**/
	abstract public String setRequestUrl();
	
	
	/**设置是否显示对话框**/
	public SFetchInfoDao setShowDialog(boolean isShowDialog,Context context){
		this.mContext = context;
		this.isShowDialog = isShowDialog;
		return this;
	}
	

	/**发送网络请求（请求的方法默认为post）**/
	public void sendHttp(){
		//如果是true的话就显示
		if(isShowDialog){
			progressDialog = new ProgressDialog(mContext);
			progressDialog.setMessage("数据加载中....");
		}
		
		/**请求工具**/
		mHttpUtils = new HttpUtils(6*300);
		
		/**请求的地址**/
		mUrl =setRequestUrl();
		
		/**请求参数**/
		mParams = setRequestParams();
		
		/**发送请求，设置回调**/
		mHttpUtils.send(HttpMethod.POST,mUrl,mParams,this);
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if(isShowDialog){//显示对话框
			progressDialog.show();
		}
	}
	@Override
	public void onLoading(long total, long current, boolean isUploading) {
		// TODO Auto-generated method stub
		super.onLoading(total, current, isUploading);
		if(isShowDialog){//显示对话框
			progressDialog.show();
		}
	}
	@Override
	public void onSuccess(ResponseInfo<String> arg0) {
		// TODO Auto-generated method stub
		if(isShowDialog){//隐藏对话框
			progressDialog.dismiss();
		}
	}
	@Override
	public void onFailure(HttpException arg0, String arg1) {
		// TODO Auto-generated method stub
		if(isShowDialog){//隐藏对话框
			progressDialog.dismiss();
		}
		SystemTools.fail("网络请求失败"+arg1);
	}

}
