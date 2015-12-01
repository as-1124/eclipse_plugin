package com.primeton.mobile.wechat.model;

import java.io.IOException;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.primeton.mobile.wechat.CommonOperations;
import com.primeton.mobile.wechat.exception.WechatExceprion;

/**
 * 微信接口调用时的票据对象（access_token）.
 * 
 * @author huangjw(mailto:huangjw@primeton.com)
 *
 */
@JSONType
public class AccessToken implements IWechatModel{
	
	private static AccessToken instance = new AccessToken();
	
	/**
	 * 获取的凭证
	 */
	@JSONField
	private String access_token = null;
	
	/**
	 * 有效时间，单位：秒
	 */
	@JSONField
	private long expires_in = 0;
	
	/**
	 * 时间戳，记录凭证的创建时间
	 */
	private long createTime = 0;
	
	/**
	 * 请使用AccessToken#getInstance方法来实现token过期时系统的平滑过渡
	 * 
	 * @see AccessToken#getInstance(String, String)
	 */
	public AccessToken() {
		
	}

	/**
	 * {@link AccessToken#access_token}
	 * @return
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * {@link AccessToken#access_token}
	 * @param access_token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 获取的是当前access_token的有效时间而不是access_token的剩余时间。
	 * 这个有效时常是创建时从微信官方获取的。
	 * {@link AccessToken#expires_in}
	 * @see #isExpired()
	 * @return
	 */
	public long getExpires_in() {
		return expires_in;
	}

	/**
	 * {@link AccessToken#expires_in}
	 * @param expires_in
	 */
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * {@link AccessToken#createTime}
	 * @return
	 */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * {@link AccessToken#createTime}
	 * @param createTime
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 获取当前access_token是失效
	 * @return <code>true</code> 失效，<code>false</code> 有效
	 */
	public boolean isExpired(){
		if(this.createTime == 0)
			return true;
		long differ = System.currentTimeMillis() - this.createTime;
		long seconds = differ/6000;
		return (seconds >= this.expires_in);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AccessToken){
			return this.access_token.equals(((AccessToken)obj).getAccess_token());
		}
		else return false;
	}
	
	public static AccessToken getInstance(String appID, String appSecret) throws IOException, WechatExceprion{
		if(instance == null || instance.isExpired())
			instance = CommonOperations.getAccessToken(appID, appSecret);
		return instance;
	}
}
