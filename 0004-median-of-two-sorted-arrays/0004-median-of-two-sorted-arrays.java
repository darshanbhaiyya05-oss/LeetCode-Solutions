class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] arr=new int[n+m];

        // for(int i=0 ; i<n ;i++){
        //     arr[i]=nums1[i];
        // }
        // for(int j=0 ; j<m ; j++){
        //     arr[n+j]=nums2[j];
        // }

        int num1=0;
        int num2=0;
        int i=0;
        while (i < n + m) {
            if (num1 == n) {
                arr[i++] = nums2[num2++];
            } else if (num2 == m) {
                arr[i++] = nums1[num1++];
            } else if (nums1[num1] < nums2[num2]) {
                arr[i++] = nums1[num1++];
            } else {
                arr[i++] = nums2[num2++];
            }
        }
        // Arrays.sort(arr);
        double ans=0;
        if(arr.length%2==0){
            ans= (double)(arr[arr.length/2] + arr[(arr.length/2)-1])/2;
        }else{
            ans = (double)arr[arr.length/2];
        }
        return ans;
    }
}