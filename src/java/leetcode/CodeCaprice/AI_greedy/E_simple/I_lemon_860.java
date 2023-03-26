package leetcode.CodeCaprice.AI_greedy.E_simple;

import java.util.HashMap;
import java.util.Map;

public class I_lemon_860 {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> cMap = new HashMap<>(2);
        cMap.put(5, 0);
        cMap.put(10, 0);
        for (int bill : bills) {
            if (bill == 5) {
                addKeyCount(cMap, bill);
            } else if (bill == 10) {
                if (cMap.get(5) == 0)
                    return false;
                delKeyCount(cMap, 5);
                addKeyCount(cMap, bill);
            } else if (bill == 20) {
                if (cMap.get(5) == 0)
                    return false;
                if (cMap.get(10) > 0) {
                    delKeyCount(cMap, 5);
                    delKeyCount(cMap, 10);
                } else {
                    if (cMap.get(5) < 3)
                        return false;
                    delKeyCount(cMap, 5, 3);
                }
            }

        }
        return true;
    }

    public void addKeyCount(Map<Integer, Integer> map, int key) {
        map.put(key, map.get(key) + 1);
    }

    public void delKeyCount(Map<Integer, Integer> map, int key) {
        map.put(key, map.get(key) - 1);
    }

    public void delKeyCount(Map<Integer, Integer> map, int key, int count) {
        map.put(key, map.get(key) - count);
    }

    public static void main(String[] args) {
        I_lemon_860 solution = new I_lemon_860();
        int[] bills = { 5, 5, 5, 10, 5, 5, 10, 20, 20, 20 };
        System.out.println(solution.lemonadeChange(bills));
    }
}
