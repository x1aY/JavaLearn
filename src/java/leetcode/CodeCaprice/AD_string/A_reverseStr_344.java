package leetcode.CodeCaprice.AD_string;

public class A_reverseStr_344 {
    public void reverseString(char[] s) {
        int len = s.length;
        int start = 0, end = len - 1;
        char tempC = s[start];
        while (start < end) {
            tempC = s[start];
            s[start++] = s[end];
            s[end--] = tempC;
        }
        return;
    }

    public static void main(String[] args) {
        A_reverseStr_344 solution = new A_reverseStr_344();
        char[] s = {
            'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ',
            'a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'
        };
        solution.reverseString(s);
        
    }
}
