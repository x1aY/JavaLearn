package leetcode.Labuladong.F_DfsBfs.D_Bfs;

import java.util.ArrayDeque;
import java.util.Queue;

import leetcode.Labuladong.laCommon.TreeNode;

public class A_minDepth_111 {
    
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            depth++;
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode curr = queue.poll();
                TreeNode currLeft = curr.left,currRight = curr.right;
                if(currLeft==null&&currRight==null){
                    queue.clear();
                    break;
                }
                if(currLeft!=null) queue.add(currLeft);
                if(currRight!=null) queue.add(currRight);
            }
        }
        return depth;
    }


    public static void main(String[] args) {
        int[] valLayer = {3, 9, 20, 15, 7, TreeNode.LEEF, TreeNode.LEEF};
        TreeNode root = TreeNode.GenBTree(valLayer);
        A_minDepth_111 solution = new A_minDepth_111();
        System.out.println(solution.minDepth(root));
    }

}
