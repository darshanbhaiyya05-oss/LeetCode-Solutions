class WordDictionary {
    class Node{
        Node child[] = new Node[26];
        boolean eow=false;
        Node(){
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            curr=curr.child[idx];
        }
        curr.eow=true;
    }
    
    public boolean search(String word) {
        return helper(root , word , 0);
    }

    boolean helper(Node curr , String word , int idx){
        if(idx==word.length()) return curr.eow;

        char ch=word.charAt(idx);
        if(ch != '.'){
            int curr_idx=ch-'a';
            if(curr.child[curr_idx]==null){
                return false;
            }
            return helper(curr.child[curr_idx],word,idx+1);
        }

        for(int i=0;i<26;i++){
            if(curr.child[i]!=null){
                if(helper(curr.child[i],word,idx+1)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */