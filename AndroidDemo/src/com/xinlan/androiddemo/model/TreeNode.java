package com.xinlan.androiddemo.model;

import java.util.List;

/**
 * 无限级展开树
 * @author admin
 *
 */
public class TreeNode {
	
	
	public String id;
	
	public String name;
	
	public String type; // 1组 ,2 人
	
	public List<TreeNode> chileNode;   //子节点
	
//	public ImageView imageView;   //需要时操作图片

}
