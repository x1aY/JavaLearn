package leetcode.LeetcodeHot100.AD_fourth50;

import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;
import java.util.PriorityQueue;

public class K_KthLarge_215 {

    public static void main(String[] args) {
        K_KthLarge_215 solution = new K_KthLarge_215();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3));
        System.out.println(solution.findKthLargestByPQ(new int[]{3, 2, 1, 5, 6, 4}, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length, kthMin = len + 1 - k;
        return findkThRecursion(nums, 0, len - 1, kthMin);
    }

    public int findkThRecursion(int[] nums, int start, int end, int kthMin) {
        if (start == end) return nums[start];
        int part = partition(nums, start, end);
        int currKth = part - start + 1;
        if (currKth == kthMin) return nums[part];
        else if (currKth < kthMin) return findkThRecursion(nums, part + 1, end, kthMin - currKth);
        else if (currKth > kthMin) return findkThRecursion(nums, start, part - 1, kthMin);
        return -1;
    }


    public int partition(int[] nums, int start, int end) {
        int val = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= val)
                end--;
            swap(nums, start, end);
            while (start < end && nums[start] <= val)
                start++;
            swap(nums, start, end);
        }
        return start;
    }

    public void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }



    static class Solution {

        private final static Random random = new Random(System.currentTimeMillis());

        public int findKthLargest(int[] nums, int k) {
            // 第 1 大的数，下标是 len - 1;
            // 第 2 大的数，下标是 len - 2;
            // ...
            // 第 k 大的数，下标是 len - k;
            int len = nums.length;
            int target = len - k;

            int left = 0;
            int right = len - 1;

            while (true) {
                int pivotIndex = partition(nums, left, right);
                if (pivotIndex == target) {
                    return nums[pivotIndex];
                } else if (pivotIndex < target) {
                    left = pivotIndex + 1;
                } else {
                    // pivotIndex > target
                    right = pivotIndex - 1;
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            int randomIndex = left + random.nextInt(right - left + 1);
            swap(nums, left, randomIndex);


            // all in nums[left + 1..le) <= pivot;
            // all in nums(ge..right] >= pivot;
            int pivot = nums[left];
            int le = left + 1;
            int ge = right;

            while (true) {
                while (le <= ge && nums[le] < pivot) {
                    le++;
                }

                while (le <= ge && nums[ge] > pivot) {
                    ge--;
                }

                if (le >= ge) {
                    break;
                }
                swap (nums, le, ge);
                le++;
                ge--;
            }

            swap(nums, left, ge);
            return ge;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

    }

    public int findKthLargestByPQ(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        // Java 里没有 heapify ，因此我们逐个将前 k 个元素添加到 minHeap 里
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < len; i++) {
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > minHeap.peek()) {
                // Java 没有 replace()，所以得先 poll() 出来，然后再放回去
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
