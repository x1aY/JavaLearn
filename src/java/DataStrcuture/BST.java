package DataStrcuture;

// important: get, put, delete
public class BST<Key extends Comparable<Key>, Value> {
    
    private Node root;// 根节点

    // 私有内部类Node, 表示一个节点
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size; // 子树中的节点总数

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 返回所有元素的数量
    public int size() {
        return size(root);
    }

    // 返回当前节点的计数器中的值
    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.size;
    }

    // 从根节点查找,实际上以任何节点为根都可以开始查找
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        // 如果当前的key是null, 直接抛异常
        if (key == null)
            throw new IllegalArgumentException("calls get() with a null key");
        // 如果当前的节点是null, 说明没有找到, 返回null
        if (x == null)
            return null;
        // 递归寻找, 让要查找的参数与当前节点的键进行比较, 如果要查的参数小, 就到左节点里去查, 大于当前节点的键, 就到右边去找.
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    public void put(Key key, Value val) {
        // 键为空抛异常
        if (key == null)
            throw new IllegalArgumentException("calls put() with a null key");
        // 正常情况下, 向以根节点展开的树中放入键和值
        root = put(root, key, val);
    }

    // 找到了相符的键就更新此值,如果为空,需要新建节点后返回这个节点.
    // 递归之后, 上一个节点的指针正好指向返回的新节点
    private Node put(Node x, Key key, Value val) {
        // 没有键，新建节点停止递归
        if (x == null)
            return new Node(key, val, 1);
        // 通过递归更新整个树
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;// 找到键，更新值停止递归
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        // 从根节点开始寻找k位置的元素
        Node x = select(root, k);
        return x.key;
    }

    private Node select(Node x, int k) {
        // 节点为空
        if (x == null)
            return null;
        // 取左侧节点的节点数进行判断
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        // 还要减去当前点
        else if (t < k)
            return select(x.right, k - t - 1);
        else
            return x;
    }

    public Key min() throws Exception {
        if (isEmpty())
            throw new Exception("calls min() with empty symbol table");
        return min(root).key;
    }

    // 如果左链接是空, 就返回当前节点, 否则返回左边的节点
    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Key max() throws Exception {
        if (isEmpty())
            throw new Exception("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    public int rank(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    // 节点在二叉树中的排名
    private int rank(Key key, Node x) {
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    public void deleteMin() throws Exception {
        if (isEmpty())
            throw new Exception("Symbol table underflow");
        root = deleteMin(root);
    }

    // 找到左子结点为空的结点A, 返回其右结点就相当于删除A
    // 最后返回的是删除最小点后的根
    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        // 如果不为空递归向下寻找
        x.left = deleteMin(x.left);
        // 完成之后更新结点计数器
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        // 没找到
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        // 找到了要删除的节点
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            // 用临时变量t保存被删除的节点
            // 用临时变量x指向min(t.right)，用x替换t
            Node t = x;
            x = min(t.right);
            // 将x的right指针指向 deleteMin(t.right)返回的已不带有最小值的子树的根
            x.right = deleteMin(t.right);
            // 将x的左指针指向t.left, 即和被删除的节点一样
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

}
