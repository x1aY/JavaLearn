package leetcode.LeetcodeHot100.AD_fourth50;

public class D_majorElement_169 {

    public static void main(String[] args) {
        D_majorElement_169 solution = new D_majorElement_169();
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public int majorityElement(int[] nums) {
        return 0;
    }

    // https://leetcode.cn/problems/majority-element/solution/javashi-pin-jiang-jie-xi-lie-majority-element-by-s/
    // 04:30开始
    class Solution {

        public int majorityElement(int[] nums) {
            int winner = nums[0], count = 1;
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if (num == winner) {
                    count++;
                } else if (count == 0) {
                    winner = num;
                    count++;
                } else {
                    count--;
                }
            }
            return winner;
        }


    }
}
