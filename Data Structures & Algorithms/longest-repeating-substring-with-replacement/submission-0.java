class Solution {
    public int characterReplacement(String s, int k) {
        //would replace characters that come after the longest subsequent string
        // in between subsequent substrings

        int l = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        char[] ch = s.toCharArray();
        int res = 0;
        for(int r=0;r<s.length();r++){
            freq[ch[r] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch[r] - 'A']);
            int windowSize = r - l + 1;
            if(windowSize - maxFreq > k){
                freq[ch[l] - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
