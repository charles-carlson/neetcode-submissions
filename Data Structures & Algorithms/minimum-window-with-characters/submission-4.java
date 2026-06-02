class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<t.length();i++){
            freq.merge(t.charAt(i),1,(oldVal, newVal) -> oldVal + newVal);
        }
        int l = 0;
        int windowSize = 0;
        int have = 0;
        int need = freq.size();
        int end = -1;
        int start = 0;
        int best = s.length();
        for(int r=0;r<s.length();r++){
            //if window contains at least the frequency of characters from t, update result and shrink until valid
            if (freq.containsKey(s.charAt(r))) {
                freq.merge(s.charAt(r),-1,(oldVal, newVal) -> oldVal + newVal);
                if(freq.get(s.charAt(r))==0){
                    have++;
                }
            }
            while(have == need){
                if(end == -1 || best > r - l + 1){
                    start = l;
                    end = r;
                    best = r - l + 1;
                }
                if(freq.containsKey(s.charAt(l))){
                    freq.merge(s.charAt(l), 1, (oldVal, newVal) -> oldVal + newVal);
                    if(freq.get(s.charAt(l)) > 0){
                        have--;
                    }
                }
                l++;
            }

        }
        if (end == -1) return "";
        return s.substring(start, end+1);
    }
}
