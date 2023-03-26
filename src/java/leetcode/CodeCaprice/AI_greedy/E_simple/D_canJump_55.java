package leetcode.CodeCaprice.AI_greedy.E_simple;

public class D_canJump_55 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int index = 0;
        while (index + nums[index] < len - 1) {
            int maxIndex = index;
            for (int i = index + 1; i <= index + nums[index]; i++) {
                if (i + nums[i] > maxIndex + nums[maxIndex]) {
                    maxIndex = i;
                }
            }
            if (index == maxIndex)
                return false;
            index = maxIndex;
        }
        return true;
    }

    public static void main(String[] args) {
        D_canJump_55 solution = new D_canJump_55();
        int[] nums = { 3, 0, 8, 2, 0, 0, 1 };
        System.out.println(solution.canJump(nums));
    }

}
