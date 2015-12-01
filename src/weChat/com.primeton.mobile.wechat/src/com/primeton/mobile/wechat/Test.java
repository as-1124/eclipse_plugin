package com.primeton.mobile.wechat;

import java.io.IOException;

import com.primeton.mobile.wechat.exception.WechatExceprion;
import com.primeton.mobile.wechat.model.AccessToken;

public class Test {

	public static void main(String[] args) throws IOException, WechatExceprion {
		//
		String appID = "wxc70c5d9aab4f6a2b";
		String secret = "f3ca23ccf76c301f2158862db65cfdad";
		AccessToken token = AccessToken.getInstance(appID, secret);//CommonOperations.getAccessToken(appID, secret);
		String tokenStr = token.getAccess_token();
		System.out.println(tokenStr);
	}

}
