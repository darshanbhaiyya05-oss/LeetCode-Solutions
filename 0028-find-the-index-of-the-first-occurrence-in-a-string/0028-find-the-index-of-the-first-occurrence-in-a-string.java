class Solution {
    public int strStr(String haystack, String needle) {
        int ans = haystack.length();
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            char ch = haystack.charAt(i);
            if (ch == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    char ch2 = needle.charAt(j);
                    char ch3 = haystack.charAt(i + j);
                    if (ch2 != ch3) {
                        break;  
                    }
                    if (j == needle.length() - 1) {
                        ans = Math.min(ans, i);
                    }
                }
            }
        }
        return ans == haystack.length() ? -1 : ans;
    }
}