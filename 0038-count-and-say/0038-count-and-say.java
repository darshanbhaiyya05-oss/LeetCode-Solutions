class Solution {
    public String countAndSay(int n) {
        String res="1";
        for(int x=1 ; x<n ; x++){
            StringBuilder str=new StringBuilder();
            int i=0;
            while(i<res.length()){
                char ch = res.charAt(i);
                int count=0;
                while(i<res.length() && res.charAt(i)==ch){
                    count++;
                    i++;
                }
                str.append(count);
                str.append(ch);
            }
            res=str.toString();
        }
        return res;
    }
}