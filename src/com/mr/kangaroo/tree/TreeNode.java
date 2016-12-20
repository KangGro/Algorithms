package com.mr.kangaroo.tree;

/**
 * 数据结构: 一组数据以及在一组在数据上的操作;
 * 
 * 数据： 数据节点，左孩子节点，右孩子节点 操作：
 * 
 * 
 * @author admin
 *
 * @param <T>
 */
public class TreeNode<T> {
	T data;
	TreeNode<T> lchild;
	TreeNode<T> rchild;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLchild() {
		return lchild;
	}

	public void setLchild(TreeNode<T> lchild) {
		this.lchild = lchild;
	}

	public TreeNode<T> getRchild() {
		return rchild;
	}

	public void setRchild(TreeNode<T> rchild) {
		this.rchild = rchild;
	}

	public TreeNode(T data) {
		super();
		this.data = data;
	}

	public TreeNode(T data, TreeNode<T> lchild, TreeNode<T> rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}
