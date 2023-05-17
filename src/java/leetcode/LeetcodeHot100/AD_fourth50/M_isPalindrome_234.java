package leetcode.LeetcodeHot100.AD_fourth50;

import leetcode.LeetcodeHot100.LcHotCommon.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M_isPalindrome_234 {

    public static void main(String[] args) {
        M_isPalindrome_234 solution = new M_isPalindrome_234();
        System.out.println(solution.isPalindrome(ListNode.GenList(new int[]{1, 2, 2, 1})));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fst = head, sec = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (sec!=null && sec.next != null) {
            sec = sec.next.next;
            stack.push(fst.val);
            fst = fst.next;
        }
        // 链表长度为奇数
        if(sec!=null)
            fst = fst.next;
        while (fst!=null) {
            if (fst.val != stack.pop())
                return false;
            fst = fst.next;
        }
        return true;
    }

}
