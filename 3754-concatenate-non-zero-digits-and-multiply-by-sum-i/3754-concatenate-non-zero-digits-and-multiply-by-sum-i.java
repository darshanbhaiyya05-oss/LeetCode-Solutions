class Solution {
    public long sumAndMultiply(int n) {
        long num=0;
        int sum=0;
        int count=1;
        
        while(n!=0){
            int digit=n%10;
            if(digit!=0){
                sum+=digit;
                num=num*10+digit;
            }
            n=n/10;
        }
        long reverse=0;
        while(num!=0){
            long no=num % 10;
            reverse=reverse*10+no;
            num/=10;
        }
        return sum*reverse;
    }
}
