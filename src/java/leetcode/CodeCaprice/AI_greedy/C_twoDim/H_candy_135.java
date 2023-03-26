package leetcode.CodeCaprice.AI_greedy.C_twoDim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmercarl.com/0135.%E5%88%86%E5%8F%91%E7%B3%96%E6%9E%9C.html#%E6%80%9D%E8%B7%AF
 */
public class H_candy_135 {

    /**
     * 答案错误， 思路不对
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len < 2)
            return len;
        int[] candyList = new int[len];
        int minRating = Integer.MAX_VALUE;
        List<Integer> minIndexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            candyList[i] = 0;
            if (minRating > ratings[i]) {
                minRating = ratings[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if (minRating == ratings[i]) {
                candyList[i] = 1;
                minIndexList.add(i);
            }
        }
        for (Integer minIndex : minIndexList) {
            int left = minIndex - 1, right = minIndex + 1;
            while (left >= 0) {
                if (candyList[left] == 0) {
                    if (left - 1 >= 0 && ratings[left - 1] == minRating)
                        candyList[left - 1] = 1;
                    boolean isLBL = (left - 1 >= 0 && ratings[left] > ratings[left - 1]) || left == 0;
                    boolean isLBR = left + 1 >= 0 && ratings[left] > ratings[left + 1];
                    if (isLBL && isLBR) {
                        if (left == 0)
                            candyList[left] = candyList[left + 1] + 1;
                        else
                            candyList[left] = Math.max(candyList[left - 1], candyList[left + 1]) + 1;
                    } else if (isLBL) {
                        if (left == 0)
                            candyList[left] = 1;
                        else if (candyList[left - 1] != 0)
                            candyList[left] = candyList[left - 1] + 1;
                    } else if (isLBR) {
                        candyList[left] = candyList[left + 1] + 1;
                    } else {
                        candyList[left] = 1;
                    }
                }
                left--;
            }
            while (right < len) {
                if (candyList[right] == 0) {
                    if (right + 1 < len && ratings[right + 1] == minRating)
                        candyList[right + 1] = 1;
                    boolean isRBL = right - 1 < len && ratings[right] > ratings[right - 1];
                    boolean isRBR = (right + 1 < len && ratings[right] > ratings[right + 1])
                            || right == len - 1;
                    if (isRBL && isRBR) {
                        if (right == len - 1)
                            candyList[right] = candyList[right - 1] + 1;
                        else
                            candyList[right] = Math.max(candyList[right - 1], candyList[right + 1]) + 1;
                    } else if (isRBR) {
                        if (right == len - 1)
                            candyList[right] = 1;
                        else if (candyList[right + 1] != 0)
                            candyList[right] = candyList[right + 1] + 1;
                    } else if (isRBL) {
                        if (candyList[right - 1] != 0) {
                            candyList[right] = candyList[right - 1] + 1;
                        }
                    } else {
                        candyList[right] = 1;
                    }

                }
                right++;
            }
        }
        return Arrays.stream(candyList).sum();
    }

    public static void main(String[] args) {
        H_candy_135 solution = new H_candy_135();
        int[] ratings = { 1, 2, 10, 10, 10, 2, 1 };
        System.out.println(solution.candy(ratings));
    }

}