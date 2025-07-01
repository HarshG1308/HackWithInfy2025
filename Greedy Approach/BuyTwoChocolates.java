import java.util.Arrays;

// Approach: 1 Greedy
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(1) since we are using constant space for variables
class BuyTwoChocolates {
    public int buyChoco(int[] prices, int budget) {
        Arrays.sort(prices);
        return prices[0] + prices[1] > budget ? budget : budget - prices[0] - prices[1];
    }

    public int buyChocoOptimized(int[] prices, int budget) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min1) {
                min2 = min1;
                min1 = price;
            } else if (price < min2) {
                min2 = price;
            }
        }
        return min1 + min2 > budget ? budget : budget - (min1 + min2);
    }

    public static void main(String[] args) {
        BuyTwoChocolates solution = new BuyTwoChocolates();
        int[] prices = {1, 2, 3, 4, 5};
        int budget = 7;
        System.out.println(solution.buyChoco(prices, budget)); // Output: 0
    }
}

// Approach : 2
// Time Complexity: O(n) since we are using a single pass
// Space Complexity: O(1) since we are using constant space for variables