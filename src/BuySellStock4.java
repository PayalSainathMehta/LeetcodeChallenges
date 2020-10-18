public class BuySellStock4 {

    static int maximizeProfit(int prices[], int k){
        int n = prices.length;
        //edge case
        if(k == 0 || n == 0)
            return 0;
        if(k >= n / 2){ //max transactions
            int profit = 0;
            //as many much transactions
            for(int i = 1; i < n; i++){
                if(prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }
        //now for atmost one transaction
        int cost = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        int[] profits = new int[n];
        //single transaction
        for(int i = 0; i < n; i++){
            cost = Math.min(cost, prices[i]);
            profit = Math.max(profit, prices[i] - cost);
            profits[i] = profit;
        }
        //repeat k times
        for(int i = 1; i < k; i++){
            ktimes(profits, prices);
        }
        //finally return max
        int maxProfit = Integer.MIN_VALUE;
        for(int p: profits){
            maxProfit = Math.max(maxProfit, p);
        }
        return maxProfit;
    }

    static void ktimes(int[] profits, int[] prices){
        int cost2 = Integer.MAX_VALUE, profit2 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            cost2 = Math.min(cost2, prices[i] - profits[i]); //next buy must be after buy->sell, keep subtracting prev value
            profit2 = Math.max(profit2, prices[i] - cost2);
            profits[i] = profit2;
        }
        return;
    }
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maximizeProfit(prices, k));
    }
}
