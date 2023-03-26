package leetcode.CodeCaprice.AA_array.A_binarySearch;

public class squareRoot_69 {
    public static int NewtonSqrt(int x) {
        double myExp = 1e-5;
        double curr = x, pre = 0;
        while (true) {
            pre = curr;
            // curr = curr - (curr * curr - x) / (2 * curr);
            curr = (curr + x / curr) / 2;
            if(myExp < Math.abs(curr - pre))
                break;
        }
        return (int) curr;
    }

    public static void main(String[] args) {
        System.out.println(NewtonSqrt(8));
    }
}
