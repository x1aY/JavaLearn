package leetcode.Labuladong.A_DataStructure.B_differential;
import java.util.Arrays;

public class CorpFlightBookings_1109 {
    
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];
        int[] res = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            diff[bookings[i][0]-1] += bookings[i][2];
            diff[bookings[i][1]] -= bookings[i][2];
        }
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] + diff[i];
        }
        System.out.println(Arrays.toString(diff));
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,2,15}};
        int n = 2;
        corpFlightBookings(bookings,n);
    }

}
