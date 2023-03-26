package leetcode.LeetcodeHot100.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class I_minRange_632 {

    public static void main(String[] args) {
        I_minRange_632 solution = new I_minRange_632();
        List<List<Integer>> nums = new ArrayList<>(Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)));
        solution.smallestRange(nums);
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        return null;
    }


    /* 
     * 思路：将nums中k个数组合并成一个数组，对每个数字记录其所在的数组编号和值。
     * 定义Pair类来表示合并后的元素，Pair.num表示该元素的值；Pair.idx表示该元素所在的原数组编号。
     * 将k个数组合并成一个之后就可以将问题简化成：
     * 求一个最小区间，使得该区间满足 区间中包含的元素中至少有一个在原数组i中，i属于[1,k]。可以使用滑动窗口求解。
     * 这样就将问题reduce到LeetCode76题
     */
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            // 记录答案
            List<Integer> ans = new ArrayList<>();
            // 将nums合并到一个数组，该数组用all表示
            List<Pair> all = new ArrayList<>();
            // 用来在滑动窗口的时候记录哪个数组出现的次数
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.size(); i++) {
                for (int num : nums.get(i)) {
                    all.add(new Pair(num, i));
                }
            }
            // 对all数组排序
            Collections.sort(all, (a, b) -> a.num - b.num);
            // 滑动窗口
            int left = 0, right = 0;
            int n = all.size(), k = nums.size();
            int diff = Integer.MAX_VALUE, cnt = 0;
            while (right < n) {
                // 增加right
                Pair cur = all.get(right);
                if (!map.containsKey(cur.idx)) {
                    cnt++;
                    map.put(cur.idx, 0);
                }
                map.put(cur.idx, map.get(cur.idx) + 1);
                // 缩小left区间找最小。能缩小的条件是当前cnt == k
                while (cnt == k && left <= right) {
                    if (diff > all.get(right).num - all.get(left).num) {
                        diff = all.get(right).num - all.get(left).num;
                        ans.clear();
                        ans.add(all.get(left).num);
                        ans.add(all.get(right).num);
                    }
                    map.put(all.get(left).idx, map.get(all.get(left).idx) - 1);
                    if (map.get(all.get(left).idx) == 0) {
                        cnt--;
                        map.remove(all.get(left).idx);
                    }
                    left++;
                }
                right++;
            }
            return new int[] { ans.get(0), ans.get(1) };
        }

        class Pair {
            int num;
            int idx;

            public Pair(int num, int idx) {
                this.num = num;
                this.idx = idx;
            }
        }
    }
}
