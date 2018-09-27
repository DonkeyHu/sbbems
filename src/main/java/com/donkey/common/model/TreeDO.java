package com.donkey.common.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 树结构
 * 
 * @author DonkeyHu
 * @date 2018-07-31
 */
public class TreeDO<T> {
	// 节点
	private String id;
	
	private String text;
	
	private boolean hasParent = false;
	
	private String parentId;
	
	private boolean hasChildren = false;
	// 节点的子节点
	private List<TreeDO<T>> children = new ArrayList<>();
	// 节点的状态,open,closed
	private Map<String,Object> state;
	// 节点是否被选中
	private boolean checked = false;
	// 节点的属性
	private Map<String,Object> attribute;
	
	public TreeDO() {
	}
	
	public TreeDO(String id, String text, boolean hasParent, String parentId, boolean hasChildren,
			List<TreeDO<T>> children, Map<String, Object> state, boolean checked, Map<String, Object> attribute) {
		super();
		this.id = id;
		this.text = text;
		this.hasParent = hasParent;
		this.parentId = parentId;
		this.hasChildren = hasChildren;
		this.children = children;
		this.state = state;
		this.checked = checked;
		this.attribute = attribute;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isHasParent() {
		return hasParent;
	}

	public void setHasParent(boolean hasParent) {
		this.hasParent = hasParent;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public List<TreeDO<T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeDO<T>> children) {
		this.children = children;
	}

	public Map<String, Object> getState() {
		return state;
	}

	public void setState(Map<String, Object> state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Map<String, Object> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, Object> attribute) {
		this.attribute = attribute;
	}
	
}
