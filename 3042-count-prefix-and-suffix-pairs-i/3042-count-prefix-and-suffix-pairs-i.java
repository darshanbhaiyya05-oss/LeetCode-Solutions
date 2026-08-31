class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefix(words[i],words[j]) && isSuffix(words[i],words[j])){
                    count++;
                }
            }
            
        }
        return count;
    }
    boolean isPrefix(String s , String t){
        if(t.length()<s.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i)){
                return false;
            }
        }
        return true;
    }

    boolean isSuffix(String s , String t){
        if(t.length()<s.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            int s_len=s.length();
            int t_len=t.length();
            if(s.charAt(i)!=t.charAt(t_len-s_len+i)){
                return false;
            }
        }
        return true;
    }
}