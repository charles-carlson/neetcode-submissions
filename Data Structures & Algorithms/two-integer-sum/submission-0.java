class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] out = new int[2];
        for(int i=0;i<nums.length;i++){
            int difference = target - nums[i];
            if (map.containsKey(difference)){
                out[0] = map.get(difference);
                out[1] = i;
            } else{
                map.put(nums[i],i);
            }
        }
        return out;
    }
}
