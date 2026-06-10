class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s= new Stack<>();

        for(int i=0 ; i<operations.length ; i++){
            String ch=operations[i];

            if(ch.equals("+")){
                int a=s.pop();
                int b=s.peek();

                int c=a+b;
                s.push(a);
                s.push(c);
            }else if(ch.equals("D")){
                s.push(2*s.peek());
            }else if(ch.equals("C")){
                s.pop();
            }else{
                s.push(Integer.parseInt(ch));
            }
        }
        int sum=0;
        while(!s.isEmpty()){
            sum+=s.pop();
        }

        return sum;
    }
}