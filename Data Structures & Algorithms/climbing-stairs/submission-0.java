class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        for(int i =0;i<n;i++){
            dp[i] = -1;
        }
        return dp(n,0,dp);
    }
    public int dp(int n, int i, int[] memo){
        if (i == n) return 1;
        if (i > n)  return 0;
        if(memo[i] != -1){
            return memo[i];
        }
        memo[i] = dp(n,i+1,memo) + dp(n,i+2,memo);
        return memo[i];
    }
}
