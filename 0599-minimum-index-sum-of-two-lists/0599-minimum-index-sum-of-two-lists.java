class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map1 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {

            String restaurant = list2[i];

            if (map1.containsKey(restaurant)) {

                int sum = map1.get(restaurant) + i;

                if (sum < min) {
                    min = sum;

                    // Found a better answer
                    ans.clear();
                    ans.add(restaurant);

                } else if (sum == min) {

                    // Another restaurant with same minimum
                    ans.add(restaurant);
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}