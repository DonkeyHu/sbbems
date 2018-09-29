package com.donkey.common.utils;

import java.io.Serializable;
import java.util.List;

public class PageUtil implements Serializable{
	private static final long serialVersionUID = 1L;
	// 总共记录数
	private int total;
	private List<?> list;
	
	public PageUtil() {
		super();
	}
	public PageUtil(int total, List<?> list) {
		super();
		this.total = total;
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
}
