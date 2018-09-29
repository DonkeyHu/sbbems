package com.donkey.system.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.donkey.common.utils.BaseResponse;
import com.donkey.common.utils.PageUtil;
import com.donkey.common.utils.Query;
import com.donkey.system.model.UserDO;
import com.donkey.system.service.IUserService;

/**
 *
 * @author: DonkeyHu
 * @date: 2018-08-08 10:28
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {
	private String PREFIX = "sys/user";
	@Autowired
	private IUserService userServiceImpl;
	@GetMapping
	String user(Model mode) {
		return PREFIX + "/user";
	}
	@GetMapping("/list")
	PageUtil list(Map<String,Object> param) {
		Query query = new Query(param);
		List<UserDO> list = userServiceImpl.list(query);
		int count = userServiceImpl.count(query);
		PageUtil pageUtil = new PageUtil(count,list);
		return pageUtil;
	}
	
	@PostMapping("/updateImg")
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
