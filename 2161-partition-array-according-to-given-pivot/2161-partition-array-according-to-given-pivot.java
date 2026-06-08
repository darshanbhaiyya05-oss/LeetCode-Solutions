class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();
        List<Integer> more=new ArrayList<>();

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]<pivot){
                less.add(nums[i]);
            }else if(nums[i]==pivot){
                equal.add(nums[i]);
            }else{
                more.add(nums[i]);
            }
        }

        int res[]= new int[nums.length];
        int idx=0;
        for(int j=0;j<less.size() ; j++){
            res[idx++]=less.get(j);
        }
        for(int j=0;j<equal.size();j++){
            res[idx++]=equal.get(j);
        }
        for(int j=0;j<more.size();j++){
            res[idx++]=more.get(j);
        }
        return res;
    }
}