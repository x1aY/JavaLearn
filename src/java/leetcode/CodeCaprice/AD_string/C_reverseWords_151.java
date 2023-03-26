package leetcode.CodeCaprice.AD_string;

public class C_reverseWords_151 {
    public String reverseWords(String s) {
        String[] strs = s.split(" +");
        int end = strs.length - 1;
        StringBuilder sb = new StringBuilder();
        while (end >= 0) {
            if ("".equals(strs[end]))
                end--;
            else
                sb.append(strs[end--]).append(" ");
        }
        int len = sb.length();
        sb.delete(len - 1, len);
        return sb.toString();
    }

    public static void main(String[] args) {
        C_reverseWords_151 solution = new C_reverseWords_151();
        System.out.println(solution.reverseWords("  hello world  "));
    }

}
