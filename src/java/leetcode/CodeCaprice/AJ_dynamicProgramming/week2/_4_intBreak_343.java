package leetcode.CodeCaprice.AJ_dynamicProgramming.week2;

public class _4_intBreak_343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        return dp[n];
    }

    public static void main(String[] args) {
        _4_intBreak_343 solution = new _4_intBreak_343();
        System.out.println(solution.integerBreak(10));
    }


    /**
     * https://programmercarl.com/0343.%E6%95%B4%E6%95%B0%E6%8B%86%E5%88%86.html#%E6%80%9D%E8%B7%AF
     * 
     * 因为拆分一个数n 使之乘积最大，那么一定是拆分成m个近似相同的子数相乘才是最大的。
     * 例如 6 拆成 3 * 3， 10 拆成 3 * 3 * 4。 100的话 也是拆成m个近似数组的子数 相乘才是最大的。
     * 只不过我们不知道m究竟是多少而已，但可以明确的是m一定大于等于2，既然m大于等于2，也就是 最差也应该是拆成两个相同的 可能是最大值。
     * 那么 j 遍历，只需要遍历到 n/2 就可以，后面就没有必要遍历了，一定不是最大值。
     */
    class Solution1 {
        public int integerBreak(int n) {
            // dp[i] 为正整数 i 拆分后的结果的最大乘积
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i - j; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
    }

    /**
     * https://leetcode.cn/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
     */
    class Solution {
        public int integerBreak(int n) {
            if (n <= 3)
                return n - 1;
            int a = n / 3, b = n % 3;
            if (b == 0)
                return (int) Math.pow(3, a);
            if (b == 1)
                return (int) Math.pow(3, a - 1) * 4;
            return (int) Math.pow(3, a) * 2;
        }
    }
}
