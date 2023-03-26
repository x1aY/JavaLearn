package leetcode.Labuladong.G_dynamicPlanning.C_bag;

public class template {

    public static void WeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];

        /* 
         遍历顺序：先遍历物品，再遍历背包容量
            一维数组遍历背包时必须从大到小遍历，否则会导致重复选取物品； 
            一维数组不用考虑j < weight[i]的情况，直接沿用上一轮的情况   

        一维dp的写法，背包容量一定是要倒序遍历，如果遍历背包容量放在上一层，那么每个dp[j]就只会放入一个物品，即背包里只放入了一个物品。
        例如求dp[4]时，j=4,i=0,需要由max(dp[4], dp[4 - weight[0]] + value[0]),即max(dp[4],dp[3] +value[0])
        由于先遍历的背包容量，因此此时的dp[3]，dp[4]还没有求，仍然为初始值0，此时最大值必然为value[0]，即每个dp[j]相当于只放了一个物品，因此不能先遍历背包容量
         */

        // dp从 index：bagWeight--1 只放价值最大的那个物品
        // for (int i = bagWeight; i > 0; i--) {
        //     for (int j = 0; j <wLen ; j++) {
        //         if(i - weight[j]>=0)
        //             dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
        //     }
        // }

        for (int i = 0; i < wLen; i++){
            // 倒序遍历是为了保证物品i只被放入一次！一旦正序遍历了，那么物品会被重复加入多次！
            // 从后往前循环，每次取得状态不会和之前取得状态重合
            // 对于二维dp，dp[i][j]都是通过上一层即dp[i - 1][j]计算而来，本层的dp[i][j]并不会被覆盖！
            // 倒序遍历的原因是，本质上还是一个对二维数组的遍历，并且右下角的值依赖上一层左上角的值，因此需要保证左边的值仍然是上一层的，从右向左覆盖
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }


    public static void weightbagproblem(int[] weight, int[] value, int bagsize) {
        int wlen = weight.length;
        // 定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];
        /*
         * 初始化：
         * 背包容量为0时，能获得的价值都为0;
         * i为0，存放编号0的物品的时候，各个容量的背包所能存放的最大价值
         * 当 j < weight[0]的时候，dp[0][j] 应该是 0，因为背包容量比编号0的物品重量还小。
         * 当 j >= weight[0]时，dp[0][j] 应该是value[0]，因为背包容量放足够放编号0物品
         */
        for (int i = 0; i <= wlen; i++) { dp[i][0] = 0; }
        for (int j = weight[0]; j <= bagsize; j++) { dp[0][j] = value[0]; }

        // 遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                // 背包容量为j，里面不放物品i的最大价值，此时dp[i][j]就是dp[i - 1][j]
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                // dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，
                // dp[i - 1][j - weight[i]] + value[i] （物品i的价值），就是背包放物品i得到的最大价值
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i <= wlen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[] weight = { 1, 3, 4 };
        int[] value = { 15, 20, 30 };
        int bagsize = 4;
        WeightBagProblem(weight, value, bagsize);
    }

}
