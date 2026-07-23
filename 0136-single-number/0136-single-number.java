class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        int n=nums.length;
        if(n<2){
            return nums[0];
        }
        else{
            for(int i=0;i<n;i++){
                ans=nums[i]^ans;    // same number XOR is zero
            }
            return ans;
        }
    }
}