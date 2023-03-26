package leetcode.Labuladong.A_DataStructure.E_binarySearch;
public class SplitArray_410 {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int m = 5;
        splitArray(nums, m);
    } 

    public static int splitArray(int[] nums, int m) {
        return 0;
    }

    class Solution {
        public int splitArray(int[] nums, int m) {
            // left记录子数组和最大值下界，right记录子数组和最大值上界
           int left = 0, right = 0;
           for(int i : nums){
               // 子数组和最大值上界就是 数组中所有元素和，即只有1个子数组
               right += i;
               // 子数组和最大值下界就是 数组中元素的最大值，即每个元素表示1个子数组
               if(i > left){
                   left = i;
               }
           }
           // 注意搜索区间[left,right] ,左闭右闭
           while(left <= right){
               int mid = left + (right - left) / 2;
               int split = subSplit(nums,mid);
               if(split > m){
                   // mid小了，该往右边搜索
                   left = mid + 1;
               }else if(split < m){
                   // mid大了，该往左边搜索
                   right = mid - 1;
               }else if(split == m){
                   // 找到了满足分割数m的子数组最大值，但是我们还要在此基础上继续寻找左边界，也就是满足分割数且最大值最小
                   right = mid - 1;
               }
           }
           // while终止条件是 left > right,
           // 一种是最后1次刚好分割数为m（前面也可能有分割数为m）,且left==right,那么返回left即满足分割数且最大值最小
           // 另一种是 最后1次分割数不为m(但是前面有分割数为m的情况)，且left==right，因为这种情况下搜索区间往右靠近，最终left也恰好等于上一次分割数为m的mid值
           return left;
    
        }
    
        // 根据子数组和subArrSum划分数组，返回子数组个数
        private int subSplit(int[] nums, int subArrSum){
            int split = 1;
            int tmpArrSum = 0;
            for(int i : nums){
                if(tmpArrSum + i > subArrSum){
                    // 以该元素为界限，划分1次
                    split++;
                    tmpArrSum = 0;
                }
                tmpArrSum += i;
            }
            return split;
        }
    }
}
