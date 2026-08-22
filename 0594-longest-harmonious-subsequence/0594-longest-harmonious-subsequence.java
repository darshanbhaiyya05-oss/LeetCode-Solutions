class Solution {
    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, int[]> map = new HashMap<>();

        // Store first and last index
        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, i});
            } else {
                map.get(nums[i])[1] = i;
            }
        }

        int max = 0;

        for (int num : map.keySet()) {

            if (map.containsKey(num + 1)) {

                int start = map.get(num)[0];
                int end = map.get(num + 1)[1];

                max = Math.max(max, end - start + 1);
            }
        }

        return max;
    }
}