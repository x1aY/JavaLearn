package leetcode.CodeCaprice.AD_string;

public class B_reverseStr2_541 {

    public String reverseStr(String s, int k) {
        char[] sChar = s.toCharArray();
        int len = sChar.length;
        int counts = len / k, lefts = len % k;
        for (int i = 0; i <= counts; i += 2)
            reverseInterval(sChar, len, i * k, k);
        if (counts % 2 == 0)
            reverseInterval(sChar, len, counts * k, lefts);
        return String.valueOf(sChar);
    }

    public void reverseInterval(char[] chars, int totalLen, int start, int length) {
        int end = start + length - 1;
        if (start > totalLen - 1 || end > totalLen - 1 || length == 0)
            return;
        char tempC = chars[start];
        while (start < end) {
            tempC = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tempC;
        }
        return;
    }

    public static void main(String[] args) {
        B_reverseStr2_541 solution = new B_reverseStr2_541();
        String s = "abcdefg";
        int k = 4;
        System.out.println(solution.reverseStr(s, k));
    }

}
