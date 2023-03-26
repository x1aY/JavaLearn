package leetcode.CodeCaprice.AF_stackQueue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class G_topKFrequent_347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] topList = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        List<Entry<Integer, Integer>> sortedSet = freqMap.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .collect(Collectors.toList());
        int i = 0;
        for (Entry<Integer, Integer> entry : sortedSet) {
            topList[i] = entry.getKey();
            if (++i == k)
                break;
        }
        return topList;
    }

    public static void main(String[] args) {
        G_topKFrequent_347 solution = new G_topKFrequent_347();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] res = solution.topKFrequent(nums, k);
        for (int resi : res) {
            System.out.print(String.valueOf(resi) + ", ");
        }
    }

}