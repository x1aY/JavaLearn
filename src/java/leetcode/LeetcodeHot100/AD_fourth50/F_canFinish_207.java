package leetcode.LeetcodeHot100.AD_fourth50;

import java.lang.reflect.Array;
import java.util.*;

public class F_canFinish_207 {

    public static void main(String[] args) {
        F_canFinish_207 solution = new F_canFinish_207();
        int numCourses = 2;
        int[][] preReq = new int[][]{{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(numCourses, preReq));
    }

    public boolean canFinish(int crsLen, int[][] prerequisites) {
        return true;
    }

    // https://leetcode.cn/problems/course-schedule/solution/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/
    // https://leetcode.cn/problems/course-schedule-ii/solution/tuo-bu-pai-xu-shen-du-you-xian-bian-li-python-dai-/
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegrees = new int[numCourses];//用于存储每个点（数字）的度
            List<List<Integer>> adjacency = new ArrayList<>();//邻接表的准备
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }//事先创建空的arraylist
            for (int[] cp : prerequisites) {
                indegrees[cp[0]]++;//cp[0]这个数前面连接了一个数cp[1]，所以度+1
                adjacency.get(cp[1]).add(cp[0]);//创建连接表,在cp[1]对应的位置,放入后连接的一个数字也就是cp[0],
                //一个cp[1]可能对应多个cp[0],例如[2,3][2,4],list里的对应2的list便放入3,4两个数字，这里一定要理清楚
            }
            for (int i = 0; i < numCourses; i++) {
                if (indegrees[i] == 0)//如果度为0入队列
                    queue.add(i);
            }
            while (!queue.isEmpty()) {
                int pre = queue.poll();//弹出度为0的数，其实也就是准备删除
                numCourses--;//删除后个数减少1，对应作者的图可以理解
                for (int cur : adjacency.get(pre)) {//找到入度0连接后面的数字们遍历，例如遍历上面2后连接的3,4
                    if (--indegrees[cur] == 0) {//并且将他们的入度同时-1，如果此时度为0，继续入队列
                        queue.add(cur);
                    }
                }
            }
            return numCourses == 0;
        }
    }
}
