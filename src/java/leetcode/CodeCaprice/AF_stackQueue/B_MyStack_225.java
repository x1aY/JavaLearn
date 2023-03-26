package leetcode.CodeCaprice.AF_stackQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class B_MyStack_225 {

    Queue<Integer> queue;

    class MyStack {

        public MyStack() {
            queue = new ArrayDeque<>();
        }
        
        public void push(int x) {
            queue.add(x);
            int size = queue.size();
            //移动除了 A 的其它数
            while (size-- > 1)
                queue.add(queue.poll());
        }
        
        public int pop() {
            return queue.poll();
        }
        
        public int top() {
            return queue.peek();
        }
        
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    
    public static void main(String[] args) {
        B_MyStack_225 solution = new B_MyStack_225();
        MyStack stack = solution.new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
