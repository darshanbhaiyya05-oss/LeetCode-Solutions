class Solution {
    
    class Node {
        Node child[] = new Node[26];
        boolean eow = false;
    }

    Node root = new Node();
    int ans;

    public int minExtraChar(String s, String[] dictionary) {

        // Build Trie
        for (String word : dictionary) {

            Node curr = root;   // reset for every word

            for (int i = 0; i < word.length(); i++) {

                int idx = word.charAt(i) - 'a';

                if (curr.child[idx] == null) {
                    curr.child[idx] = new Node();
                }

                curr = curr.child[idx];
            }

            curr.eow = true;
        }

        ans = s.length();

        solve(s, 0, 0);

        return ans;
    }

    public void solve(String s, int idx, int extra) {

        // Reached end
        if (idx == s.length()) {
            ans = Math.min(ans, extra);
            return;
        }

        // Already worse than best answer
        if (extra >= ans) {
            return;
        }

        // Option 1: current character is extra
        solve(s, idx + 1, extra + 1);

        // Option 2: try dictionary words
        // starting from idx
        Node curr = root;

        for (int j = idx; j < s.length(); j++) {

            int c = s.charAt(j) - 'a';

            if (curr.child[c] == null) {
                break;
            }

            curr = curr.child[c];

            if (curr.eow) {
                solve(s, j + 1, extra);
            }
        }
    }
}