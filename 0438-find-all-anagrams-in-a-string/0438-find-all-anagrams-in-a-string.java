class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] freqP = new int[26];
        int[] freqWindow = new int[26];
        for (char ch : p.toCharArray()) {
            freqP[ch - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            freqWindow[s.charAt(right) - 'a']++;
            if (right - left + 1 > p.length()) {
                freqWindow[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == p.length()
                    && Arrays.equals(freqP, freqWindow)) {

                ans.add(left);
            }
        }

        return ans;
    }
}