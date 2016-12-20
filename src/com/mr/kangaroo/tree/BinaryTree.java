package com.mr.kangaroo.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTree<T> implements Tree<T> {

	private TreeNode<T> root;
	private int treeNodeNum = 0;

	public BinaryTree(TreeNode<T> root) {
		this.root = root;
		treeNodeNum = 1;
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	public int getTreeNodeNum() {
		return treeNodeNum;
	}

	public void setTreeNodeNum(int treeNodeNum) {
		this.treeNodeNum = treeNodeNum;
	}

	@Override
	public int getTreeNodeNum(TreeNode<T> root) {
		TreeNode<T> left = root.getLchild();
		if (left != null) {
			treeNodeNum = treeNodeNum + 1;
			if (left.getLchild() != null || left.getRchild() != null) {
				treeNodeNum = getTreeNodeNum(left);
			}
		}
		TreeNode<T> right = root.getRchild();
		if (right != null) {
			treeNodeNum = treeNodeNum + 1;
			if (right.getLchild() != null || right.getRchild() != null) {
				treeNodeNum = getTreeNodeNum(right);
			} else {

			}
		}
		return treeNodeNum;
	}

	@Override
	public int getTreeDepth(TreeNode<T> root) {
		int depth = 0;
		List<TreeNode<T>> levelNode = new ArrayList<TreeNode<T>>();
		levelNode.add(root);
		depth = nextLevelNodes(levelNode,depth);
		return depth;
	}
	private int nextLevelNodes(List<TreeNode<T>> nodes,int depth){
		List<TreeNode<T>> levelNode = new ArrayList<TreeNode<T>>();
		if(nodes != null){
			for (Iterator<TreeNode<T>> iterator = nodes.iterator(); iterator.hasNext();) {
				TreeNode<T> treeNode = iterator.next();
//				System.out.println("--"+treeNode.getData()+"--");
				TreeNode<T> left = treeNode.getLchild();
				TreeNode<T> right = treeNode.getRchild();
				if(left != null){
					levelNode.add(left);
				}
				if(right != null){
					levelNode.add(right);
				}
			}
			if(levelNode.size() > 0){
				depth++;
				depth = nextLevelNodes(levelNode,depth);
			}
		}
		return depth;
	}

	/**
	 * Root -> Left -> Right
	 * @param root
	 */
	@Override 
	public void preOrderTraverse(TreeNode<T> root) {
		
	}
	/**
	 * Left -> Root -> Right
	 * @param root
	 */
	@Override
	public void inOrderTraverse(TreeNode<T> root) {
		if(root.getLchild() != null){
			inOrderTraverse(root.getLchild());
		}
		System.out.println("----" +root.getData()+"----");
		if(root.getRchild() != null){
			inOrderTraverse(root.getRchild());
		}
	}

	/**
	 * Left -> Right -> Root
	 * @param root
	 */
	@Override
	public void poseOrderTraverse(TreeNode<T> root) {

	}

	@Override
	public void levelTraverse(TreeNode<T> root) {
		List<TreeNode<T>> levelNode = new ArrayList<TreeNode<T>>();
		levelNode.add(root);
		levelTraverse(levelNode);
	}

	private void levelTraverse(List<TreeNode<T>> nodes){
		List<TreeNode<T>> levelNode = new ArrayList<TreeNode<T>>();
		if(nodes != null){
			for (Iterator<TreeNode<T>> iterator = nodes.iterator(); iterator.hasNext();) {
				TreeNode<T> treeNode = iterator.next();
				System.out.println("--"+treeNode.getData()+"--");
				TreeNode<T> left = treeNode.getLchild();
				TreeNode<T> right = treeNode.getRchild();
				if(left != null){
					levelNode.add(left);
				}
				if(right != null){
					levelNode.add(right);
				}
			}
			if(levelNode.size() > 0){
				levelTraverse(levelNode);
			}
		}
	}
	
	@Override
	public void toDNodeList(TreeNode<T> root) {

	}

	@Override
	public void getNodeNumOfTheLevel(TreeNode<T> root, int level) {

	}

	@Override
	public void TreeLeafNum(TreeNode<T> root) {

	}

	@Override
	public boolean treeEquala(TreeNode<T> root) {
		return false;
	}

	@Override
	public boolean isAVL() {
		return false;
	}

	@Override
	public void BinaryTreeMirror(TreeNode<T> root) {

	}

	@Override
	public TreeNode<T> NearestCommonParent(TreeNode<T> n1, TreeNode<T> n2) {
		return null;
	}

	@Override
	public int maxDistance(TreeNode<T> root) {
		return 0;
	}

	@Override
	public Tree<T> rebuildTree(int[] preList, int[] inList, int length) {
		return null;
	}

	@Override
	public boolean IsCompleteBinaryTree(TreeNode<T> root) {
		return false;
	}
}
