import java.util.Arrays;


// Approach : Dynamic Programming// Time Complexity: O(n * amount) where n is the number of coins
// Space Complexity: O(amount) for the dp array
// This solution uses a bottom-up dynamic programming approach to solve the Coin Change problem.
// It builds up a solution for all amounts from 0 to the target amount using the given coins.
// The dp array stores the minimum number of coins needed to make each amount from 0 to the target amount.
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// Approach : 2
// Time Complexity: O(n * amount) where n is the number of coins
// Space Complexity: O(amount) for the dp array
// This solution uses a top-down dynamic programming approach with memoization to solve the Coin Change problem.
// It recursively calculates the minimum number of coins needed for each amount, storing results in a memoization
// array to avoid redundant calculations.
class CoinChangeMemoization {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        return coinChangeHelper(coins, amount, memo);
    }

    private int coinChangeHelper(int[] coins, int amount, int[] memo) {
        if (amount < 0) return Integer.MAX_VALUE; // Not possible to make this amount
        if (amount == 0) return 0; // No coins needed to make amount 0
        if (memo[amount] != -1) return memo[amount]; // Return already computed result

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeHelper(coins, amount - coin, memo);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }
        memo[amount] = minCoins; // Store the result in memo array
        return minCoins;
    }
}