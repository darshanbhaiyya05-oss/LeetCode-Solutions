class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=1+nums[i-1]){
                for(int no=nums[i-1]+1;no<nums[i];no++){
                    ans.add(no);
                }
            }
        }
        return ans;
    }
}