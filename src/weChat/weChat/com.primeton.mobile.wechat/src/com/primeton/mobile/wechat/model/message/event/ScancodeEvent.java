package com.primeton.mobile.wechat.model.message.event;

import java.io.ByteArrayInputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.primeton.mobile.wechat.model.message.AbstractMessage;

/**
 * 扫描带参数二维码事件
 * 
 * <li>如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
 * 此时<code>getEvent() = "subscribe"</code>
 * <li>如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
 * 此时<code>getEvent() = "SCAN"</code>
 * 
 * @author huangjw(mailto:huangjw@primeton.com)
 */
public class ScancodeEvent extends AbstractEvent {

	/**
	 * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	 */
	protected String eventKey;
	
	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	protected String ticket;

	public ScancodeEvent() {
		super();
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
		 +"<Event><![CDATA["+getEvent()+"]]></Event>"
		 +"<EventKey><![CDATA["+getEventKey()+"]]></EventKey>"
		 +"<Ticket><![CDATA["+getTicket()+"]]></Ticket></xml>";
		return result;
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
			this.setEvent(root.element("Event").getText());
			this.setEventKey(root.element("EventKey").getText());
			this.setTicket(root.element("Ticket").getText());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * 
	 * @param eventKey
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * 获取二维码的ticket
	 * @return
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * 
	 * @param ticket
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
}
