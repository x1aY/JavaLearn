package leetcode.Labuladong.G_dynamicPlanning.A_core;

public class A_fib_509 {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;
        for (int i = 2; i < n + 1; i++)
            fibList[i] = fibList[i - 2] + fibList[i - 1];

        return fibList[n];
    }

    public static void main(String[] args) {
        A_fib_509 solution = new A_fib_509();
        System.out.println(solution.fib(4));
    }
}
