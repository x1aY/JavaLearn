package leetcode.CodeCaprice.AA_array.B_doublePointer;

import java.util.Arrays;

public class B_removeDuplicatesInSortedArray_26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) { 
            return 0; 
        } 
        int slow = 0, fast = 0; 
        while (fast < nums.length) { 
            if (nums[fast] != nums[slow]) { 
                slow++; 
                // 维护 nums[0..slow] ⽆重复 
                nums[slow] = nums[fast]; 
            } 
            fast++; 
        } 
        // 数组⻓度为索引 + 1 
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
