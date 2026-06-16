class Solution {
    public String processStr(String s) {
        StringBuilder sb=new StringBuilder(s.length());
        int i=0;
        while( i<s.length()){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                sb.append(ch);
                
            }
            if(ch=='*'){
                if (sb.length() > 0) { 
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            if(ch=='#'){
                if (sb.length() > 0) {
                    sb.append(sb);
                }
            }
            if(ch=='%'){
                sb.reverse();
                
            }
            i++;
        }
        return sb.toString();
    }
}