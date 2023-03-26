package leetcode.Labuladong.G_dynamicPlanning.C_bag;

public class A_canPartition_416 {
    public boolean canPartition(int[] nums) {
        // int bagWeight = 0;
        // int numsLen = nums.length;
        // for (int i : nums) bagWeight += i;
        // if (bagWeight % 2 == 1) return false;
        // bagWeight /= 2;
        // int[][] dp = new int[numsLen][bagWeight];
        return true;
    }

    public static void main(String[] args) {
        A_canPartition_416 solution = new A_canPartition_416();
        int[] nums = { 1, 5, 11, 5 };
        System.out.println(solution.canPartition(nums));
    }
}
