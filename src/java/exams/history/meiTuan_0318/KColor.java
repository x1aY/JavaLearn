package exams.history.meiTuan_0318;
import java.util.HashMap;
import java.util.Map;

public class KColor {

    public static void main(String[] args) {
        KColor ans = new KColor();
        int[] colors = { 1, 2, 3, 2, 1, 4, 5, 1 };
        ans.maxLen(8, 3, colors);
    }

    // 滑动窗口
    public int maxLen(int n, int k, int[] colors) {
        int ans = 1;
        int left = 0, right = 0;
        Map<Integer, Integer> colorCount = new HashMap<>();
        // 每次都扩张右边一下，可能缩小左边很多下
        while (right < n) {
            // 扩张右边
            int currColor = colors[right++];
            colorCount.put(currColor, colorCount.getOrDefault(currColor, 0) + 1);
            // 大于最大彩带数量，一直缩小左边
            while (colorCount.keySet().size() > k) {
                currColor = colors[left++];
                // 字典减小左边
                colorCount.put(currColor, colorCount.get(currColor) - 1);
                // 为0则从字典中删除
                if (colorCount.get(currColor) == 0)
                    colorCount.remove(currColor);
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

}
