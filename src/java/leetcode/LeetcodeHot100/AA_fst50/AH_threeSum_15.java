package leetcode.LeetcodeHot100.AA_fst50;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AH_threeSum_15 {

    public static void main(String[] args) {
        AH_threeSum_15 solution = new AH_threeSum_15();
        int[] nums = { 0, 0, 0 };
        solution.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int currRes = -nums[i];
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int l = i + 1, r = len - 1; l < r;) {
                int currSub = nums[l] + nums[r];
                if (currSub == currRes) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    int currL = nums[l], currR = nums[r];
                    while (currL == nums[l] && l < r) l++;
                    while (currR == nums[r] && l < r) r--;
                } else if (currSub > currRes)
                    r--;
                else
                    l++;
            }
        }
        return ans;
    }
}
