package leetcode.Labuladong.B_BinaryTree.B_thought;

import java.util.ArrayDeque;
import java.util.Queue;

import leetcode.Labuladong.laCommon.TripleNode;

public class C_connect_116 {

    /**
     * 层次遍历的写法
     */
    public TripleNode connect(TripleNode root) {
        if (root == null) return root;

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<TripleNode> queue = new ArrayDeque<TripleNode>();
        queue.add(root);
        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                TripleNode node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回根节点
        return root;
    }

    public static TripleNode myConnect(TripleNode root) {
        if (root != null && root.left != null && root.right != null) {

            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
            myConnect(root.left);
            myConnect(root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] valLayer = { 1, 2, 3, 4, 5, 6, 7 };
        TripleNode root = TripleNode.GenBTree(valLayer);
        myConnect(root);
        System.out.println(root);
    }

}
