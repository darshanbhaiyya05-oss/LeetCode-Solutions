class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        for(int i=n/2-1 ; i>=0 ; i--){
            heapify(i,n,nums);
        }
        for(int i=n-1;i>0;i--){
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            heapify(0,i,nums);
        }
        return nums;
    }
    public void heapify(int idx , int size , int[] arr){
        int left=2*idx+1;
        int right=2*idx+2;
        int max=idx;
        if(left<size && arr[left]>arr[max]){
            max=left;
        }
        if(right<size && arr[right]>arr[max]){
            max=right;
        }
        if(max!=idx){
            int temp=arr[idx];
            arr[idx]=arr[max];
            arr[max]=temp;
            heapify(max , size , arr);
        }
    }
}