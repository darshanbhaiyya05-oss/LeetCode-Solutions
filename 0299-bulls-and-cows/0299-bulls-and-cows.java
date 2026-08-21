class Solution {
    public String getHint(String secret, String guess) {
        int y=0;
        int x=0;
        
        
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<secret.length();i++){
            char ch1=secret.charAt(i);
            if(map.containsKey(ch1)){
                map.put(ch1 , map.get(ch1)+1);
            }else{
                map.put(ch1 , 1);
            }
        }

        for(int i = 0; i < guess.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                x++;
                map.put(secret.charAt(i), map.get(secret.charAt(i)) - 1);
            }
        }


        for(int i=0;i<guess.length();i++){
            if(secret.charAt(i) == guess.charAt(i)) {
                continue;
            }
            char ch = guess.charAt(i);

            if(map.getOrDefault(ch, 0)>0) {
                y++;
                map.put(ch, map.get(ch) - 1);
            }
        }

       String s= x + "A" + y + "B";

       return s;
        
    }
}