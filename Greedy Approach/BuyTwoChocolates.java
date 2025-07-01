import java.util.Arrays;

public class BuyTwoChocolates {
    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4, 5};
        int budget = 7;
        System.out.println(maxChocolates(prices, budget));
    }

    public static int maxChocolates(int[] prices, int budget) {
        Arrays.sort(prices);
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (budget >= prices[i]) {
                budget -= prices[i];
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}