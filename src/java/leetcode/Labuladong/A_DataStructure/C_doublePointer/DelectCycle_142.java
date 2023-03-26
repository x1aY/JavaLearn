package leetcode.Labuladong.A_DataStructure.C_doublePointer;
import java.util.HashSet;
import java.util.Set;

import leetcode.Labuladong.laCommon.ListNode;

public class DelectCycle_142 {

    public static ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public static ListNode detectCycleDoublePointer(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head, fast = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = head;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.GenList(
                new int[] { 3, 2, 0, -4 });
        ListNode last = list.next.next.next;
        last.next = list.next;
        System.out.println(detectCycle(list).val);
    }
}
