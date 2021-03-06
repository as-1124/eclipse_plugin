package com.primeton.mobile.wechat.model.media;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

/**
 * 新闻素材列表（news）
 * 
 * @author huangjw(mailto:huangjw@primeton.com)
 *
 */
@JSONType
public class WechatNewsList {
	
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
	
	@JSONField
	List<WechatNews> item;
	
	public WechatNewsList() {
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getItem_count() {
		return item_count;
	}

	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}

	public List<WechatNews> getItem() {
		return item;
	}

	public void setItem(List<WechatNews> item) {
		this.item = item;
	}
	
	/**
	 * 因为获取图文素材返回的内容(content)是一个<code>WechatNews</code>的json数组，
	 * 不同单独新增获取图文素材时的(content)。因此这里提供接口方便用户调用做解析。
	 * @param index index in {@link #item}
	 * @return Map< media_id, List< WechatNews>>
	 * @see {@link http://mp.weixin.qq.com/wiki/12/2108cd7aafff7f388f41f37efa710204.html}
	 */
	public Map<String, List<WechatNews>> parseNewsItem(int index){
		if(this.item == null || this.item.size()<= 0)
			return null;
		String newsItemStr = JSONObject.parseObject(this.item.get(index).getContent()).getString("news_item");
		Map<String, List<WechatNews>> result = new HashMap<String, List<WechatNews>>();
		result.put(this.item.get(index).getMedia_id(), JSONObject.parseArray(newsItemStr, WechatNews.class));
		return result;
	}
}
