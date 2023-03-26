package leetcode.CodeCaprice.AA_array.C_slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class B_totalFruit_904 {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> type2Count = new HashMap<>();
        int left = 0, right = 0, maxFruitLen = 0, subLen = 0;
        while (right < fruits.length) {
            while (type2Count.keySet().size() <= 2 && right < fruits.length) {
                type2Count.put(fruits[right], type2Count.getOrDefault(fruits[right], 0) + 1);
                subLen++;
                right++;
                if (type2Count.keySet().size() <= 2)
                    maxFruitLen = Math.max(maxFruitLen, subLen);
            }
            while (type2Count.keySet().size() > 2) {
                if (type2Count.keySet().size() <= 2)
                    maxFruitLen = Math.max(maxFruitLen, subLen);
                subLen--;
                if (type2Count.put(fruits[left], type2Count.get(fruits[left]) - 1) - 1 == 0) {
                    type2Count.remove(fruits[left]);
                }
                left++;
            }
        }
        return maxFruitLen;
    }

    public static void main(String[] args) {
        int[] fruits = { 0 };
        System.out.println(totalFruit(fruits));
    }
}
