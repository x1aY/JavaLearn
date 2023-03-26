package leetcode.CodeCaprice.AF_stackQueue;

import java.util.Stack;

public class D_removeDup_1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char sChar : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != sChar)
                stack.push(sChar);
            else if (stack.peek() == sChar)
                stack.pop();
        }
        char[] charList = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--)
            charList[i] = stack.pop();
        return String.valueOf(charList);
    }

    public static void main(String[] args) {
        D_removeDup_1047 solution = new D_removeDup_1047();
        System.out.println("String: "+solution.removeDuplicates("abba")+"end");
    }
}
