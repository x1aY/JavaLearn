package leetcode.Labuladong.F_DfsBfs.A_DfsBacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A_permute_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> permutes = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(numList, used, new ArrayList<>(), permutes);
        return permutes;
    }

    public static void backtrack(List<Integer> numList, boolean[] used, List<Integer> currList,
            List<List<Integer>> permutes) {
        if (currList.size()==numList.size()) {
            // 浅拷贝, 因为是Integer, 不影响
            permutes.add(new ArrayList<Integer>(currList));
            System.out.println(currList);
            return;
        }
        for (int i = 0; i < numList.size(); i++) {
            if(used[i])
                continue;
            currList.add(numList.get(i));
            used[i]=true;
            backtrack(numList, used, currList, permutes);
            used[i]=false;
            currList.remove(numList.get(i));
        }

        // List<Integer> list4Loop = new ArrayList<Integer>(numList);
        // for (Integer numi : list4Loop) {
        //     currList.add(numi);
        //     numList.remove(numi);
        //     backtrack(numList, used, currList, permutes);
        //     numList.add(numi);
        //     currList.remove(numi);
        // }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> permutes = permute(nums);
        System.out.println(permutes.toString());
    }
}
