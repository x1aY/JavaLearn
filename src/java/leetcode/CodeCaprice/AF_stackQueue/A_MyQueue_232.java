package leetcode.CodeCaprice.AF_stackQueue;

import java.util.Stack;

public class A_MyQueue_232 {
    class MyQueue {

        Stack<Integer> input, output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            dumpstackIn();
            return output.pop();
        }

        public int peek() {
            int res = this.pop();
            output.push(res);
            return res;
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }

        // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
        private void dumpstackIn() {
            if (!output.isEmpty())
                return;
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public static void main(String[] args) {
        A_MyQueue_232 solution = new A_MyQueue_232();
        MyQueue queue = solution.new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }

}
