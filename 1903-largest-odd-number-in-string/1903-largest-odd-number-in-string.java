class Solution {
    public String largestOddNumber(String num) {
        char[] ch=new char[num.length()];
        
        for(int i=0;i<ch.length;i++){
            ch[i]=num.charAt(i);
        }

        int idx=-1;
        for(int i=ch.length-1;i>=0;i--){
            if((ch[i]-'0')%2!=0){
                idx=i;
                break;
            }
        }

        if(idx==-1){
            return "";
        }
         
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=idx;i++){
            sb.append(ch[i]);
        }

        return sb.toString();
    }
}