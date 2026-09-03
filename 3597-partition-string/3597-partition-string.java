class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {
            String temp = "";

            while (i < s.length()) {
                temp += s.charAt(i);

                if (!set.contains(temp)) {
                    set.add(temp);
                    ans.add(temp);
                    i++;
                    break;
                }

                i++;
            }
        }

        return ans;
    }
}