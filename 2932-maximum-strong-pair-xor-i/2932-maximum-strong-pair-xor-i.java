class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int abs=Math.abs(nums[i]-nums[j]);
                int min=Math.min(nums[i],nums[j]);
                if(abs<=min){
                    int temp=nums[i]^nums[j];
                    xor=Math.max(xor , temp);
                }
            }
        }
        return xor;
    }
}