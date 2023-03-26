package leetcode.Labuladong.A_DataStructure.F_bracket;
import java.util.Stack;

public class MinIsertions_1541 {

    // 思路复杂
    public static int minInsertions(String s) {
        int count = 0;
        Stack<Character> myStack = new Stack<>();
        char leftBracket = '(', rightBracket = ')';
        for (char c : s.toCharArray()) {
            if (c == leftBracket)
                myStack.push(c);
            else {
                if (!myStack.empty()) {
                    if (myStack.peek() == rightBracket) {
                        myStack.pop();
                        if (myStack.empty() || myStack.pop() == rightBracket)
                            count++;
                    } else
                        myStack.push(c);
                } else
                    myStack.push(c);
            }
        }
        int stackSize = myStack.size();
        if (stackSize != 0) {
            if (myStack.peek() == rightBracket) {
                myStack.pop();
                if (myStack.empty())
                    count += 2;
                else if (myStack.size() == 1)
                    count += 1;
                else
                    count += (stackSize - 2) * 2;
            } else
                count += stackSize * 2;
        }
        return count;
    }

    public static int minInsertionsStack(String s) {
        int n = s.length();
        // 需要插入的右括号数量
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(c);
            // 右括号不push
            else {
                if (i + 1 < n && s.charAt(i + 1) == ')')
                    i++;
                else
                    res++;

                // 检查有没有可以匹配的左括号
                if (stack.isEmpty())
                    res++;
                else
                    stack.pop();

            }
        }
        // 插入的右括号数量 + 2倍的'多余的左括号数量'
        return res + 2 * stack.size();
    }

    public static void main(String[] args) {
        String s = "(()))";
        minInsertions(s);
    }
}
