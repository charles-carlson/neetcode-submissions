class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int[] min = new int[]{prices[0]};
        for(int i=0;i<prices.length;i++){
            dp[i] = 0;
        }
        return dp(prices,dp,min,prices.length-1);
    }
    public int dp(int[] prices, int[] dp,int[] min, int i){
        if(i == 0){
            min[0] = prices[0];
            return 0;
        }
        if(dp[i] != 0){
            return dp[i];
        }
        dp(prices, dp, min, i - 1);  
        min[0] = Math.min(prices[i],min[0]);
        dp[i] = Math.max(dp[i-1],prices[i] - min[0]);
        return dp[i];
    }
}
