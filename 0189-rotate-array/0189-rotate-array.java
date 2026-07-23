class Solution {
    public void rotate(int[] nums, int k) {
        int n=k%nums.length;
        int SI=nums.length-n;
        int EI=nums.length-1;
        while(SI<EI){
            int temp=nums[SI];
            nums[SI]=nums[EI];
            nums[EI]=temp;
            SI++;
            EI--;
        }
        SI=0;
        EI=nums.length-n-1;
        while(SI<EI){
            int temp=nums[SI];
            nums[SI]=nums[EI];
            nums[EI]=temp;
            SI++;
            EI--;
        }
        SI=0;
        EI=nums.length-1;
        while(SI<EI){
            int temp=nums[SI];
            nums[SI]=nums[EI];
            nums[EI]=temp;
            SI++;
            EI--;
        }
		// for(int l=0;l<nums.length;l++) {
		// 	System.out.print(nums[l]+" ");
		// }
    }
}