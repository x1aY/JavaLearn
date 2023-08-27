package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Heap<T> {

    List<T> heapList;

    int currLen = 0;

    private Comparator<T> compare;

    public Heap(Comparator<T> comparator) {
        this.compare = comparator;
        this.heapList = new ArrayList<T>();
    }

    public Heap(List<T> list, Comparator<T> comparator) {
        this.compare = comparator;
        this.heapList = buildHeap(list);
        this.currLen = this.heapList.size();
    }

    /* 堆排序, 下沉操作sink */

    public List<T> heapSort(List<T> list) {
        list = buildHeap(list);
        for (int i = list.size() - 1; i > 0; i--) {
            swapVal(list, 0, i);
            sinkDown(list, 0, i);
        }
        Collections.reverse(list);
        return list;
    }

    public void heapSort() {
        for (int i = currLen - 1; i > 0; i--) {
            swapVal(heapList, 0, i);
            sinkDown(heapList, 0, i);
        }
        Collections.reverse(heapList);
    }

    /**
     * // https://juejin.cn/post/6988843926752854046
     * 所有元素已知时，创建堆的操作选择，下沉要优于上浮：叶子元素多，上浮使用叶子元素而下沉使用父节点
     * 上浮时间复杂度：O(nlog(n))，下沉时间复杂度：O(n)
     *
     * 从最后一个父节点向上遍历：
     * 堆排序定义的交换顺序是从当前结点往下交换，假设这是大顶堆，则这个子树中的最大的都在子树的顶端，
     * 如果在底下（比如叶子）有一个最大的数字，这个数字最多和他的父元素交换，而不会跑到最顶上去
     */
    private List<T> buildHeap(List<T> list) {
        int len = list.size();
        for (int i = parent(len - 1); i >= 0; i--) {
            sinkDown(list, i, len);
        }
        return new ArrayList<>(list);
    }

    /* 下沉操作sink */

    private void sinkDown(List<T> list, int index, int listLen) {
        int tgtChild, lChild, rChild;
        boolean leftSink, rightSink;
        while (inRange(index, listLen)) {
            lChild = LChild(index);
            rChild = RChild(index);
            leftSink = inRange(lChild, listLen) && !inOrder(getItem(list, index), getItem(list, lChild));
            rightSink = inRange(rChild, listLen) && !inOrder(getItem(list, index), getItem(list, rChild));
            if (leftSink && rightSink) {
                tgtChild = inOrder(getItem(list, lChild), getItem(list, rChild)) ? lChild : rChild;
            } else if (leftSink) {
                tgtChild = lChild;
            } else if (rightSink) {
                tgtChild = rChild;
            } else {
                break;
            }
            swapVal(list, index, tgtChild);
            index = tgtChild;
        }
    }

    public T pop() {
        T res = getItem(heapList, 0);
        setItem(heapList, 0, heapList.remove(--currLen));
        sinkDown(heapList, 0, currLen);
        return res;
    }

    /* 添加元素, 上浮操作float */

    public void pushAll(List<T> list) {
        for (T listi : list) {
            push(listi);
        }
    }

    public void push(T item) {
        heapList.add(item);
        floatUp(heapList, currLen++, item);
    }

    private void floatUp(List<T> list, int index, T item) {
        int len = list.size(), pIndex = parent(index);
        while (inRange(pIndex, len) && inOrder(item, getItem(list, pIndex))) {
            swapVal(list, index, pIndex);
            index = pIndex;
            pIndex = parent(pIndex);
        }
    }

    /* 对Comparator接口的再包装 */
    private boolean inOrder(T first, T second) {
        return compare.compare(first, second) < 0;
    }

    /* 基本操作 */
    public int length() {
        return currLen;
    }

    private void swapVal(List<T> list, int first, int second) {
        T temp = getItem(list, first);
        setItem(list, first, getItem(list, second));
        setItem(list, second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int LChild(int index) {
        return index * 2 + 1;
    }

    private int RChild(int index) {
        return index * 2 + 2;
    }

    private T getItem(List<T> list, int index) {
        return list.get(index);
    }

    private T setItem(List<T> list, int index, T val) {
        return list.set(index, val);
    }

    private boolean inRange(int index, int listLen) {
        return 0 <= index && index < listLen;
    }

    @Override
    public String toString() {
        return heapList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
//        Heap<Integer> heap = new Heap<>(
//                Arrays.asList(8, 2, 1, 9, 4, 5, 6, 7, 3),
//                (fst, sec) -> fst - sec);
//
//        heap.push(-1);
//        heap.pushAll(Arrays.asList(18, 12, 11, 19, 24, 35, 16, 27, 23));
//        heap.pop();
//        System.out.println(heap.toString());
//
//        heap.heapSort();
//        System.out.println(heap.toString());
        Heap<Integer> heap = new Heap<>((fst, sec) -> fst - sec);
        System.out.println(heap.heapSort(Arrays.asList(5, 6, 7, 3, 8, 2, 1, 9, 4)));
    }

}