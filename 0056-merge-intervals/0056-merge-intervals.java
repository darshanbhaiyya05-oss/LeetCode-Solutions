class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b)->a[0]-b[0]);

        int[][] ans = new int[intervals.length][intervals[0].length];

        int n=intervals.length;
        int idx=0;
        int i=0;
        while(i<n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j=i+1;
            while(j<n && intervals[j][0]<=end){
                end=Math.max(end,intervals[j][1]);
                j++;
            }
            ans[idx][0]=start;
            ans[idx][1]=end;
            idx++;
            i=j;
        }
        return Arrays.copyOf(ans, idx);
    }
}