package leetcode.LeetcodeHot100.AC_trd50;

import leetcode.LeetcodeHot100.LcHotCommon.ListNode;

public class G_nodeCircle_142 {

    public static void main(String[] args) {
        G_nodeCircle_142 ans = new G_nodeCircle_142();
        ListNode head = ListNode.GenList(new int[] { 3, 2, 0, -4 });
        ListNode last = head;
        while (last.next != null)
            last = last.next;
        last.next = head.next;
        ans.detectCycle(head);
    }

    // https://leetcode.cn/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
    // https://labuladong.gitee.io/algo/di-ling-zh-bfe1b/shuang-zhi-0f7cc/#判断链表是否包含环
    public ListNode detectCycle(ListNode head) {
        return null;
    }
}
