class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans=1;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                hs.add(nums[i]);
            }
        }
        for(int i=0;i<hs.size();i++){
            if(hs.contains(ans)){
                ans+=1;
            }else{
                return ans;
            }
        }
        return ans;
    }
}