package com.xinlan.androiddemo.ui.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.xinlan.androiddemo.R;
import com.xinlan.androiddemo.model.TreeNode;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 无限级展开树
 * @author admin
 *
 */
@SuppressLint("NewApi")
public class TreeFragment extends Fragment{
	
	
	private View tree_view;
	private LinearLayout child;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		tree_view = inflater.inflate(R.layout.frag_tree, null);
		init(inflater);
		return tree_view;
	}
	
	
	public void init(LayoutInflater inflater){     
		List<TreeNode> data = getData();
		child = (LinearLayout) tree_view.findViewById(R.id.tree_view);
		showTree(inflater,data,child);  // 第一次请求的三个组(组1、组2、组3)
	}

	/**
	 * 传入 list 和  list所在的父布局 递归此函数
	 * @param inflater
	 * @param list
	 * @param parentView
	 */
	public void showTree(final LayoutInflater inflater,List<TreeNode> list, final LinearLayout parentView){
		
		for(TreeNode t:list){
			final View nodeItem = inflater.inflate(R.layout.tree_nodetem, null); //每一个树结节 布局
			TextView tv = (TextView) nodeItem.findViewById(R.id.groupName);
			tv.setText(t.name);
			ImageView img = (ImageView) nodeItem.findViewById(R.id.isExpand); //右边小三角 增加点击事件
			img.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) { //每次点击请求一次数据 
					//拿到布局
					child= (LinearLayout) nodeItem.findViewById(R.id.tree_child);
					if(View.GONE==child.getVisibility()){
						//拿到数据
//						getChildData();
						showTree(inflater, getChildData(), child);
						child.setVisibility(View.VISIBLE);
					}else{
						child.setVisibility(View.GONE);
						child.removeAllViews();
					}
					
					
				}
			});
			parentView.addView(nodeItem);
		}
	
	}
	
	
	public List<TreeNode> getChildData(){
			List<TreeNode> treeList = new ArrayList<TreeNode>();
			TreeNode t1 = new TreeNode();
			t1.id="cgroup1";
			t1.name="子组1";
			TreeNode t2 = new TreeNode();
			t2.id="cgroup2";
			t2.name="子组2";
			TreeNode t3 = new TreeNode();
			t3.id="cgroup3";
			t3.name="子组3";
			treeList.add(t1);
			treeList.add(t2);
			treeList.add(t3);
			return treeList;
		
	}
	
	
	public List<TreeNode> getData(){
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		TreeNode t1 = new TreeNode();
		t1.id="cgroup1";
		t1.name="组1";
		TreeNode t2 = new TreeNode();
		t2.id="cgroup2";
		t2.name="组2";
		TreeNode t3 = new TreeNode();
		t3.id="cgroup3";
		t3.name="组3";
		treeList.add(t1);
		treeList.add(t2);
		treeList.add(t3);
		return treeList;
	
}
}
