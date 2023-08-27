package DataStrcuture;

import java.util.NoSuchElementException;

/**
 * 算法4作者讲解：https://www.bilibili.com/video/BV14z4y1U7uQ/?p=43&vd_source=07b539a448e5d2ec10b50d615b5e56f3
 * https://zhuanlan.zhihu.com/p/273829162
 * https://zhuanlan.zhihu.com/p/95892351
 */
public class RBT<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;// 定义RED为true
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value val;
        int size;
        boolean color;
        Node left, right;

        Node(Key key, Value value, int size, boolean color) {
            this.key = key;
            this.val = value;
            this.size = size;
            this.color = color;
        }
    }

    /***************************************************************************
    *  put
    ***************************************************************************/

    // 传入的h是指向红链接左端的指针, 方法返回一个指向旋转后的新节点的引用
    private Node rotateLeft(Node h) {
        assert (h != null) && isRed(h.right);
        // x 等于红链接右侧的节点
        Node x = h.right;
        // 然后将x的左连接挂到h的右连接上去
        h.right = x.left;
        // 将h挂到x的左连接上
        x.left = h;
        // 将x设置成h的颜色
        x.color = h.color;
        // 将h设置成红色, 表示x->h是红链接
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        // 返回对x的引用
        return x;
    }

    // 右旋和左旋只要交换left和right即可
    private Node rotateRight(Node h) {
        assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        // 设置两个子节点为黑色
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    // 对外暴露的API, 强制设置根节点为黑色
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        // 直到找到空结点, 返回一个新的固定为红色的节点
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        // 这是插入的代码, 不断递归寻找, 更新或者插入新节点
        // 找到后递归的返回整理过的红黑树的根节点
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        
        // 成功插入的时候, 此时当前的h就是新节点的父节点
        // 不满足LLRB的左倾限制, fix-up any right-leaning links
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        // 右旋后就是这个状态，继续这个操作
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;// 更新走过的节点的N值
        return h;
    }

   /***************************************************************************
    *  delete
    ***************************************************************************/

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left)) h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    // delete the key-value pair with the maximum key rooted at h
    private Node deleteMax(Node h) {
        if (isRed(h.left)) h = rotateRight(h);
        if (h.right == null) return null;
        if (!isRed(h.right) && !isRed(h.right.left)) h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    // delete the key-value pair with the given key rooted at h
    private Node delete(Node h, Key key) {

        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else
                h.right = delete(h.right, key);
        }
        return balance(h);
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    // restore red-black tree invariant
    private Node balance(Node h) {

        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.val;
        }
        return null;
    }

    // the smallest key in subtree rooted at x; null if no such key
    private Node min(Node x) {
        // assert x != null;
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

}
