class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length && k>0;i++){
            if(nums[i]<0){
                nums[i]=-nums[i];
                k--;
            }
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length && k>0 ; i++){
           if(nums[i]==0 || k%2==0){
                k=0;
           }
           else{
                nums[i]=-nums[i];
                k--;
           }
        }


        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }
}