package exams.history.tencentMusic_0323;
public class Third {

    public static void main(String[] args) {
        Third ans = new Third();
        String str = "aABbbc";
        ans.getCnt(str);
    }

    public int getCnt(String str) {
        // write code here
        int ans = 0;
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i], pre = chars[i - 1];
            if ((int) curr > (int) pre) {
                curr = chars[i - 1];
                pre = chars[i];
            }
            if (curr == pre||getLower(curr)==pre)
                ans++;
        }
        return ans;
    }

    public char getLower(char a) {
        return (char) ((int) a + 32);
    }
}
