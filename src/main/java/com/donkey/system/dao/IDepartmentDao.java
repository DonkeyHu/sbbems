package com.donkey.system.dao;

import java.util.List;
import java.util.Map;

import com.donkey.system.model.DepartmentDO;

public interface IDepartmentDao {
	
	List<DepartmentDO> listAll(Map<String,Object> map);
	
	DepartmentDO get(Long deptId);
	
	int save(DepartmentDO dept);
	
	int update(DepartmentDO dept);
	
	int count(Long deptId);
	
	int remove(Long deptId);
}
