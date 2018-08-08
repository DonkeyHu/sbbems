package com.donkey.system.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface IUserService {
    
	/**
	 * 更新用户图片
	 * 
	 * @param file
	 * @param clipData 裁剪数据
	 * @param userId
	 * @return
	 * @throws IOException 
	 */
	Map<String,Object> updatePersonImg(MultipartFile file, String clipData, Long userId) throws IOException;
}
