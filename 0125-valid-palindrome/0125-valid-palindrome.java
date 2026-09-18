class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()<2){
            return true;
        }

        int pt1=0;
        int pt2=s.length()-1;

        while(pt2 >= pt1){
            char ch1=s.charAt(pt1);
            char ch2=s.charAt(pt2);

            ch1 = Character.toLowerCase(ch1);
            ch2 = Character.toLowerCase(ch2);

            if(!('a'<=ch1 && ch1<='z') && !(ch1>='0' && ch1<='9')){
                pt1++;
                continue;
            }
            if(!('a'<=ch2 && ch2<='z') && !(ch2>='0' && ch2<='9')){
                pt2--;
                continue;
            }
            if(ch1==ch2) {
                pt1++;
                pt2--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}