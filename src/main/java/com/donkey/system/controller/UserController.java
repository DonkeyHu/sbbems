package com.donkey.system.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.donkey.common.utils.BaseResponse;

/**
 *
 * @author: DonkeyHu
 * @date: 2018-08-08 10:28
 */
public class UserController {
	private String PREFIX = "sys/user";
	
	@GetMapping
	String user(Model mode) {
		return PREFIX + "/user";
	}
	
	
	BaseResponse updateImg(@RequestParam("avartar_file")MultipartFile file,String clipData) {
		
		
		return null;
	}
	
}
