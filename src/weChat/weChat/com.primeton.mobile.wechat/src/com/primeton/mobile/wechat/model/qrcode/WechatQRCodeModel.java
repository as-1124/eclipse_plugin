package com.primeton.mobile.wechat.model.qrcode;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.primeton.mobile.wechat.model.IWechatModel;


/**
 * 微信二维码模型
 * 
 * @author huangjw(mailto:huangjw@primeton.com)
 *
 */
@JSONType
public class WechatQRCodeModel implements IWechatModel {

	/**
	 * 永久二维码
	 * @see #getAction_name()
	 */
	public static final String QR_IMAGE_FOREVER = "QR_LIMIT_SCENE";
	
	/**
	 * 临时二维码
	 * @see #getAction_name()
	 */
	public static final String QR_IMAGE_TEMPORARY = "QR_SCENE";
	
	/**
	 * 永久字符串二维码
	 * @see #getAction_name()
	 */
	public static final String QR_STR_FOREVER = "QR_LIMIT_STR_SCENE";
	
	/**
	 * 临时二维码有效时间，以秒为单位。 最大不超过604800（即7天）。 
	 */
	@JSONField
	int expire_secondes;
	
	/**
	 * 二维码类型
	 */
	@JSONField
	String action_name;
	
	/**
	 * 二维码详细信息
	 */
	@JSONField
	String action_info;
	
	/**
	 * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 */
	@JSONField
	int scene_id;
	
	/**
	 * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64，<strong>仅永久二维码支持此字段</strong>
	 */
	@JSONField
	String scene_str;

	/**
	 * 接口调用后创建后获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	 */
	@JSONField
	String ticket;
	
	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 */
	@JSONField
	String url;
	
	public WechatQRCodeModel() {
	}
	
	/**
	 * @see #expire_secondes
	 * @return
	 */
	public int getExpire_secondes() {
		return expire_secondes;
	}

	/**
	 * @see #expire_secondes
	 */
	public void setExpire_secondes(int expire_secondes) {
		this.expire_secondes = expire_secondes;
	}

	/**
	 * @see #action_name
	 * @see #QR_IMAGE_FOREVER
	 * @see #QR_IMAGE_TEMPORARY
	 * @see #QR_STR_FOREVER
	 * @return
	 */
	public String getAction_name() {
		return action_name;
	}

	/**
	 * @see #action_name
	 * @param action_name
	 */
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	/**
	 * @see #action_info
	 * @return
	 */
	public String getAction_info() {
		return action_info;
	}

	/**
	 * @see #action_info
	 */
	public void setAction_info(String action_info) {
		this.action_info = action_info;
	}

	/**
	 * @see #scene_id
	 * @return
	 */
	public int getScene_id() {
		return scene_id;
	}

	/**
	 * @see #scene_id
	 */
	public void setScene_id(int scene_id) {
		this.scene_id = scene_id;
	}

	/**
	 * @see #scene_str
	 * @return
	 */
	public String getScene_str() {
		return scene_str;
	}

	/**
	 * @see #scene_str
	 * @return
	 */
	public void setScene_str(String scene_str) {
		this.scene_str = scene_str;
	}

	/**
	 * @see #ticket
	 * @return
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * @see #ticket
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * @see #url
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @see #url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
}
