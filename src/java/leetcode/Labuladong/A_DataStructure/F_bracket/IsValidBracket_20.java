package leetcode.Labuladong.A_DataStructure.F_bracket;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValidBracket_20 {

    // 标准解法
    public static boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> myStack = new Stack<Character>();
        Map<Character, Character> myMap = new HashMap<>();
        myMap.put(')', '(');
        myMap.put(']', '[');
        myMap.put('}', '{');
        Collection<Character> leftBrackets = myMap.values();
        for (char c : s.toCharArray()) {
            if (leftBrackets.contains(c))
                myStack.push(c);
            else if (myStack.empty() || myMap.get(c) != myStack.pop())
                return false;
        }
        return myStack.empty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
