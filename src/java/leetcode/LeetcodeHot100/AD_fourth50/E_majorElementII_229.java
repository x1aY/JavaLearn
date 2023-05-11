package leetcode.LeetcodeHot100.AD_fourth50;

import java.util.ArrayList;
import java.util.List;

public class E_majorElementII_229 {


    public List<Integer> majorityElement(int[] nums) {
        return null;
    }

    // https://leetcode.cn/problems/majority-element-ii/solution/liang-fu-dong-hua-yan-shi-mo-er-tou-piao-fa-zui-zh/
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            // 创建返回值
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            // 初始化两个候选人candidate，和他们的计票
            int cand1 = nums[0], count1 = 0;
            int cand2 = nums[0], count2 = 0;

            // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
            // 配对阶段
            for (int num : nums) {
                // 投票
                if (cand1 == num) {
                    count1++;
                    continue;
                }
                if (cand2 == num) {
                    count2++;
                    continue;
                }

                // 第1个候选人配对
                if (count1 == 0) {
                    cand1 = num;
                    count1++;
                    continue;
                }
                // 第2个候选人配对
                if (count2 == 0) {
                    cand2 = num;
                    count2++;
                    continue;
                }

                count1--;
                count2--;
            }

            // 计数阶段
            // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (cand1 == num) count1++;
                else if (cand2 == num) count2++;
            }

            if (count1 > nums.length / 3) res.add(cand1);
            if (count2 > nums.length / 3) res.add(cand2);

            return res;
        }
    }
}
