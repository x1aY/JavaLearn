package myLab.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = { 4, 1, 5, 7, 3, 9, 2, 6, 8 };
        QuickSort ans = new QuickSort();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort((a, b) -> a - b);
        ans.quickSort(nums, 0, nums.length - 1);
        System.out.println(nums.toString());
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int pivotIdx = partition(nums, left, right);
        quickSort(nums, left, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        if (left > right)
            return -1;
        int pivot = left, i = left, j = right;
        while (i < j) {
            // 必须j在前：最后一次交换时：
            // 若i先，会在比pivot大的元素停下，交换时报错
            // j先，会在比pivot小的元素停下，交换正常
            while (i < j && nums[j] >= nums[pivot])
                j--;
            while (i < j && nums[i] <= nums[pivot])
                i++;
            swap(nums, i, j);
        }
        swap(nums, pivot, i);
        return i;
    }

    public void swap(int[] nums, int fstIdx, int secIdx) {
        int temp = nums[fstIdx];
        nums[fstIdx] = nums[secIdx];
        nums[secIdx] = temp;
    }

}
