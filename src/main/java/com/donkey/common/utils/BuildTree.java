package com.donkey.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.donkey.common.model.TreeDO;

public class BuildTree {
	
	public static<T> TreeDO<T> build(List<TreeDO<T>> nodes) {
		if(nodes == null) {
			return null;
		}
		
		List<TreeDO<T>> topNodes = new ArrayList<>();
		
		for (TreeDO<T> children : topNodes) {
			String pId = children.getParentId();
			if(pId ==null || "0".equals(pId)) {
				topNodes.add(children);
				continue;
			}
			
			for (TreeDO<T> parent : topNodes) {
				String id = parent.getId();
				if(id != null && id.equals(pId)) {
					parent.getChildren().add(children);
					parent.setHasChildren(true);
					children.setHasParent(true);
					continue;
				}
			}
		}
		
		TreeDO<T> root = new TreeDO<>();
		if(topNodes.size()==1) {
			root = topNodes.get(0);
		}else {
			root.setId("-1");
			root.setParentId("");
			root.setHasParent(false);
			root.setHasChildren(true);
			root.setChecked(true);
			root.setChildren(topNodes);
			root.setText("顶级节点");
			Map<String, Object> state = new HashMap<>(16);
			state.put("opened", true);
			root.setState(state);
		}
		return root;
	}
}
