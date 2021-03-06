package com.primeton.mobile.wechat.model.message;

import java.io.ByteArrayInputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 地理位置消息
 * @author huangjw(mailto:huangjw@primeton.com)
 *
 */
public class LocationMessage extends AbstractCommonMessage {

	/**
	 * 地理位置纬度
	 */
	protected float locationX;
	
	/**
	 * 地理位置经度
	 */
	protected float locationY;
	
	/**
	 * 地图缩放大小
	 */
	protected int scale;
	
	/**
	 * 地理位置信息
	 */
	protected String label;
	
	public LocationMessage() {
		super();
		this.setMsgType("location");
	}
	
	/**
	 * {@link AbstractMessage#toXML()}
	 * @return
	 */
	public String toXML() {
		String result = "<xml><ToUserName><![CDATA["+getToUser()+"]]></ToUserName>"
		 +"<FromUserName><![CDATA["+getFromUser()+"]]></FromUserName>"
		 +"<CreateTime>"+getCreateTime()+"</CreateTime>"
		 +"<MsgType><![CDATA["+getMsgType()+"]]></MsgType>"
		 +"<Location_X>"+getLocationX()+"</Location_X>"
		 +"<Location_Y>"+getLocationY()+"</Location_Y>"
		 +"<Scale>"+getScale()+"</Scale>"
		 +"<Label><![CDATA["+getLabel()+"]]></Label>"
		 +"<MsgId>"+getMsgID()+"</MsgId></xml>";
		return result;
	}

	@Override
	public String toSendText() {
		return null;
	}
	
	/**
	 * {@link AbstractMessage#decodeFromXML(String)}
	 * @param xmlContent
	 * @return
	 */
	public void decodeFromXML(String xmlContent) {
		SAXReader reader = new SAXReader(false);
		try {
			Document document = reader.read(new ByteArrayInputStream(xmlContent.getBytes()));
			Element root = document.getRootElement();
			this.setToUser(root.element("ToUserName").getText());
			this.setFromUser(root.element("FromUserName").getText());
			long createTime = Long.parseLong(root.element("CreateTime").getText());
			this.setCreateTime(createTime);
			float locationX = Float.parseFloat(root.element("Location_X").getText());
			this.setLocationX(locationX);
			float locationY = Float.parseFloat(root.element("Location_Y").getText());
			this.setLocationY(locationY);
			int scale = Integer.parseInt(root.element("Scale").getText());
			this.setScale(scale);
			this.setLabel(root.element("Label").getText());
			long msgID = Long.parseLong(root.element("MsgId").getText());
			this.setMsgID(msgID);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @see #locationX
	 * @return
	 */
	public float getLocationX() {
		return locationX;
	}
	
	/**
	 * @see #locationX
	 * @param locationX
	 */
	public void setLocationX(float locationX) {
		this.locationX = locationX;
	}
	
	/**
	 * @see #locationY
	 * @return
	 */
	public float getLocationY() {
		return locationY;
	}
	
	/**
	 * @see #locationY
	 * @param locationY
	 */
	public void setLocationY(float locationY) {
		this.locationY = locationY;
	}
	
	/**
	 * @see #scale
	 * @return
	 */
	public int getScale() {
		return scale;
	}
	
	/**
	 * @see #scale
	 * @param scale
	 */
	public void setScale(int scale) {
		this.scale = scale;
	}
	
	/**
	 * @see #label
	 * @return
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * @see #label
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

}
