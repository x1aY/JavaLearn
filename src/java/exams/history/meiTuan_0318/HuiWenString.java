package exams.history.meiTuan_0318;
public class HuiWenString {

    public static void main(String[] args) {
        HuiWenString ans = new HuiWenString();
        ans.HuiWenStr("abcde");
    }

    public String HuiWenStr(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int rightMin = len / 2;
        if (len % 2 == 1)
            rightMin++;
        int left = 0, right = len - 1;
        int minus = 2;
        while (minus > 0 && right >= rightMin) {
            if (chars[left] > chars[right]) {
                chars[left] = chars[right];
                minus--;
            } else if (chars[left] < chars[right]) {
                chars[right] = chars[left];
                minus--;
            }
            left++;
            right--;
        }

        return String.valueOf(chars);
    }

}
