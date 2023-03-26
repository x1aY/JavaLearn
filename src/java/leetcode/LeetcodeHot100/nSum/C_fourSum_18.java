package leetcode.LeetcodeHot100.nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C_fourSum_18 {

    public static void main(String[] args) {
        C_fourSum_18 solution = new C_fourSum_18();
        int[] nums = { -2, -1, -1, 1, 1, 2, 2 };
        int target = 0;
        solution.fourSum(nums, target);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return ans;
            }
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len; j++) {
                // 二级剪枝
                if (nums[j] + nums[i] > target && nums[i] >= 0) {
                    break;
                }
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int ijSum = nums[i] + nums[j], currRes = target - ijSum;
                if (addOverflow(nums[i], nums[j], ijSum) || addOverflow(ijSum, currRes, target)) continue;
                for (int l = j + 1, r = len - 1; l < r;) {
                    int currSub = nums[l] + nums[r];
                    if (addOverflow(nums[l], nums[r], currSub))
                        continue;
                    if (currSub == currRes) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        int currL = nums[l], currR = nums[r];
                        while (currL == nums[l] && l < r)
                            l++;
                        while (currR == nums[r] && l < r)
                            r--;
                    } else if (currSub > currRes)
                        r--;
                    else
                        l++;
                }
            }
        }
        return ans;
    }

    /* *
     * (x ^ r) & (y ^ r)将用运算符算出来的r与x和y分别异或，异或的规则是同0异1。
     * 我们只看符号位，如果符号位不同，那么两个括号得到的都是1。
     * 而与运算又是只有1 & 1才是1，有一个为0都是0。
     * 因此，一旦溢出，无论是正溢出负溢出，(x ^ r) & (y ^ r)计算出的结果都应该小于0
     * 源码： Math.addExtract(), Math.multiplyExtract()
     */
    public boolean addOverflow(int a, int b, int res) {
        return ((a ^ res) & (b ^ res)) < 0;
    }

}
