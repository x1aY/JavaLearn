package Sort;

public class MergeSort {

    // 用于辅助合并有序数组
    private static int[] temp;

    public static void sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    /* 
     * 将子数组 nums[lo..hi] 进行排序
     * 二叉树的后序遍历
     */
    private static void sort(int[] nums, int lo, int hi) {
        if (lo == hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    // 将 nums[lo..mid] nums[mid+1..hi] 两个有序数组合并成一个
    private static void merge(int[] nums, int left, int mid, int right) {
        // 先把 nums[lo..hi] 复制到辅助数组中 以便合并后的结果能够直接存入 nums
        for (int i = left; i <= right; i++)
            temp[i] = nums[i];

        // 数组双指针 合并两个有序数组
        int i = left, j = mid + 1;
        for (int p = left; p <= right; p++) {
            // 左半边数组已全部被合并
            if (i == mid + 1) nums[p] = temp[j++];
            // 右半边数组已全部被合并
            else if (j == right + 1) nums[p] = temp[i++];
            else if (temp[i] > temp[j]) nums[p] = temp[j++];
            else  nums[p] = temp[i++];

        }
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1 };
        sortArray(nums);
        System.out.println(nums.toString());
    }
}
