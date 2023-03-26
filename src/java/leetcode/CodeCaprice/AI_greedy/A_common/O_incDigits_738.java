package leetcode.CodeCaprice.AI_greedy.A_common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class O_incDigits_738 {
    /**
     * 答案错误
     */
    public int monotoneIncreasingDigits(int n) {
        if (n < 10)
            return n;
        List<Integer> nums = getNum(n);
        int len = nums.size();
        for (int i = len - 2; i >= 0; i--) {
            int currNum = nums.get(i), nextNum = nums.get(i + 1);
            if (currNum > nextNum) {
                nums.set(i, currNum - 1);
                int end = (currNum == 1) ? len : i + 2;
                for (int j = i + 1; j < end; j++)
                    nums.set(j, 9);
            } else if (nextNum == 0) {
                for (int j = i + 1; j < len; j++)
                    nums.set(j, 9);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++)
            if (nums.get(i) > 0)
                res += nums.get(i) * Math.pow(10, len - i - 1);
        return (int) res;
    }

    public List<Integer> getNum(int n) {
        List<Integer> list = new ArrayList<>();
        int currNum;
        while (n > 0) {
            currNum = n % 10;
            list.add(currNum);
            n /= 10;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        O_incDigits_738 solution = new O_incDigits_738();
        int n = 101;
        System.out.println(solution.monotoneIncreasingDigits(n));
    }

    /**
     * https://leetcode.cn/problems/monotone-increasing-digits/solution/jian-dan-tan-xin-shou-ba-shou-jiao-xue-k-a0mp/
     */
    class Solution1 {
        public int monotoneIncreasingDigits(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int start = s.length();
            for (int i = s.length() - 2; i >= 0; i--) {
                if (chars[i] > chars[i + 1]) {
                    chars[i]--;
                    start = i + 1;
                }
            }
            Arrays.fill(chars, start, chars.length, '9');
            return Integer.parseInt(String.valueOf(chars));
        }
    }

    /**
     * https://leetcode.cn/problems/monotone-increasing-digits/solution/1111lei-jia-fa-by-wincss-zt83/
     */
    class Solution2 {
        public int monotoneIncreasingDigits(int N) {
            int ones = 111111111;
            int res = 0;
            for(int i=0;i<9;i++){
                while(res+ones>N){
                    ones/=10;
                }
                res += ones;
                if(ones==0)
                break;
            }
            return res;
        }
    }
}