class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int a : nums1){
            for(int b : nums2){
                int sum=a+b;

                if(map.containsKey(sum)){
                    map.put(sum , map.get(sum)+1);
                }else{
                    map.put(sum , 1);
                }
            }
        }

        int ans=0;
        for(int c:nums3){
            for(int d:nums4){
                int sum=c+d;
                int target = -sum;
                if(map.containsKey(target)){
                    ans+=map.get(target);
                }
            }
        }
        return ans;
    }
}