class Solution {

    // Heap Sort 
    // public int[] sortArray(int[] nums) {
    //     int n=nums.length;
    //     for(int i=n/2-1 ; i>=0 ; i--){
    //         heapify(i,n,nums);
    //     }
    //     for(int i=n-1;i>0;i--){
    //         int temp=nums[0];
    //         nums[0]=nums[i];
    //         nums[i]=temp;
    //         heapify(0,,nums);
    //     }
    //     return nums;
    // }

    // public void heapify(int idx, int size, int[] arr) {
    //     int left = 2 * idx + 1;
    //     int right = 2 * idx + 2;
    //     int max = idx;
    //     if (left < size && arr[left] > arr[max]) {
    //         max = left;
    //     }
    //     if (right < size && arr[right] > arr[max]) {
    //         max = right;
    //     }
    //     if (max != idx) {
    //         int temp = arr[idx];
    //         arr[idx] = arr[max];
    //         arr[max] = temp;
    //         heapify(max, size, arr);
    //     }
    // }

    // Merge Sort
    public int[] sortArray(int[] nums){
        mergesort(nums , 0 , nums.length-1);
        return nums;
    }
    public void mergesort(int[] nums , int st , int end){
        if(st>=end) return;

        int mid= st + (end-st)/2;

        //divide
        mergesort(nums , st , mid);
        mergesort(nums , mid+1 , end);

        //merge
        merge(nums , st , mid , end);
    }
    public void merge(int[] nums , int st , int mid , int end){
        int[] temp=new int[end-st+1];
        int i=st;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(nums[i]<nums[j]){
                temp[k]=nums[i];
                i++;
            }else{
                temp[k]=nums[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k]=nums[i];
            i++;
            k++;
        }
        while(j<=end){
            temp[k]=nums[j];
            j++;
            k++;
        }
        for (int x = 0; x < temp.length; x++) {
            nums[st + x] = temp[x];
        }
    }
}