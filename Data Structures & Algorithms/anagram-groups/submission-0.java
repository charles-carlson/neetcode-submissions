class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(int i=0;i<s.length();i++){
                count[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        List<List<String>> output = new ArrayList<>();
        for(String key : map.keySet()){
            output.add(map.get(key));
        }
        return output;
    }
    
}
