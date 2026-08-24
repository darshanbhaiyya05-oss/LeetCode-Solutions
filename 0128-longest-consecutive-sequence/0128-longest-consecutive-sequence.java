class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        
        HashSet<Integer> set=new HashSet<>();
        for(int num : nums){
            set.add(num);
            
        }
        
        for(int num : set){
            if(!set.contains(num-1)){
                int curr=num;
                int count=1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                max=Math.max(max , count);
            }
        }
        return max;
    }
}