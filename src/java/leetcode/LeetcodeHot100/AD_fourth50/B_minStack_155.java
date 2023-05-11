package leetcode.LeetcodeHot100.AD_fourth50;

import java.util.Stack;

public class B_minStack_155 {

    class MinStack {
        public MinStack() {

        }

        public void push(int val) {

        }

        public void pop() {

        }

        public int top() {
            return 0;
        }

        public int getMin() {
            return 0;
        }
    }

    /**
     *  思路：每次入栈2个元素，一个是入栈的元素本身，一个是当前栈元素的最小值
     *  如：入栈序列为2-3-1，则入栈后栈中元素序列为：2-2-3-2-1-1 * 用空间代价来换取时间代价
     * */
    class Solution{

        Stack<Integer> stack;

        public Solution() {
            stack = new Stack<Integer>();
        }

        public void push(int x) {
            if(stack.isEmpty()){
                stack.push(x);
                stack.push(x);
            }else{
                int tmp = stack.peek();
                stack.push(x);
                if(tmp<x){
                    stack.push(tmp);
                }else{
                    stack.push(x);
                }
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            return stack.get(stack.size()-2);
        }

        public int getMin() {
            return stack.peek();
        }
    }
}
