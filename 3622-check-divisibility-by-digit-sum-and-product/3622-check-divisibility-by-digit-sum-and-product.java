class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        //int num=0;
        int no=n;
        while(n>0){
            int num=n%10;
            sum+=num;
            product*=num;
            n/=10;
        }
        if(no%(sum+product
        )==0){
            return true;
        }
        else return false;
    }
}