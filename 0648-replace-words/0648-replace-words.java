class Solution {
    class Node {
        Node child[] = new Node[26];
        boolean eow = false;
    }

    Node root = new Node();

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary) {
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String word : words) {

            if (ans.length() > 0) {
                ans.append(" ");
            }
            ans.append(findRoot(word));
        }
        return ans.toString();
    }

    void insert(String s){
        Node curr=root;
        for(int level=0;level<s.length();level++){
            int idx=s.charAt(level)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            curr=curr.child[idx];
        }
        curr.eow=true;
    }

    String findRoot(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.child[index] == null) {
                return word;
            }
            curr = curr.child[index];
            if (curr.eow) {
                return word.substring(0, i + 1);
            }
        }
        return word;
    }
}