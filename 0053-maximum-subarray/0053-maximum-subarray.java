class Solution {
    public int maxSubArray(int[] nums) {
        long ms=Integer.MIN_VALUE;
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>ms){
                ms=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return (int)ms;
    }
}