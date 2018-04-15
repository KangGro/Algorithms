package com.mr.kangaroo.tree.traverse;

import com.mr.kangaroo.tree.TreeNode;

import java.util.Stack;

/**
 * @author daisy
 * @desc 深度优先遍历
 * @create 2018/4/15
 */
public class DeepthFirstTraverse {

    public static void iterTraverse(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            System.out.println(root.getData());
            if(root.getLchild() != null){
                stack.push(root.getLchild());
            }
            if(root.getRchild() != null){
                stack.push(root.getRchild());
            }
        }
    }
    public static void recursiveTraverse(TreeNode<Integer> node){
        if(node != null){
            System.out.println(node.getData());
            recursiveTraverse(node.getLchild());
            recursiveTraverse(node.getRchild());
        }
    }
}
