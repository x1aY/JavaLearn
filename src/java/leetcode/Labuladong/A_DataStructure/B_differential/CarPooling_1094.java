package leetcode.Labuladong.A_DataStructure.B_differential;
public class CarPooling_1094 {
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        int startMile=1000,endMile=0;
        for (int i = 0; i < trips.length; i++) {
            startMile=startMile>trips[i][1]?trips[i][1]:startMile;
            endMile=endMile<trips[i][2]?trips[i][2]:endMile;
            diff[trips[i][1]] += trips[i][0];
            diff[trips[i][2]] -= trips[i][0];
        }
        int preRes=0,currRes;
        System.out.println(startMile);
        System.out.println(endMile);
        for (int i = startMile; i < endMile + 1; i++) {
            currRes = preRes + diff[i];
            System.out.print(currRes);System.out.print(", ");
            if(currRes>capacity){
                return false;
            }
            preRes = currRes;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
        int capacity = 5;
        System.out.println(carPooling(trips, capacity));
    }
}
