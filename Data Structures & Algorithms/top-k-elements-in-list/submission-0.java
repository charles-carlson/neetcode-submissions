class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] buckets = new ArrayList[n+1];
        Map<Integer,Integer> freq = new HashMap<>();
        for(Integer num : nums){
            freq.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int f = entry.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(entry.getKey());
        }
        List<Integer> bucketSort = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            if(buckets[i] != null){
                bucketSort.addAll(buckets[i]);
            }
        }
        List<Integer> output = new ArrayList<>();
        for(int w = bucketSort.size()-1;w>=bucketSort.size() - k;w--){
            output.add(bucketSort.get(w));
        }
        int[] arr = output.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}
