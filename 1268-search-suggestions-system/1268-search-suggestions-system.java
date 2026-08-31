class Solution {
    class Node {
        Node[] child = new Node[26];
        List<String> words = new ArrayList<>();
    }
    Node root = new Node();
    public List<List<String>> suggestedProducts(
            String[] products, String searchWord) {
        Arrays.sort(products);
        // Build Trie
        for(String product : products) {
            Node curr = root;
            for(int i = 0; i < product.length(); i++) {
                int idx = product.charAt(i) - 'a';
                if(curr.child[idx] == null) {
                    curr.child[idx] = new Node();
                }
                curr = curr.child[idx];
                // Store only first 3
                if(curr.words.size() < 3) {
                    curr.words.add(product);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Node curr = root;
        for(int i = 0; i < searchWord.length(); i++) {
            int idx = searchWord.charAt(i) - 'a';
            if(curr != null && curr.child[idx] != null) {
                curr = curr.child[idx];
                ans.add(curr.words);
            } else {
                curr = null;
                ans.add(new ArrayList<>());
            }
        }
        return ans;
    }
}