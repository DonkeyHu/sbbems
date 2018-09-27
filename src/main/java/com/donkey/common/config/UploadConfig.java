package com.donkey.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 文件上传路径配置 
 *
 * @author: DonkeyHu
 * @date: 2018-08-08 13:57
 */
@Component
@ConfigurationProperties(prefix="donkeydo")
public class UploadConfig {
	
	private String uploadPath;

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
}
