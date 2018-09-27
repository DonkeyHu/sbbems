package com.donkey.system.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.donkey.common.utils.BaseResponse;
import com.donkey.system.service.IUserService;

/**
 *
 * @author: DonkeyHu
 * @date: 2018-08-08 10:28
 */
public class UserController {
	private String PREFIX = "sys/user";
	@Autowired
	private IUserService userServiceImpl;
	@GetMapping
	String user(Model mode) {
		return PREFIX + "/user";
	}
	
	
	BaseResponse updateImg(@RequestParam("avartar_file")MultipartFile file,String clipData) {
		Map<String, Object> map = new HashMap<>();
		try {
			map = userServiceImpl.updatePersonImg(file, clipData, 1l);
		} catch (IOException e) {
			return BaseResponse.error("更新图片失败");
		}
		if(map != null && map.size() > 0) {
			return BaseResponse.ok(map);
		}else {
			return BaseResponse.error("更新图片失败");
		}
	}
	
}
