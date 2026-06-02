class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //i + j = -k
        // or iterate over i, with inner loop using two sum method
        // i + j + k == 0 j + k == -i
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        for(int i=0;i<n;i++){
            int j = i+1;
            int k = n-1;
            int target = -1 * nums[i];
            while(j < k){
                if (nums[j] + nums[k] == target){
                    List<Integer> res = List.of(nums[i],nums[j],nums[k]);
                    if (!output.contains(res)){
                        output.add(res);
                    }
                    j++;
                    k--;
                } else if(nums[j] + nums[k] < target){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return output;
    }
}
