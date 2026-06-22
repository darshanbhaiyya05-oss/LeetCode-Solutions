class Solution {
    public int maxNumberOfBalloons(String text) {
        if(text.length()<7){
            return 0;
        }
        int count[]=new int[26];
        for(int i=0;i<text.length() ; i++){
            char ch=text.charAt(i);
            count[ch-'a']++;
        }

        return Math.min(
                Math.min(count['b'-'a'] , count['a'-'a']) ,
                    Math.min(Math.min(count['l'-'a']/2 , count['o'-'a']/2),
                    count['n'-'a'])
                );
    }
}