package leetcode.Labuladong.A_DataStructure.F_bracket;
import java.util.Stack;

public class MinAddToMakeValid_921 {
    public static int minAddToMakeValid(String s) {
        Stack<Character> myStack = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                myStack.push(c);
            else if (myStack.empty() || myStack.pop() == ')')
                count++;
        }
        return count + myStack.size();
    }

    public static void main(String[] args) {
        String s = "(((";
        minAddToMakeValid(s);
    }
}
