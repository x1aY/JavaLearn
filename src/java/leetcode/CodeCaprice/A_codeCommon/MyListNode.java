package leetcode.CodeCaprice.A_codeCommon;
public class MyListNode {
    public int val;
    public MyListNode next;

    MyListNode() {
    }

    MyListNode(int val) {
        this.val = val;
    }

    MyListNode(int val, MyListNode next) {
        this.val = val;
        this.next = next;
    }

    public static MyListNode GenList(int[] nums) {
        if (nums.length < 1)
            return null;
        MyListNode head = new MyListNode(nums[0]);
        MyListNode pre = head, curr = null;
        for (int i = 1; i < nums.length; i++) {
            curr = new MyListNode(nums[i]);
            pre.next = curr;
            pre = curr;
        }
        if (curr != null)
            curr.next = null;
        return head;
    }

    public static void PrintList(MyListNode list) {
        while (list != null) {
            System.out.print(list.val);
            System.out.print(", ");
            list = list.next;
        }
    }
}
