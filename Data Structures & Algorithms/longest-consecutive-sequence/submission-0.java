class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(nums[i]);
        }
        List<Integer> clean = new ArrayList<>(s);
        int best = 0;
        for(Integer num : s){
            int count = 0, curr = num;
            while(s.contains(curr)){
                count++;
                curr++;
            }
            best = Math.max(best,count);
        }
        return best;
    }
}
