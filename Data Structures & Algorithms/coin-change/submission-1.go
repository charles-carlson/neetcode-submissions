func coinChange(coins []int, amount int) int {
    memo := make([]int,amount+1)
    for i:=0;i<=amount;i++{
        memo[i] = amount+1
    }
    return dp(coins,memo,amount,amount+1)
}
func dp(coins, memo []int, amount,upperBound int) int {
    if amount == 0{
        return 0
    }
    if amount < 0 {
        return -1
    }
    if memo[amount] != upperBound {
        return memo[amount]
    }
    for c := range coins{
        candidate := dp(coins,memo, amount - coins[c],upperBound)
        if candidate != -1{
            memo[amount] = min(memo[amount],1+candidate)
        }
    }
    if memo[amount] == upperBound {
        memo[amount] = -1
    }
    return memo[amount]
}
