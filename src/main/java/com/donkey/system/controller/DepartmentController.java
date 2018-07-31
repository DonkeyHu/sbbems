package com.donkey.system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.donkey.common.config.Constant;
import com.donkey.common.model.TreeDO;
import com.donkey.common.utils.BaseResponse;
import com.donkey.system.model.DepartmentDO;
import com.donkey.system.service.IDepartmentService;

/**
 * @Description: 部门管理
 *
 * @author: DonkeyHu
 * @date: 2018-07-27 11:56
 */
@Controller
@RequestMapping("/system/sysDept")
public class DepartmentController {
	private static String PREFIX = "system/dept";
	
	@Autowired
	private IDepartmentService departmentService;
	
	@GetMapping()
	String dept() {
		return PREFIX + "/dept";
	}
	
	/**
	 * 获取所有部门 
	 */
	@GetMapping("/list")
	@ResponseBody
	public List<DepartmentDO> listAll() {
		return departmentService.listAll();
	}
	
	/**
	 * 点击"ADD"按钮
	 * @param pId
	 * @param model
	 * @return
	 */
	@GetMapping("/add/{deptId}")
	public String add(@PathVariable("deptId") Long deptId,Model model) {
		model.addAttribute("deptId", deptId);
		if(deptId == 0) {
			model.addAttribute("dName", "总部门");
		}else {
			model.addAttribute("dName", departmentService.get(deptId));
		}
		return PREFIX + "/add";
	}
	/**
	 * 点击"EDIT"按钮
	 * @param deptId
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{deptId}")
	public String edit(@PathVariable("deptId") Long deptId,Model model) {
		DepartmentDO dept = departmentService.get(deptId);
		model.addAttribute("sysDept", dept);
		if(Constant.DEPT_ROOT_ID.equals(dept.getParentId())) {
			model.addAttribute("parentDept", "无");
		} else {
			model.addAttribute("parentDept", departmentService.get(dept.getParentId()).getName());
		}
		return PREFIX + "/edit";
	}
	
	/**
	 * 创建新部门
	 * @param sysDept
	 * @return
	 */
	@PostMapping("/save")
	@ResponseBody
	public BaseResponse save(DepartmentDO sysDept) {
		if(departmentService.save(sysDept)>0) {
			return BaseResponse.ok();
		}
		return BaseResponse.error();
	}
	
	@PostMapping("/update")
	@ResponseBody
	public BaseResponse update(DepartmentDO sysDept) {
		if(departmentService.update(sysDept)>0) {
			return BaseResponse.ok();
		}
		return BaseResponse.error();
	}
	
	@PostMapping("/delete/{deptId}")
	@ResponseBody
	public BaseResponse remove(@PathVariable("deptId") Long deptId) {
		if(departmentService.count(deptId)>0) {
			return BaseResponse.error(1,"包含子部门，不允许删除");
		}
		if(departmentService.remove(deptId)>0) {
			return BaseResponse.ok();
		}
		return BaseResponse.error(); 
	}
	
	@GetMapping("/tree")
	@ResponseBody
	public TreeDO<DepartmentDO> tree(){
		return departmentService.getTree();
	}
	
}
