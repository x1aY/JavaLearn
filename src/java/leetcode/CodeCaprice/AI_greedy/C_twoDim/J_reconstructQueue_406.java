package leetcode.CodeCaprice.AI_greedy.C_twoDim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class J_reconstructQueue_406 {

    public class Pair<T, R> {

        public T fst;
        public R sec;

        public Pair(T fst, R sec) {
            this.fst = fst;
            this.sec = sec;
        }

        @Override
        public String toString() {
            return "fst=" + this.fst.toString() + ", sec=" + this.sec.toString();
        }

    }
    /**
     * 排序方式不对
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        int peopleLen = people.length;
        int[][] queue = new int[peopleLen][2];
        Arrays.fill(queue, null);
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < peopleLen; i++)
            list.add(new Pair<Integer, Integer>(people[i][0], people[i][1]));
        list.sort((o1, o2) -> o1.fst == o2.fst ? o1.sec - o2.sec : o1.fst - o2.fst);
        for (Pair<Integer, Integer> pair : list) {
            int index = pair.sec;
            while (queue[index] != null)
                index++;
            int bCount = biggerCount(queue, pair, index);
            if (bCount != pair.sec) {
                while (index < peopleLen && bCount != pair.sec) {
                    if (queue[index] == null || list.get(index).fst >= pair.fst)
                        bCount++;
                    index++;
                }
                while (index < peopleLen && queue[index] != null)
                    index++;
            }
            queue[index] = new int[] { pair.fst, pair.sec };
        }
        return queue;
    }

    public int biggerCount(int[][] queue, Pair<Integer, Integer> currPair, int index) {
        int biggerCount = 0;
        for (int i = 0; i < index; i++)
            if (queue[i] != null)
                biggerCount += queue[i][0] >= currPair.fst ? 1 : 0;
            else
                biggerCount += 1;
        return biggerCount;
    }

    public static void main(String[] args) {
        J_reconstructQueue_406 solution = new J_reconstructQueue_406();
        int[][] people = { { 0, 0 }, { 6, 2 }, { 5, 5 }, { 4, 3 }, { 5, 2 }, { 1, 1 }, { 6, 0 }, { 6, 3 }, { 7, 0 },
                { 5, 1 } };
        solution.reconstructQueue(people);
    }

    /**
     * https://programmercarl.com/0406.%E6%A0%B9%E6%8D%AE%E8%BA%AB%E9%AB%98%E9%87%8D%E5%BB%BA%E9%98%9F%E5%88%97.html#%E6%80%9D%E8%B7%AF
     * 
     * 按照身高排序之后，优先按身高高的people的k来插入，后序插入节点也不会影响前面已经插入的节点，最终按照k的规则完成了队列
     * 
     * 排序完的people： [[7,0], [7,1], [6,1], [5,0], [5,2]，[4,4]]
     * 插入的过程：
     * 插入[7,0]：[[7,0]]
     * 插入[7,1]：[[7,0],[7,1]]
     * 插入[6,1]：[[7,0],[6,1],[7,1]]
     * 插入[5,0]：[[5,0],[7,0],[6,1],[7,1]]
     * 插入[5,2]：[[5,0],[7,0],[5,2],[6,1],[7,1]]
     * 插入[4,4]：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            // 身高从大到小排（身高相同k小的站前面）
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            });
    
            LinkedList<int[]> que = new LinkedList<>();
    
            for (int[] p : people) {
                que.add(p[1],p);
            }
    
            return que.toArray(new int[people.length][]);
        }
    }
}
