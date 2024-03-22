
public class CoinChange {
    public static int coinChangeWays(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: There is 1 way to make 0 change (by using no coins)

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 3, 5, 7};
        int amount1 = 8;
        System.out.println("Total number of ways for coins {1, 3, 5, 7} and amount 8: " + coinChangeWays(coins1, amount1));

        int[] coins2 = {1, 2, 3};
        int amount2 = 4;
        System.out.println("Total number of ways for coins {1, 2, 3} and amount 4: " + coinChangeWays(coins2, amount2));
    }
}
