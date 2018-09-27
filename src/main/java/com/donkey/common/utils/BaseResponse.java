package com.donkey.common.utils;

import java.util.HashMap;
import java.util.Map;

public class BaseResponse extends HashMap<String, Object>{
	
	private static final long serialVersionUID = 1L;

	public BaseResponse() {
		put("code",0);
		put("msg","操作成功");
	}
	
	public static BaseResponse ok() {
		BaseResponse br = new BaseResponse();
		return br;
	}
	
	public static BaseResponse ok(Map<String,Object> map) {
		BaseResponse br = new BaseResponse();
		br.putAll(map);
		return br;
	}
	
	public static BaseResponse error() {
		return error(1,"操作失败");
	}
	
	public static BaseResponse error(String msg) {
		return error(500,msg);
	}
	
	public static BaseResponse error(int code,String msg) {
		BaseResponse br = new BaseResponse();
		br.put("code", code);
		br.put("msg", msg);
		return br;
	}
}
