class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character , Integer> map=new HashMap<>();

        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }

        for(int i=0;i<magazine.length();i++){
            char ch1=magazine.charAt(i);
            if(map.containsKey(ch1)){
                if(map.get(ch1)>1){
                    map.put(ch1,map.get(ch1)-1);
                }else{
                    map.remove(ch1);
                }
            }else{
                continue;
            }
        }

        return map.size()==0;
    }
}