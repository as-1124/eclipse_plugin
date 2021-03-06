package com.primeton.mobile.wechat.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.primeton.mobile.wechat.model.IWechatModel;

/**
 * 微信用户模型.
 * 
 * @author huangjw(mailto:huangjw@primeton.com)
 *
 */
/**
 * @author huangjw(mailto:huangjw@primeton.com)
 *
 */
@JSONType
public class WechatUserInfo implements IWechatModel{

	/**
	 * 是否订阅该公众号，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	 */
	@JSONField
	int subscribe;
	
	/**
	 * 用户微信号的对外标识，对当前公众号唯一
	 */
	@JSONField
	String openid;
	
	/**
	 * 用户昵称
	 */
	@JSONField
	String nickname;
	
	/**
	 * 性别
	 * <li>1 代表男性
	 * <li>2 代表女性
	 * <li>0 代表未知
	 */
	@JSONField
	int sex;
	
	/**
	 * 语言
	 */
	@JSONField
	String language;
	
	/**
	 * 用户所在城市
	 */
	@JSONField
	String city;
	
	/**
	 * 省份
	 */
	@JSONField
	String province;
	
	/**
	 * 国家
	 */
	@JSONField
	String country;
	
	/**
	 * 用户头像url
	 */
	@JSONField
	String headimgurl;
	
	/**
	 * 用户关注时间，是一个时间戳。如果曾多次关注，则取最后的关注时间
	 */
	@JSONField
	String subscrible_time;
	
	/**
	 * 只有在用户将公众号绑定到微信开放平台后，才会出现该字段
	 */
	@JSONField
	String unionid;
	
	/**
	 * 公众号运营者对粉丝的备注
	 */
	@JSONField
	String remark;
	
	/**
	 * 用户所在的分组ID
	 */
	@JSONField
	int groupid;
	
	public WechatUserInfo(){
		
	}
	
	/**
	 * @see #subscribe
	 * @return
	 */
	public int getSubscribe() {
		return subscribe;
	}

	/**
	 * @see #subscribe
	 */
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}

	/**
	 * @see #openid
	 * @return
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @see #openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @see #nickname
	 * @return
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @see #nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @see #sex
	 * @return
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @see #sex
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @see #language
	 * @return
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @see #language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @see #city
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @see #city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @see #province
	 * @return
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @see #province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @see #country
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @see #country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @see #headimgurl
	 * @return
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}

	/**
	 * @see #headimgurl
	 * @param headimgurl
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	/**
	 * @see #subscrible_time
	 * @return
	 */
	public String getSubscrible_time() {
		return subscrible_time;
	}

	/**
	 * @see #subscrible_time
	 */
	public void setSubscrible_time(String subscrible_time) {
		this.subscrible_time = subscrible_time;
	}

	/**
	 * @see #unionid
	 * @return
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @see #unionid
	 * @return
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * @see #remark
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @see #remark
	 * @return
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @see #groupid
	 * @return
	 */
	public int getGroupid() {
		return groupid;
	}

	/**
	 * @see #groupid
	 * @return
	 */
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
}