class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int landThenWater = calc(landStartTime, landDuration, waterStartTime, waterDuration);
        int waterThenLand = calc(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(landThenWater, waterThenLand);
    }

    private int calc(int[] firstStart, int[] firstDuration,
                     int[] secondStart, int[] secondDuration) {
        int minFirstEnd = Integer.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            minFirstEnd = Math.min(minFirstEnd, firstStart[i] + firstDuration[i]);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < secondStart.length; i++) {
            ans = Math.min(ans, Math.max(minFirstEnd, secondStart[i]) + secondDuration[i]);
        }

        return ans;
    }
}