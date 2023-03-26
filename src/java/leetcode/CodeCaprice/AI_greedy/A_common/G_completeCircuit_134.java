package leetcode.CodeCaprice.AI_greedy.A_common;

public class G_completeCircuit_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int  len = gas.length;
        return len;
    }

    public boolean canCircuit(int[] gas, int[] cost, int index, int length) {
        int currGasLeft = gas[index];
        for (int i = 0; i < length; i++) {
            currGasLeft = currGasLeft - cost[index++];
            if (currGasLeft < 0)
                return false;
            index = (index + 1) % length;
            currGasLeft += gas[index];
        }
        return true;
    }

    public static void main(String[] args) {
        G_completeCircuit_134 solution = new G_completeCircuit_134();
        int[] gas = { 5, 5, 1, 3, 4 };
        int[] cost = { 8, 1, 7, 1, 1 };
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    /**
     * https://programmercarl.com/0134.%E5%8A%A0%E6%B2%B9%E7%AB%99.html#%E8%B4%AA%E5%BF%83%E7%AE%97%E6%B3%95-%E6%96%B9%E6%B3%95%E4%BA%8C
     * 
     * 只要总的油量大于总的消耗，就一定存在唯一一个解。
     * 如果能从i+1跑到n-1，就一定是唯一解。
     * 如果不是从i+1出发而是从后面的某一点k出发，既然都能跑到n-1了那么从i+1到k油肯定是够的，也就是说i+1也可以绕一圈。这样就不是唯一解了
     */
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curSum = 0;
            int totalSum = 0;
            int index = 0;
            for (int i = 0; i < gas.length; i++) {
                curSum += gas[i] - cost[i];
                totalSum += gas[i] - cost[i];
                if (curSum < 0) {
                    index = (i + 1) % gas.length ; 
                    curSum = 0;
                }
            }
            if (totalSum < 0) return -1;
            return index;
        }
    }
}
