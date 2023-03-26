package leetcode.LeetcodeHot100.AA_fst50;

import java.util.Arrays;
import java.util.PriorityQueue;

import leetcode.LeetcodeHot100.LcHotCommon.ListNode;

public class AL_mergeKList_23 {

    public static void main(String[] args) {
        AL_mergeKList_23 solution = new AL_mergeKList_23();
        ListNode[] lists = new ListNode[] {
                ListNode.GenList(new int[] { 1, 4, 5 }),
                ListNode.GenList(new int[] { 1, 3, 4 }),
                ListNode.GenList(new int[] { 2, 6 })
        };
        solution.mergeKLists(lists);
    }

    // 太慢 有更好方法
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode virtualHead = new ListNode();
        int listLen = lists.length, totalLen = 0;
        if (listLen == 0)
            return virtualHead.next;
        ListNode[] heads = Arrays.copyOf(lists, listLen);
        for (int i = 0; i < listLen; i++)
            while (heads[i] != null) {
                totalLen++;
                heads[i] = heads[i].next;
            }
        ListNode currNode = virtualHead, maxNode = new ListNode(Integer.MAX_VALUE);
        for (int i = 0; i < totalLen; i++) {
            int minIndex = -1;
            ListNode currMin = maxNode;
            for (int j = 0; j < listLen; j++) {
                if (lists[j] != null && currMin.val >= lists[j].val) {
                    currMin = lists[j];
                    minIndex = j;
                }
            }
            lists[minIndex] = lists[minIndex].next;
            currNode.next = currMin;
            currNode = currMin;
        }
        return virtualHead.next;
    }

    class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (int i = 0; i < lists.length; i++)
                if (lists[i] != null) pq.add(lists[i]);
            ListNode virtualHead = new ListNode(), currNode = virtualHead, pqMin;
            while (!pq.isEmpty()) {
                pqMin = pq.poll();
                if (pqMin.next != null) pq.add(pqMin.next);
                currNode.next = pqMin;
                currNode = currNode.next;
            }
            return virtualHead.next;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }
    
        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = (l + r) >> 1;
            return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
        }
    
        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }

}