package leetcode.Labuladong.A_DataStructure.E_binarySearch;

public class MinEatingSpeed_875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0, mid = 0;
        // 加法可能超过int最值
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (canEat(piles, h, mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static boolean canEat(int[] piles, int h, int speed) {
        if (speed == 0)
            return false;
        int currHour = 0;
        for (int pile : piles) {
            // 向上取整
            currHour += (pile - 1) / speed + 1;
        }
        return currHour <= h;
    }

    public static void main(String[] args) {
        int[] piles = { 332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077,
                337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728,
                941802184 };
        int h = 823855818;
        System.out.println(minEatingSpeed(piles, h));
    }
}
