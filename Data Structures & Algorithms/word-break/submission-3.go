func wordBreak(s string, wordDict []string) bool {
    memo := make([]int8, len(s))
    return dp(s,wordDict, memo, 0)
}
func dp(s string, wordDict []string, memo []int8, i int) bool {
    if i == len(s){
        return true
    }
    if memo[i] != 0{
        return memo[i] == 1
    }
    memo[i] = -1
    for j:=0;j<len(wordDict);j++{
        word := wordDict[j]
        candidate := strings.HasPrefix(s[i:],word) && dp(s,wordDict,memo,i+len(word))
        if candidate{
            memo[i] = 1
            return true
        }
        
    }
    return false
}