package com.primeton.mobile.wechat.model.media;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.primeton.mobile.wechat.model.IWechatModel;

/**
 * 素材数量描述模型(image/voice/video)
 * 
 * @author huangjw(mailto:huangjw@primeton.com)
 *
 */
@JSONType
public class WechatMediaList implements IWechatModel{

	/**
	 * 该类型的素材的总数 
	 */
	@JSONField
	int total_count;
	
	/**
	 * 本次调用获取的素材的数量
	 */
	@JSONField
	int item_count;
	
	/**
	 * 素材列表
	 */
	@JSONField
	List<WechatMedia> item;
	
	public WechatMediaList() {
	}

	/**
	 * @see #total_count
	 * @return
	 */
	public int getTotal_count() {
		return total_count;
	}

	/**
	 * @see #total_count
	 * @param total_count
	 */
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	/**
	 * @see #item_count
	 * @return
	 */
	public int getItem_count() {
		return item_count;
	}

	/**
	 * @see #item_count
	 * @param item_count
	 */
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	/**
	 * @see #item
	 * @return
	 */
	public List<WechatMedia> getItem() {
		return item;
	}

	/**
	 * @see #item
	 * @param item
	 */
	public void setItem(List<WechatMedia> item) {
		this.item = item;
	}
	
}
