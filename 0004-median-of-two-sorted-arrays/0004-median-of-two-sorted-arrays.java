class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        int k=0;
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
             if(nums1[i]< nums2[j]){
                arr[k]=nums1[i];
                k++;
                i++;
             }
             else {
                arr[k]=nums2[j];
                k++;
                j++;
             }
        }
        while(i<nums1.length){
            arr[k++]=nums1[i++];
        }
        while(j<nums2.length){
            arr[k++]=nums2[j++];
        }

        if(arr.length%2!=0){
            return arr[arr.length/2];
        }
        else{
            int mid=arr.length/2;
            int ans= arr[mid]+arr[mid-1];
            return ans/2.0;
        }
    }
}