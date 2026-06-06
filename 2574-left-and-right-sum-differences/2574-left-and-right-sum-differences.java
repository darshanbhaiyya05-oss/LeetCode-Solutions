class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftsum=new  int[nums.length];
        int[] rightsum=new int[nums.length];
        leftsum[0]=0;
        rightsum[nums.length-1]=0;
        int[] res=new int[nums.length];
        for(int i=1 ; i<nums.length ; i++){
            leftsum[i]=leftsum[i-1]+nums[i-1];
        }
        for(int j=nums.length-2; j>= 0 ; j--){
            rightsum[j]=rightsum[j+1]+nums[j+1];
        }

        for(int k=0;k<nums.length ; k++){
            res[k]=Math.abs(rightsum[k]-leftsum[k]);
        }
        return res;
    }
}