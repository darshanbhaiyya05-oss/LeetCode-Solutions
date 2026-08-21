class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(!hs.contains(n)) {
            hs.add(n);
            n = square(n);
            if(n == 1) {
                return true;
            }
        }
        return false;
    }
    public int square(int num){
        int ans=0;
        while(num>0){
            int unit=num%10;
            ans+=unit*unit;
            num=num/10;
        }
        return ans;
    }
}