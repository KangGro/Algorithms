package com.mr.kangaroo.tree.traverse;

import com.mr.kangaroo.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author daisy
 * @desc 广度优先遍历
 * @create 2018/4/15
 */
public class BreadthFirstTraverse {
    public static void breadthFirstTraverse(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            System.out.println(node.getData());
            if(node.getLchild() != null){
                queue.offer(node.getLchild());
            }
            if(node.getRchild() != null){
                queue.offer(node.getRchild());
            }
        }
    }

    public static void main(String[] args) {
        breadthFirstTraverse(null);
    }
}
