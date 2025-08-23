public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l = 0;
        int r = 1;
        int max = 0;

        while (r < n) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                max = Math.max(profit, max);
            }
            else {
                l = r;
            }

            r++;
        }

        return max;
    }
}
