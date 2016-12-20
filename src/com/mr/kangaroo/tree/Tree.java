package com.mr.kangaroo.tree;

/**
 * abstract tree structure,defined a set of methods operate the TreeNode of the
 * tree;
 * 
 * @author admin
 *
 */
public interface Tree<T> {

	/** Get the number of the TreeNode on the tree. */
	int getTreeNodeNum(TreeNode<T> root);

	/** Get the depth of the tree. */
	int getTreeDepth(TreeNode<T> root);

	/** Preorder traverse the tree. */
	void preOrderTraverse(TreeNode<T> root);

	/** Inorder traverse the tree. */
	void inOrderTraverse(TreeNode<T> root);

	/** Postorder traverse the tree. */
	void poseOrderTraverse(TreeNode<T> root);

	/** Traverse the tree in level order. */
	void levelTraverse(TreeNode<T> root);

	/** Convert the tree to double linked list. */
	void toDNodeList(TreeNode<T> root);

	/** Get the treenode number of the given tree level. */
	void getNodeNumOfTheLevel(TreeNode<T> root, int level);

	/** Get the number of the tree leafs. */
	void TreeLeafNum(TreeNode<T> root);

	/** Compares this tree to the specified tree. */
	boolean treeEquala(TreeNode<T> root);

	/** Returns true ,if ,and only if this tree is AVL tree. */
	boolean isAVL();
	
	/** Returns the mirror of the specified tree. */
	void BinaryTreeMirror(TreeNode<T> root);
	
	/** Returns the nearest common parent node. */
	TreeNode<T> NearestCommonParent(TreeNode<T> n1,TreeNode<T> n2);
	
	/** Returns the max distance between the tree nodes. */
	int maxDistance(TreeNode<T> root);
	
	/** Rebuild the tree base on the preorder and inorder. */
	Tree<T> rebuildTree(int[] preList,int[] inList,int length);
	
	/** Returns true ,if ,and only if this tree is complete binary tree. */
	boolean IsCompleteBinaryTree(TreeNode<T> root);
}
