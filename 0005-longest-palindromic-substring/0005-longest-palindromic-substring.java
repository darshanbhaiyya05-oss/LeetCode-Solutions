class Solution {
    public String longestPalindrome(String s) {

        String ans="";
        for(int i=0 ; i<s.length() ; i++){
            StringBuilder str=new StringBuilder();
            for(int j=i ; j<s.length() ; j++){
                str.append(s.charAt(j));
                if(isPal(str.toString())){
                    if (str.length() > ans.length()) {
                        ans = str.toString();
                    }
                }
            }
        }
        return ans;
    }
    public boolean isPal(String str){
        int st = 0;
        int lt = str.length() - 1;
        while (st < lt) {
            if (str.charAt(st) != str.charAt(lt)) {
                return false;
            }
            st++;
            lt--;
        }
        return true;
    }
}