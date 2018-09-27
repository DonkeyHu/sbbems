package com.donkey.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 
 *
 * @author: DonkeyHu
 * @date: 2018-08-08 11:29
 */
public class FileDO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	// 文件类型用数字代替, 0代表图片类型文件,1代表文档类型文件,2代表视频类型文件,3代表音乐类型文件
	private Integer type;
	private String url;
	private Date createDate;
	
	public FileDO() {
		super();
	}
	
	public FileDO(Integer type, String url, Date createDate) {
		super();
		this.type = type;
		this.url = url;
		this.createDate = createDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
