package leetcode.Labuladong.A_DataStructure.C_doublePointer;

public class removeElement_27 {
    public static int removeElement(int[] nums, int val) {
        int left = 0, right = 0, numsLen = nums.length;
        while (right < numsLen) {
            if (nums[right++] != val) {
                nums[left++] = nums[right - 1];
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 0,1,2,2,3,0,4,2 };
        int val = 2;
        int len = removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
            System.out.print(", ");
        }
    }
}
