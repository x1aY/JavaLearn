package leetcode.CodeCaprice.AI_greedy.D_range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M_partitionLabel_763 {

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] indexs = new int[26][2];
        for (int i = 0; i < 26; i++) {
            indexs[i][0] = Integer.MAX_VALUE;
            indexs[i][1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
            if (indexs[char2index(chars[i])][1] == Integer.MAX_VALUE)
                indexs[char2index(chars[i])][0] = i;
            indexs[char2index(chars[i])][1] = i;
        }
        Arrays.sort(indexs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] preInt = new int[] { indexs[0][0], indexs[0][1] };
        for (int i = 1; i < 26; i++) {
            int[] currInt = indexs[i];
            if (currInt[0] == Integer.MAX_VALUE)
                continue;
            if (preInt[1] > currInt[0]) {
                preInt[1] = Math.max(preInt[1], currInt[1]);
            } else {
                list.add(preInt[1] - preInt[0] + 1);
                preInt = new int[] { currInt[0], currInt[1] };
            }
        }
        list.add(preInt[1] - preInt[0] + 1);
        return list;
    }

    public int char2index(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        M_partitionLabel_763 solution = new M_partitionLabel_763();
        String s = "eccbbbbdec";
        System.out.println(solution.partitionLabels(s));
    }

}
