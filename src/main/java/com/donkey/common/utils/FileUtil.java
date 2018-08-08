package com.donkey.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {
	
	public static void uploadFile(byte[] file,String filePath,String fileName) throws IOException {
		File targetFile = new File(filePath);
		if(!targetFile.exists()) {
			targetFile.mkdirs();
		}
		
		FileOutputStream fos = new FileOutputStream(filePath + fileName);
		fos.write(file);
		fos.flush();
		fos.close();
	}
	
	public static String renameToUUID(String fileName) {
		return UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".")+1);
	}
}
