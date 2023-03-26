package leetcode.Labuladong.F_DfsBfs.D_Bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class B_openLock_752 {
    public int openLock(String[] deadends, String target) {
        int openTimes = 0, goal = 10000;

        Set<Integer> deadSet = new HashSet<>();
        for (String deadi : deadends)
            deadSet.add(Integer.valueOf("1" + deadi));
        if (deadSet.contains(goal))
            return -1;

        // 反向 不然可能队列太长
        int origin = Integer.valueOf("1" + target);
        if (goal == origin)
            return 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(origin);

        int layerSize, curr, clockInt, antiClockInt;
        while (!queue.isEmpty()) {
            openTimes++;
            layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                curr = queue.poll();
                for (int j = 1; j <= 4; j++) {
                    clockInt = rotateInt(curr, j, true);
                    antiClockInt = rotateInt(curr, j, false);
                    // 拿到数字就判断，避免堆到后面，队列太长
                    if (goal == clockInt || goal == antiClockInt)
                        return openTimes;
                    // 拿到数字就加入deadends，避免数量爆炸
                    if (!deadSet.contains(clockInt)) {
                        queue.add(clockInt);
                        deadSet.add(clockInt);
                    }
                    if (!deadSet.contains(antiClockInt)) {
                        queue.add(antiClockInt);
                        deadSet.add(antiClockInt);
                    }
                }
            }
        }
        return -1;
    }

    public int[] rotates(int curr) {
        int[] rotates = new int[8];
        for (int j = 1; j <= 4; j++) {
            rotates[j - 1] = rotateInt(curr, j, true);
            rotates[j + 3] = rotateInt(curr, j, false);
        }
        return rotates;
    }

    public int rotateInt(int curr, int place, boolean isClockwise) {
        place = (int) Math.pow(10, place - 1);
        int placeNum = curr / place % 10;
        if (!isClockwise)
            place = -place;
        if ((isClockwise && placeNum == 9) || (!isClockwise && placeNum == 0))
            curr -= place * 10;
        return curr + place;
    }

    public List<String> openLockPath(String[] deadends, String target) {
        List<String> path = new ArrayList<>();
        Set<String> stops = new HashSet<>();
        for (String deadi : deadends) stops.add(deadi);

        Map<String, String> son2fr = new HashMap<String, String>();

        Queue<String> queue = new ArrayDeque<>();
        String start = "0000", end = target;
        queue.add(start);

        ALL_LOOP: while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                String curr = queue.poll();
                for (String next : NextLock(curr, stops, son2fr.keySet())) {
                    son2fr.put(next, curr);
                    if (next.equals(end)) break ALL_LOOP;
                    queue.add(next);
                }
            }
        }
        String curr = end;
        while(!curr.equals(start)){
            System.out.println(curr);
            curr = son2fr.get(curr);
        }
        System.out.println(start);
        return path;
    }

    public List<String> NextLock(String currLock, Set<String> stops, Set<String> usedLock) {
        List<String> lists = new ArrayList<>();
        char[] currList = currLock.toCharArray();
        for (int i = 0; i < 4; i++) {
            char currChar = currList[i], nextClock = currList[i], nextAntiClock = currList[i];

            nextClock = nextClock == '9' ? '0' : ++nextClock;
            currList[i] = nextClock;
            String nextClockStr = String.valueOf(currList);
            if (!stops.contains(nextClockStr) && !usedLock.contains(nextClockStr))
                lists.add(nextClockStr);

            nextAntiClock = nextAntiClock == '0' ? '9' : --nextAntiClock;
            currList[i] = nextAntiClock;
            String nextAntiClockStr =String.valueOf(currList);
            if (!stops.contains(nextAntiClockStr) && !usedLock.contains(nextAntiClockStr))
                lists.add(nextAntiClockStr);

            currList[i] = currChar;
        }

        return lists;
    }

    public static void main(String[] args) {
        B_openLock_752 solution = new B_openLock_752();

        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";

        solution.openLockPath(deadends, target);
        // solution.NextLock("0239", new HashSet<>(), new HashSet<>());
    }
}
