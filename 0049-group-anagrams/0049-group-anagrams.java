class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if (visited[i]) {
                continue;
            }
            String word=strs[i];
            List<String> res=new ArrayList<>();
            res.add(word);
            visited[i] = true;
            for(int j=i;j<strs.length ; j++){
                if(!visited[j] && alagram(word,strs[j])){
                    res.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(res);
        }
        return ans;
    }
    boolean alagram(String s , String t){
        HashMap<Character , Integer> map=new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
}