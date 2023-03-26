package leetcode.LeetcodeHot100.AA_fst50;
import leetcode.LeetcodeHot100.LcHotCommon.ListNode;

public class AB_addTwoNum_2 {
    public static void main(String[] args) {
        AB_addTwoNum_2 solution = new AB_addTwoNum_2();
        ListNode l1 = ListNode.GenList(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        ListNode l2 = ListNode.GenList(new int[] { 9, 9, 9, 9 });
        solution.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(), preNode = res, currNode;
        int l1Val, l2Val, sumNum, addNum = 0, currNum;
        while (l1 != null || l2 != null) {
            l1Val = l1 == null ? 0 : l1.val;
            l2Val = l2 == null ? 0 : l2.val;
            sumNum = l1Val + l2Val + addNum;
            currNum = sumNum % 10;
            addNum = sumNum / 10;
            currNode = new ListNode(currNum);
            preNode.next = currNode;
            preNode = currNode;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (addNum != 0)
            preNode.next = new ListNode(addNum);
        return res.next;
    }
}
