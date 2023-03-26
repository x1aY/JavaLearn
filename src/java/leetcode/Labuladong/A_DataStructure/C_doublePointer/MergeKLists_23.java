package leetcode.Labuladong.A_DataStructure.C_doublePointer;
import leetcode.Labuladong.laCommon.ListNode;

public class MergeKLists_23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        
        return null;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[] {
                ListNode.GenList(new int[] { 1, 4, 5 }),
                ListNode.GenList(new int[] { 1, 3, 4 }),
                ListNode.GenList(new int[] { 2, 6 })
        };
        ListNode.PrintList(mergeKLists(lists)); 
    }
}
