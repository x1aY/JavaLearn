package leetcode.CodeCaprice.AF_stackQueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;

public class E_evalRPN_150 {

    Set<String> opSet;

    Map<String, BiFunction<Integer, Integer, Integer>> funcMap;

    public int evalRPN(String[] tokens) {
        opSet = genOpSet();
        funcMap = genFuncMap();
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (opSet.contains(token)) {
                stack.add(compute(stack, token));
            } else {
                stack.add(str2int(token));
            }
        }
        return stack.peek();
    }

    public int compute(Stack<Integer> stack, String operater) {
        if (stack.size() < 2)
            return 201;
        int second = stack.pop(), first = stack.pop();
        return funcMap.get(operater).apply(first, second);
    }

    public int str2int(String intStr) {
        return Integer.valueOf(intStr);
    }

    public Set<String> genOpSet() {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        return set;
    }

    public Map<String, BiFunction<Integer, Integer, Integer>> genFuncMap() {
        BiFunction<Integer, Integer, Integer> add = (first, second) -> first + second;
        BiFunction<Integer, Integer, Integer> minus = (first, second) -> first - second;
        BiFunction<Integer, Integer, Integer> mul = (first, second) -> first * second;
        BiFunction<Integer, Integer, Integer> div = (first, second) -> first / second;
        Map<String, BiFunction<Integer, Integer, Integer>> funcMap = new HashMap<>();
        funcMap.put("+", add);
        funcMap.put("-", minus);
        funcMap.put("*", mul);
        funcMap.put("/", div);
        return funcMap;
    }

    public static void main(String[] args) {
        E_evalRPN_150 solution = new E_evalRPN_150();
        String[] tokens = { "4", "13", "5", "/", "+" };
        System.out.println(solution.evalRPN(tokens));
    }

}
