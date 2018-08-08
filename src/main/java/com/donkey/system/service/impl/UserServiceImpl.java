package com.donkey.system.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.donkey.common.config.UploadConfig;
import com.donkey.common.model.FileDO;
import com.donkey.common.model.FileType;
import com.donkey.common.utils.FileUtil;
import com.donkey.common.utils.ImageUtil;
import com.donkey.system.service.IUserService;

public class UserServiceImpl implements IUserService{
	@Autowired
	private UploadConfig uploadConfig;

	@Override
	public Map<String, Object> updatePersonImg(MultipartFile file, String clipData, Long userId) throws IOException {
		String iniFileName = file.getOriginalFilename();
		String fileName = FileUtil.renameToUUID(iniFileName);
		String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
		FileDO fileDO = new FileDO(FileType.fileType(fileName),"/files/" + fileName, new Date());
		// 剪切图片的数据
		String[] str = clipData.split(",");
		// 截图x坐标
		int x =(int)Math.floor(Double.parseDouble(str[0].split(":")[1]));
		// 截图y坐标
		int y =(int)Math.floor(Double.parseDouble(str[1].split(":")[1]));
		// 截图height坐标
		int height =(int)Math.floor(Double.parseDouble(str[2].split(":")[1]));
		// 截图width坐标
		int width =(int)Math.floor(Double.parseDouble(str[3].split(":")[1]));
		// 截图rotate坐标
		int rotate =(int)Math.floor(Double.parseDouble(str[4].split(":")[1].replaceAll("}", "")));
		
		BufferedImage cutImage = ImageUtil.cutImage(file, x, y, width, height, fileType);
		BufferedImage rotateImage = ImageUtil.rotateImage(cutImage, rotate);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		boolean flag = ImageIO.write(rotateImage, fileType, out);
		byte[] byteArray = out.toByteArray();
		FileUtil.uploadFile(byteArray, uploadConfig.getUploadPath(), fileName);
		
		return null;
	}
	
}