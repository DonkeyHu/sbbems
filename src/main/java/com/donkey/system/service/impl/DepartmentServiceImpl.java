package com.donkey.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donkey.common.model.TreeDO;
import com.donkey.common.utils.BuildTree;
import com.donkey.system.dao.IDepartmentDao;
import com.donkey.system.model.DepartmentDO;
import com.donkey.system.service.IDepartmentService;

/**
 * @Description:部门接口实现类 
 *
 * @author: DonkeyHu
 * @date: 2018-07-27 13:22
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService{
	
	@Autowired
	private IDepartmentDao departmentDao;
	
	@Override
	public List<DepartmentDO> listAll() {
		Map<String,Object> map = new HashMap<>();
		return departmentDao.listAll(map);
	}

	@Override
	public DepartmentDO get(Long deptId) {
		return departmentDao.get(deptId);
	}

	@Override
	public int save(DepartmentDO dept) {
		return departmentDao.save(dept);
	}

	@Override
	public int update(DepartmentDO dept) {
		return departmentDao.update(dept);
	}

	@Override
	public int count(Long deptId) {
		return departmentDao.count(deptId);
	}

	@Override
	public int remove(Long deptId) {
		return departmentDao.remove(deptId);
	}

	@Override
	public TreeDO<DepartmentDO> getTree() {
		List<DepartmentDO> lists = departmentDao.listAll(new HashMap<String,Object>(16));
		List<TreeDO<DepartmentDO>> nodes = new ArrayList<>();
		
		for (DepartmentDO departmentDO : lists) {
			TreeDO<DepartmentDO> tree = new TreeDO<>();
			tree.setId(departmentDO.getDeptId().toString());
			tree.setText(departmentDO.getName());
			tree.setParentId(departmentDO.getParentId().toString());
			Map<String,Object> map = new HashMap<>(16);
			map.put("open", true);
			tree.setState(map);
			nodes.add(tree);
		}
		
		TreeDO<DepartmentDO> build = BuildTree.build(nodes);
		return build;
	}
	
}
