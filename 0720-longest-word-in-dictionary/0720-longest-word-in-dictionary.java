class Solution {
    class Node {
        Node[] child = new Node[26];
        boolean eow = false;
        Node() {
            for(int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }
    }
    Node root;
    String ans="";
    public String longestWord(String[] words) {
        root = new Node();
        for(String word : words) {
            Node curr = root;
            for(int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if(curr.child[idx] == null) {
                    curr.child[idx] = new Node();
                }
                curr = curr.child[idx];
            }
            curr.eow = true;
        }
        StringBuilder str = new StringBuilder();
        helper(root, str);
        return ans;
    }
    void helper(Node curr, StringBuilder sb) {
        if(curr == null) {
            return;
        }
        for(int i = 0; i < 26; i++) {
            if(curr.child[i] != null && curr.child[i].eow == true) {
                char ch = (char)(i + 'a');
                sb.append(ch);
                if(sb.length()>ans.length()){
                    ans=sb.toString();
                }
                helper(curr.child[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}