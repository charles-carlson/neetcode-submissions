class Solution {
    public boolean isPalindrome(String s) {
        String trim = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i=0;
        int j=trim.length()-1;
        while(i < j){
            System.out.println(trim.charAt(i));
            System.out.println(trim.charAt(j));
            if(trim.charAt(i) != trim.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
