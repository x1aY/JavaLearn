package leetcode.Labuladong.A_DataStructure.E_binarySearch;
public class ShipWithinDays_1011 {
    public static int shipWithinDays(int[] weights, int days) {
        int mid, minShipWeight = 0, maxShipWeight = 0;
        for (int i : weights) {
            maxShipWeight += i;
        }
        while (minShipWeight <= maxShipWeight) {
            mid = minShipWeight + (maxShipWeight - minShipWeight) / 2;
            if (canShip(weights, days, mid))
                maxShipWeight = mid - 1;
            else
                minShipWeight = mid + 1;
        }
        return minShipWeight;
    }

    public static boolean canShip(int[] weights, int days, int shipWeight) {
        int totalDays = 0;
        int currTotalWeight = 0;
        for (int weight : weights) {
            if (shipWeight < weight)
                return false;
            currTotalWeight += weight;
            if (currTotalWeight > shipWeight) {
                currTotalWeight = weight;
                totalDays++;
            } else if (currTotalWeight == shipWeight) {
                currTotalWeight = 0;
                totalDays++;
            }
        }
        if (currTotalWeight != 0)
            totalDays++;
        return totalDays <= days;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 10;
        System.out.println(shipWithinDays(weights, days));
    }
}
