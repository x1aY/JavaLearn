package leetcode.Labuladong.G_dynamicPlanning.B_classic;


public class A_lenOfLIS_300 {

    public int lengthOfLIS(int[] nums) {
        return lenLISdp(nums, nums.length - 1);
    }

    public int lenLISdp(int[] nums, int index) {
        return 0;
    }

    public static void main(String[] args) {
        A_lenOfLIS_300 solution = new A_lenOfLIS_300();
        int[] nums = { 0,1,0,3,2,3 };
        System.out.println(solution.lengthOfLIS(nums));
    }
}
