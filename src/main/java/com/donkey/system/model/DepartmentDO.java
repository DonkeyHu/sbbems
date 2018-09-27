package com.donkey.system.model;

import java.io.Serializable;

/**
 * @Description: 部门实体类
 *
 * @author: DonkeyHu
 * @date: 2018-07-27 11:56
 */
public class DepartmentDO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long deptId;
	// 上级部门ID，一级部门为0
	private Long parentId;
	private String name;
	private Integer orderNum;
	// 部门状态： 1：表示已删除 ，0：表示正常
	private Integer delFlag;

	public DepartmentDO() {
		super();
	}

	public DepartmentDO(Long deptId, Long parentId, String name, Integer orderNum, Integer delFlag) {
		super();
		this.deptId = deptId;
		this.parentId = parentId;
		this.name = name;
		this.orderNum = orderNum;
		this.delFlag = delFlag;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

}
