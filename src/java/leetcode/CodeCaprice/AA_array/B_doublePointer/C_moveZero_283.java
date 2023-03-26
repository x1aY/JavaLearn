package leetcode.CodeCaprice.AA_array.B_doublePointer;

import java.util.Arrays;

public class C_moveZero_283 {

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0, fast = 1, temp = 0;
        if (len < 2)
            return;
        while (fast < len) {
            // slow捕捉在前列的0
            while (nums[slow] != 0 && fast > slow)
                slow++;
            // fast捕捉在后面的非0，并与slow此时的0交换
            if (nums[fast] != 0) {
                temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0 };
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
