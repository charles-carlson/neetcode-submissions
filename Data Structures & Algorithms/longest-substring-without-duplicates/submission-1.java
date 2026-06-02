class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        int l = 0;
        int res = 0;
        for(int r = 0;r<ch.length;r++){
            while (set.contains(ch[r])) {
                set.remove(ch[l]);
                l++;
            }
            set.add(ch[r]);
            res = Math.max(res, r - l + 1);         
        }
        return res;
    }
}
