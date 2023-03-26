package leetcode.LeetcodeHot100.AA_fst50;
import leetcode.LeetcodeHot100.LcHotCommon.ListNode;

public class AJ_removeNthFromEnd_19 {

    public static void main(String[] args) {
        AJ_removeNthFromEnd_19 solution = new AJ_removeNthFromEnd_19();
        ListNode head = ListNode.GenList(new int[] { 1,2,3,4,5 });
        solution.removeNthFromEnd(head, 2);
    }

    // 快慢指针 只需要一次遍历
    // https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solution/dong-hua-tu-jie-leetcode-di-19-hao-wen-ti-shan-chu/
    // 设置虚拟头节点 避免复杂讨论
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtualHead = new ListNode();
        virtualHead.next = head;
        int nodeCount = 0, currCount = 0;
        for (ListNode node = head; node != null; node = node.next)
            nodeCount++;
        ListNode delNodePre = virtualHead;
        while (currCount++ != nodeCount - n)
            delNodePre = delNodePre.next;
        delNodePre.next = delNodePre.next.next;
        return virtualHead.next;
    }

}
