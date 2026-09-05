
class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            int m = s.length();
            for (int len = 1; len <= m; len++) {
                String best = "";
                for (int start = 0; start + len <= m; start++) {
                    String sub = s.substring(start, start + len);
                    boolean unique = true;
                    for (int j = 0; j < n; j++) {
                        if (i == j)
                            continue;
                        if (arr[j].contains(sub)) {
                            unique = false;
                            break;
                        }
                    }
                    if (unique) {
                        if (best.equals("") || sub.compareTo(best) < 0) {
                            best = sub;
                        }
                    }
                }
                if (!best.equals("")) {
                    ans[i] = best;
                    break;
                }
            }
            if (ans[i] == null) {
                ans[i] = "";
            }
        }
        return ans;
    }
}
