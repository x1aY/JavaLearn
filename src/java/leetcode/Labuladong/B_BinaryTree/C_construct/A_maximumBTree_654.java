package leetcode.Labuladong.B_BinaryTree.C_construct;

import leetcode.Labuladong.laCommon.TreeNode;

public class A_maximumBTree_654 {

    // public static TreeNode constructMaximumBinaryTree(int[] nums) {
    //     int len = nums.length;
    //     int[][] maxIdx = GenMaxIdx(nums, len);
    //     return GenBTree(nums, maxIdx, 0, nums.length - 1);
    // }

    // public static int[][] GenMaxIdx(int[] nums, int len) {
    //     int[][] maxIdx = new int[len][len];
    //     for (int i = 0; i < len; i++)
    //         maxIdx[i][i] = i;
    //     for (int i = len - 2; i >= 0; i--)
    //         for (int j = i + 1; j < len; j++) {
    //             maxIdx[i][j] = nums[i] > nums[j] ? i : j;
    //             if (j > i + 1)
    //                 maxIdx[i][j] = nums[maxIdx[i][j]] > nums[maxIdx[i + 1][j - 1]] ? maxIdx[i][j]
    //                         : maxIdx[i + 1][j - 1];
    //         }
    //     return maxIdx;
    // }

    // public static TreeNode GenBTree(int[] nums, int[][] maxIdx, int left, int right) {
    //     if (left > right)
    //         return null;
    //     int maxIndex = maxIdx[left][right];
    //     TreeNode root = new TreeNode(nums[maxIndex]);
    //     if (right > left) {
    //         root.left = GenBTree(nums, maxIdx, left, maxIndex - 1);
    //         root.right = GenBTree(nums, maxIdx, maxIndex + 1, right);
    //     }
    //     return root;
    // }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
    return GenBTree(nums, 0, nums.length - 1);
    }

    public static TreeNode GenBTree(int[] nums, int left, int right) {
    if (left > right)
    return null;
    int maxIndex = maxIndex(nums, left, right);
    TreeNode root = new TreeNode(nums[maxIndex]);
    if (right > left) {
    root.left = GenBTree(nums, left, maxIndex - 1);
    root.right = GenBTree(nums, maxIndex + 1, right);
    }
    return root;
    }

    public static int maxIndex(int[] nums, int left, int right) {
    if (left == right)
    return left;

    int numsIndex = left;
    for (int i = left + 1; i <= right; i++) {
    if (nums[numsIndex] < nums[i])
    numsIndex = i;
    }
    return numsIndex;
    }

    public static void main(String[] args) {
        int[] valLayer = { 3, 2, 1, 6, 0, 5 };
        TreeNode root = constructMaximumBinaryTree(valLayer);
        System.out.println(root.val);
    }
}
