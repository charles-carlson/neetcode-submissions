class Solution {
    List<List<Integer>> result;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        candidates = nums;
        Deque<Integer> current = new ArrayDeque<>();
        backtrack(0,current,target);
        return result;
    }
    public void backtrack(int start, Deque<Integer> current, int remaining){
        if (remaining == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if (remaining < 0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            current.push(candidates[i]);
            backtrack(i,current,remaining - candidates[i]);
            current.pop();
        }
    }
}
