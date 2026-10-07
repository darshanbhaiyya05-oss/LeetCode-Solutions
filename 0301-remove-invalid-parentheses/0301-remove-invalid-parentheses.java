class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        Set<String> set=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean found=false;
        while(!q.isEmpty()){
            String curr=q.remove();
            if(isValid(curr)){
                res.add(curr);
                found=true;
            }
            if(found){
                continue;
            }
            for(int i=0;i<curr.length();i++){
                char ch=curr.charAt(i);
                if(ch!='(' && ch!=')'){
                    continue;
                }
                String next=curr.substring(0,i)+curr.substring(i+1);
                if(!set.contains(next)){
                    set.add(next);
                    q.add(next);
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        int balance=0;
        for(char c : s.toCharArray()){
            if(c=='('){
                balance++;
            }else if(c==')'){
                balance--;
            }
            if(balance<0){
                return false;
            }
        }
        return balance==0;
    }
}