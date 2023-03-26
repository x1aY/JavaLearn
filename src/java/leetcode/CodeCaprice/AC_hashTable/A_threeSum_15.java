package leetcode.CodeCaprice.AC_hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_threeSum_15 {

    List<List<Integer>> lists = null;

    Set<String> count = null;

    int[] numList = null;

    int listLen = 0;

    public List<List<Integer>> threeSum(int[] nums) {
        lists = new ArrayList<>();
        listLen = nums.length;
        numList = Arrays.copyOf(nums, listLen);
        Arrays.sort(numList);
        count = new HashSet<>();
        return lists;
    }
    /*
    public void findThree(int depth, int currIndex, int currSum, List<Integer> currList) {
        if (depth == 3) {
            if (currSum == 0) {
                String currListStr = list2Str(currList);
                if (!count.contains(currListStr)) {
                    count.add(currListStr);
                    lists.add(new ArrayList<>(currList));
                }
            }
            return;
        }
        if (currSum>=0 && currIndex<listLen && numList[currIndex] > 0) {
            System.out.println("test");
            return;}
        for (int i = currIndex; i < listLen; i++) {
            currList.add(numList[i]);
            currSum += numList[i];
            findThree(depth + 1, i + 1, currSum, currList);
            currList.remove(currList.size() - 1);
            currSum -= numList[i];
        }
    }
     */
    public String list2Str(List<Integer> list) {
        list.sort((first, second) -> first - second);
        return list.toString();
    }


    public static void main(String[] args) {
        A_threeSum_15 solution = new A_threeSum_15();
        int[] nums = { 0, -1, 1, 2, -1, -4 };
        solution.threeSum(nums);
    }
}
