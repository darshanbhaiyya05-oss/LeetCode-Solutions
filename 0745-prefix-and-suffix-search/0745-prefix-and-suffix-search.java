class WordFilter {
    class Node {
        Node[] child = new Node[27];
        int index = -1;
    }
    Node root = new Node();
    public WordFilter(String[] words) {
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(i) + "#" + word;
                insert(key, index);
            }
        }
    }

    private void insert(String key, int index) {
        Node curr = root;
        for (char ch : key.toCharArray()) {
            int idx;
            if (ch == '#') {
                idx = 26;
            } else {
                idx = ch - 'a';
            }
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
            curr.index = index;
        }
    }

    public int f(String pref, String suff) {
        String key = suff + "#" + pref;
        Node curr = root;
        for (char ch : key.toCharArray()) {
            int idx;
            if (ch == '#') {
                idx = 26;
            } else {
                idx = ch - 'a';
            }
            if (curr.child[idx] == null) {
                return -1;
            }
            curr = curr.child[idx];
        }
        return curr.index;
    }
}