func maxProduct(nums []int) int {
    maxEnding := nums[0]
    maxStarting := nums[0]
    minProd := nums[0]
    for i:=1;i<len(nums);i++{
        newMax :=  max(nums[i],maxEnding * nums[i], minProd * nums[i])
        newMin := min(nums[i],maxEnding * nums[i], minProd * nums[i])
        maxEnding = newMax
        minProd = newMin
        maxStarting = max(maxStarting,maxEnding,minProd)
    }
    return maxStarting
}
