class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character , String> map=new HashMap<>();
        String[] words = s.split(" ");
        HashMap<String , Character> map2=new HashMap<>();
        if(pattern.length() != words.length) {
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String word=words[i];

            if(map.containsKey(ch) && !map.get(ch).equals(word)){
                return false;
            }
            if(map2.containsKey(word) && map2.get(word)!=ch){
                return false;
            }
            map.put(ch,word);
            map2.put(word,ch);
        }
        return true;
    }
}