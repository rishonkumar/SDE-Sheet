package Arrays1;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class StockBuySell {

    // O(n2)
    public int maxProfitBF(int[] A) {
        int maxPrice = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int currMax = 0;
            for (int j = i + 1; j < n; j++) {
                currMax = A[j] - A[i];
                maxPrice = Math.max(currMax, maxPrice);
            }
        }
        return maxPrice;
    }

    /* TC - O(N)
    We can maintain a minimum from the starting of the array and
    compare it with every element of the array, if it is greater than
    the minimum then take the difference and maintain it in max,
    otherwise update the minimum.
    */

    public int maxProfit(int[] A) {
        int n = A.length;

        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, A[i]);
            maxPrice = Math.max(maxPrice, A[i] - minPrice);
        }
        return maxPrice;
    }


}
