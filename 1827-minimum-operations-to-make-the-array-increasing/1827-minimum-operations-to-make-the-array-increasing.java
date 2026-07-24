class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        int diff=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>=nums[i]){
                diff=nums[i-1]-nums[i];
                count+=diff+1;
                nums[i]=Math.max(nums[i-1]+1,nums[i]);
            }
        }
        return count;
    }
}