package leetcode.CodeCaprice.AF_stackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class C_validBracket_20 {

    public boolean isValid(String s) {
        Map<Character, Character> charMap = genMap();
        Stack<Character> stack = new Stack<>();
        for (char sChar : s.toCharArray()) {
            if (stack.isEmpty() || charMap.get(stack.peek()) != sChar) {
                stack.push(sChar);
            } else if (charMap.get(stack.peek()) == sChar) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public Map<Character, Character> genMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put(')', 'X');
        map.put('}', 'X');
        map.put(']', 'X');
        return map;
    }

    public static void main(String[] args) {
        C_validBracket_20 solution = new C_validBracket_20();
        System.out.println(solution.isValid("([)]"));
    }
}
