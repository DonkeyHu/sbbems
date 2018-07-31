package com.donkey.system.service;

import java.util.List;

import com.donkey.common.model.TreeDO;
import com.donkey.system.model.DepartmentDO;

/**
 * @Description:部门接口 
 *
 * @author: DonkeyHu
 * @date: 2018-07-27 13:19
 */
public interface IDepartmentService {
	
	List<DepartmentDO> listAll();
	
	DepartmentDO get(Long deptId);
	
	int save(DepartmentDO dept);
	
	int update(DepartmentDO dept);
	
	int count(Long deptId);
	
	int remove(Long deptId);
	
	TreeDO<DepartmentDO> getTree();
}
