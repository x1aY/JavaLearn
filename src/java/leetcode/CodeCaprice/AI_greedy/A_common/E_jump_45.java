package leetcode.CodeCaprice.AI_greedy.A_common;

public class E_jump_45 {

    public int jump(int[] nums) {
        return 0;
    }

    public int maxIndex(int[] nums, int index) {
        return index + nums[index];
    }

    public static void main(String[] args) {
        E_jump_45 solution = new E_jump_45();
        int[] nums = { 1, 1, 1, 1 };
        System.out.println(solution.jump(nums));
    }

    class Solution1 {
        public int jump(int[] nums) {
            if (nums.length == 1) return 0;
            // 记录走的最大步数, 当前覆盖最远距离下标, 下一步覆盖最远距离下标
            int ans = 0, curDistance = 0, nextDistance = 0;
            for (int i = 0; i < nums.length; i++) {
                nextDistance = Math.max(nums[i] + i, nextDistance);
                if (i == curDistance) {
                    if (curDistance != nums.length - 1) {
                        ans++;
                        curDistance = nextDistance;
                        if (nextDistance >= nums.length - 1)
                            break;
                    } else
                        break;
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 0 || nums.length == 1) {
                return 0;
            }
            // 记录跳跃的次数, 当前的覆盖最大区域, 最大的覆盖区域
            int count = 0, curDistance = 0, maxDistance = 0;
            for (int i = 0; i < nums.length; i++) {
                // 在可覆盖区域内更新最大的覆盖区域
                maxDistance = Math.max(maxDistance, i + nums[i]);
                // 说明当前一步，再跳一步就到达了末尾
                if (maxDistance >= nums.length - 1) {
                    count++;
                    break;
                }
                // 走到当前覆盖的最大区域时，更新下一步可达的最大区域
                if (i == curDistance) {
                    curDistance = maxDistance;
                    count++;
                }
            }
            return count;
        }
    }

}
