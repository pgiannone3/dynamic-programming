/**
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 */

package best.time.to.buy;
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int min = prices[0];
        int max = prices[0];

        for(int i = 1; i < prices.length; i++) {

            var actual = prices[i];
            if( actual < min ) {
                min = actual;
                max = actual;
            } else if(actual > max) {
                max = actual;
            }

            int result = max - min;
            if(result > maxProfit) {
                maxProfit = result;
            }
        }
        return maxProfit;
    }
}
