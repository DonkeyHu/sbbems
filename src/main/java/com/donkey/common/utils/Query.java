package com.donkey.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 用于分页查询
 * @author DonkeyHu
 * @date 2018-09-29
 */
public class Query extends LinkedHashMap<String,Object>{
	private static final long serialVersionUID = 1L;
	// 分页
	private int offset;
	private int limit;
	
	public Query(Map<String,Object> map) {
		this.putAll(map);
		
		this.limit = Integer.parseInt(map.get("pageSize").toString());
		this.offset = (Integer.parseInt(map.get("pageNum").toString())-1)*limit;
		this.put("limit", limit);
		this.put("offset", offset);
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
		this.put("offset", offset);
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
		this.put("limit", limit);
	}
}
