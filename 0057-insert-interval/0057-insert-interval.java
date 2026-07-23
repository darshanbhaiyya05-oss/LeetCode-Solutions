class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int[][] ans = new int[n + 1][2];

        int i = 0;
        int idx = 0;

        // Copy intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans[idx++] = intervals[i++];
        }

        // Merge overlaps
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add merged interval
        ans[idx++] = newInterval;

        // Copy remaining intervals
        while (i < n) {
            ans[idx++] = intervals[i++];
        }

        return Arrays.copyOf(ans, idx);
    }
}