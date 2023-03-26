package leetcode.Labuladong.laCommon;

public class TripleNode {
    public int val;
    public TripleNode left;
    public TripleNode right;
    public TripleNode next;
    public static int LEEF = Integer.MIN_VALUE;

    public TripleNode() {
    }

    public TripleNode(int _val) {
        val = _val;
    }

    public TripleNode(int _val, TripleNode _left, TripleNode _right, TripleNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static TripleNode GenBTree(int[] valLayer) {
        int len = valLayer.length;
        long depth = Math.round(Math.log10(len + 1) / Math.log10(2));
        if (len == 0)
            return null;
        TripleNode root = new TripleNode(valLayer[0]);
        root.left = GenSubBTree(valLayer, 1, 1, depth);
        root.right = GenSubBTree(valLayer, 2, 1, depth);
        return root;
    }

    public static TripleNode GenSubBTree(int[] valList, int currIndex, long currDepth, long depth) {
        if (currDepth == depth || valList[currIndex] == LEEF)
            return null;
        int leftIndex = 2 * currIndex + 1;
        TripleNode currNode = new TripleNode(valList[currIndex]);
        currNode.left = GenSubBTree(valList, leftIndex, currDepth + 1, depth);
        currNode.right = GenSubBTree(valList, leftIndex + 1, currDepth + 1, depth);
        return currNode;
    }
}
