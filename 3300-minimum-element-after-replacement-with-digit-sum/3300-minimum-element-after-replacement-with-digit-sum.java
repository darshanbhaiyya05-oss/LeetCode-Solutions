class Solution {
    public int digitsum(int num){
        int sum=0;
        while(num> 0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int[] ans=new int[nums.length];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            ans[i]=digitsum(nums[i]);
            min=Math.min(min , ans[i]);
        }
        return min;
       

    }
}