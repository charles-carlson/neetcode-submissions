class Solution {
//65-90 is A-Z, 97-122 is a-z
//possibily delimiter by ascii code that is not in the range
//
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int len = s.length();
            sb.append(len);
            sb.append("-");         
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        //0 ,1 is 5#Hello5#World
        List<String> s = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int index = str.indexOf('-',i);
            int length = Integer.parseInt(str.substring(i,index));
            s.add(str.substring(index + 1, index + 1 + length));
            i = index + 1 + length;
        }
        return s;
    }
}
