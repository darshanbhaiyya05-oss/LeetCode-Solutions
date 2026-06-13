class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length;i++){
            boolean flag=false;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                nums[idx++]=nums[i];
            }
        }
        return idx;
    }
}