class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s=new Stack<>();
        int[] nextgreater = new int[nums.length];
        for(int idx=2*nums.length-1 ; idx>=0 ; idx--){
            int i=idx%nums.length;
            while(!s.isEmpty() && nums[s.peek()]<=nums[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextgreater[i]=-1;
            }else{
                nextgreater[i]=nums[s.peek()];
            }
            s.push(i);
        }
        return nextgreater;
    }
}