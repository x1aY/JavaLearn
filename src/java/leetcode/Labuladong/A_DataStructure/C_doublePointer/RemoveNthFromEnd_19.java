package leetcode.Labuladong.A_DataStructure.C_doublePointer;
import leetcode.Labuladong.laCommon.ListNode;

public class RemoveNthFromEnd_19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        ListNode left = head, leftPre = null;
        while (right != null) {
            right = right.next;
            leftPre = left;
            left = left.next;
        }
        if (leftPre != null)
            leftPre.next = left.next;
        else {
            if (head.next != null)
                head = head.next;
            else
                head = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.GenList(new int[] { 1, 2 });
        int n = 2;
        ListNode.PrintList(removeNthFromEnd(list, n));
    }
}
