package leetcode.LeetcodeHot100.AA_fst50;

public class AG_maxArea_11 {

    public static void main(String[] args) {
        AG_maxArea_11 solution = new AG_maxArea_11();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        solution.maxArea(height);
    }
    
    // https://leetcode.cn/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
    // https://leetcode.cn/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
    public int maxArea(int[] heights) {
        return 0;
    }

    public int getArea(int[] heights, int idxA, int idxB) {
        return Math.min(heights[idxA], heights[idxB]) * (idxB - idxA);
    }

}
