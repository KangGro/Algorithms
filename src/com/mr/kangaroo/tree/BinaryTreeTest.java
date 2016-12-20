package com.mr.kangaroo.tree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		TreeNode<String> A = new TreeNode<String>("A");
		TreeNode<String> B = new TreeNode<String>("B");
		TreeNode<String> C = new TreeNode<String>("C");
		A.setLchild(B);
		A.setRchild(C);
		TreeNode<String> D = new TreeNode<String>("D");
		B.setLchild(D);
		TreeNode<String> E = new TreeNode<String>("E");
		B.setRchild(E);
		TreeNode<String> H = new TreeNode<String>("H");
		D.setLchild(H);
		TreeNode<String> F = new TreeNode<String>("F");
		TreeNode<String> G = new TreeNode<String>("G");
		C.setLchild(F);
		C.setRchild(G);
		BinaryTree<String> BTree = new BinaryTree<>(A);
		System.out.println(BTree.getTreeNodeNum(A));
//		System.out.println("-------------------------------");
		BTree.levelTraverse(A);
		System.out.println(BTree.getTreeDepth(A));
		BTree.preOrderTraverse(A);
	}
}
