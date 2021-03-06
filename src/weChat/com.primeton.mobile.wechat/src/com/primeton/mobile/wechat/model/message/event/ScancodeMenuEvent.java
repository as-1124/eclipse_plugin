package com.primeton.mobile.wechat.model.message.event;

import java.io.ByteArrayInputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 扫码类型按钮触发的事件（公众号菜单）。
 * 
 * @author huangjw(mailto:huangjw@primeton.com)
 *
 */
public class ScancodeMenuEvent extends AbstractMenuEvent {
	
	/**
	 * 扫描类型，一般都是二维码即："qrcode"
	 */
	String scanType;
	
	/**
	 * 扫描结果，即二维码对应的字符串信息
	 */
	String scanResult;
	
	public ScancodeMenuEvent() {
		super();
	}
	
	@Override
	public String toXML() {
		String result = "<xml><ToUserName><![CDATA["+getToUser()+"]]></ToUserName>"
			 +"<FromUserName><![CDATA["+getFromUser()+"]]></FromUserName>"
			 +"<CreateTime>"+getCreateTime()+"</CreateTime>"
			 +"<MsgType><![CDATA["+getMsgType()+"]]></MsgType>"
			 +"<Event><![CDATA["+getEvent()+"]]></Event>"
			 +"<EventKey><![CDATA["+getEventKey()+"]]></EventKey>"
			 +"<ScanCodeInfo><ScanType><![CDATA["+getScanType()+"]]></ScanType>"
			 +"<ScanResult><![CDATA["+getScanResult()+"]]></ScanResult></ScanCodeInfo></xml>";
		return result;
	}
	
	@Override
	public void decodeFromXML(String xmlContent) {
		SAXReader reader = new SAXReader(false);
		try {
			Document document = reader.read(new ByteArrayInputStream(xmlContent.getBytes()));
			Element root = document.getRootElement();
			this.setToUser(root.element("ToUserName").getText());
			this.setFromUser(root.element("FromUserName").getText());
			long createTime = Long.parseLong(root.element("CreateTime").getText());
			this.setCreateTime(createTime);
			this.setEvent(root.element("Event").getText());
			this.setEventKey(root.element("EventKey").getText());
			Element info = root.element("ScanCodeInfo");
			this.setScanType(info.element("ScanType").getText());
			this.setScanResult(info.element("ScanResult").getText());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取扫码时间类型
	 * @see #scanType
	 * @return
	 */
	public String getScanType() {
		return scanType;
	}

	/**
	 * @see #scanType
	 * @param scanType
	 */
	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	/**
	 * 获取扫描结果
	 * @see #scanResult
	 * @return
	 */
	public String getScanResult() {
		return scanResult;
	}

	/**
	 * @see #scanResult
	 * @param scanResult
	 */
	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}
	
}
