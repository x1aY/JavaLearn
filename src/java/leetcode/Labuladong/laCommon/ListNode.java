package leetcode.Labuladong.laCommon;


public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode GenList(int[] nums) {
        if (nums.length < 1)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode pre = head, curr = null;
        for (int i = 1; i < nums.length; i++) {
            curr = new ListNode(nums[i]);
            pre.next = curr;
            pre = curr;
        }
        if (curr != null)
            curr.next = null;
        return head;
    }

    public static void PrintList(ListNode list) {
        while (list != null) {
            System.out.print(list.val);
            System.out.print(", ");
            list = list.next;
        }
    }
}
