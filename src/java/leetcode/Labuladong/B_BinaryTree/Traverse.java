package leetcode.Labuladong.B_BinaryTree;

import java.util.LinkedList;
import java.util.Stack;

import leetcode.Labuladong.laCommon.TreeNode;

public class Traverse {
    
    public static void preOrderStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        // treeNode null 并且 stack 为空才结束
        while(treeNode!=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while(treeNode != null){
                System.out.print(treeNode.val+" ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    public static void inOrderStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        while(treeNode!=null || !stack.isEmpty()){
            while(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.print(treeNode.val+" ");
                treeNode = treeNode.right;
            }
        }
    }

    public static void postOrderStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = node;
        TreeNode lastVisit = null;   //标记每次遍历最后一次访问的节点
        while(treeNode!=null || !stack.isEmpty()){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                //treeNode：没有右孩子/已经访问过，输出treeNode.val，让lastVisit指向treeNode，并让treeNode为空
                if(treeNode.right == null || treeNode.right == lastVisit) {
                    System.out.print(treeNode.val + " ");
                    lastVisit = treeNode;
                    treeNode  = null;
                }
                // 有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
                else{
                    stack.push(treeNode);
                    treeNode = treeNode.right;
                }
            }
        }
    }

    public static void levelOrder(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.pop();
            System.out.print(root.val+" ");
            if(root.left!=null) queue.add(root.left);
            if(root.right!=null) queue.add(root.right);
        }
    }

    public static void main(String[] args) {
        int[] valLayer = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.GenBTree(valLayer);
        postOrderStack(root);
    }



}
