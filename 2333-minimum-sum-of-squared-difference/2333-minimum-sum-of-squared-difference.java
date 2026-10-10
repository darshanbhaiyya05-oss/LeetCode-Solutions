class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        // int[] diff=new int[nums1.length];

        // for(int i=0;i<nums1.length;i++){
        //     diff[i]=Math.abs(nums1[i]-nums2[i]);
        // }

        // long k=(long)k1+k2;
        // while(k>0){
        //     Arrays.sort(diff);
        //     int n = diff.length;
        //     if (diff[n - 1] > 0) {
        //         diff[n - 1]--;
        //     } else {
        //         break;
        //     }
        //     k--;
        // }

        // long ans=0;
        // for(int i=0;i<diff.length;i++){
        //     ans += (long) diff[i] * diff[i];
        // }

        // return ans;


        // int n=nums1.length;
        // long k=(long)k1+k2;
        // int[] diff=new int[n];

        // long sum=0;
        // int max=0;

        // for(int i=0;i<n;i++){
        //     diff[i]=Math.abs(nums1[i]-nums2[i]);
        //     sum+=diff[i];
        //     max=Math.max(max , diff[i]);
        // }

        // if(sum <= k){
        //     return 0;
        // }

        // int left=0 , right=max;

        // while (left < right) {
        //     int mid = left + (right - left) / 2;
        //     long operations = 0;

        //     for (int d : diff) {
        //         if (d > mid) {
        //             operations += d - mid;
        //         }
        //     }

        //     if (operations <= k) {
        //         right = mid;
        //     } else {
        //         left = mid + 1;
        //     }
        // }

        // long ans = 0;

        // for (int d : diff) {
        //     int reduced = Math.min(d, left);
        //     ans += (long) reduced * reduced;
        // }

        // long remaining = k;

        // for (int d : diff) {
        //     if (d > left) {
        //         remaining -= d - left;
        //     }
        // }

        // for (int d : diff) {
        //     if (remaining == 0) break;

        //     if (d >= left && left > 0) {
        //         ans -= (long) left * left
        //              - (long) (left - 1) * (left - 1);
        //         remaining--;
        //     }
        // }

        // return ans;

        // PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());

        // for (int i = 0; i < nums1.length; i++) {
        //     pq.add(Math.abs(nums1[i] - nums2[i]));
        // }

        // long k = (long) k1 + k2;

        // while (k > 0) {
        //     int max = pq.remove();

        //     if (max == 0) {
        //         pq.add(0);
        //         break;
        //     }

        //     pq.add(max - 1);
        //     k--;
        // }

        // long ans = 0;

        // while (!pq.isEmpty()) {
        //     long d = pq.remove();
        //     ans += d * d;
        // }

        // return ans;

                int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];

        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        int[] freq = new int[max + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = max; d > 0 && k > 0; d--) {
            if (freq[d] == 0) continue;

            long count = Math.min(k, freq[d]);
            freq[d] -= (int) count;
            freq[d - 1] += (int) count;
            k -= count;
        }

        long ans = 0;

        for (int d = 1; d < freq.length; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}