class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character , Integer> map =new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch , map.get(ch)+1);
            }else{
                map.put(ch ,1);
            }
        }
        int ans=0;
        boolean odd=false;
        for (int count : map.values()) {
            if (count % 2 == 0) {
                ans += count;
            } else {
                ans += count - 1;
                odd = true;
            }
        }

        if (odd) {
            ans++;
        }

        return ans;
    }
}