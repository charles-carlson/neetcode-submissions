class Solution {
    public int[] productExceptSelf(int[] nums) {
        //sort the array

        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] output = new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i=1;i<n;i++){
            prefix[i] = nums[i - 1] * prefix[i-1];
        }
        for(int j=n-2;j>=0;j--){
            suffix[j] = nums[j + 1] * suffix[j+1];
        }
        for(int k = 0;k<n;k++){
            output[k] = prefix[k] * suffix[k];
        }
        return output;
    }
}  
