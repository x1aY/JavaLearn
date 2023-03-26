package leetcode.Labuladong.A_DataStructure.Z_reverseLink;
import leetcode.Labuladong.laCommon.ListNode;

public class ReverseBetween_92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int currCount = 1;
        ListNode curr = head, leftNodePre = null;
        while (currCount != left && curr != null) {
            leftNodePre = curr;
            curr = curr.next;
            currCount++;
        }
        ListNode leftNode = curr, currPre = curr, currNext = null;
        if (curr != null) {
            curr = curr.next;
            currCount++;
        }
        while (currCount != right + 1 && curr != null) {
            currNext = curr.next;
            curr.next = currPre;
            currPre = curr;
            curr = currNext;
            currCount++;
        }
        leftNode.next = curr;
        if (leftNodePre == null) {
            return currPre;
        } else {
            leftNodePre.next = currPre;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.GenList(
                new int[] { 1, 2 });
        int left = 1, right = 2;
        ListNode.PrintList(reverseBetween(list, left, right));
    }
}
