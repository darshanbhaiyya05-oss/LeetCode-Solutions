class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> map=new HashMap<>();

        for(int i=0;i<words.length;i++){
            String word=words[i];
            if(map.containsKey(word)){
                map.put(word , map.get(word)+1);
            }else{
                map.put(word , 1);
            }
        }

        List<String> ans = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            String bestWord = "";
            int freq = 0;
            for(String word : map.keySet()) {
                if(map.get(word) > freq) {
                    freq = map.get(word);
                    bestWord = word;
                } else if(map.get(word) == freq &&
                          word.compareTo(bestWord) < 0) {
                    bestWord = word;
                }
            }
            ans.add(bestWord);
            map.remove(bestWord);
        }
        return ans;
    }
}