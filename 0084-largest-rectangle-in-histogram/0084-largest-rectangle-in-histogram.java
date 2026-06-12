class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea=0;
        int[] NSR=new int[heights.length];
        int[] NSL=new int[heights.length];
        // NSR 
        Stack<Integer> s=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                NSR[i]=heights.length;
            }
            else{
                NSR[i]=s.peek();
            }
            s.push(i);
        }
        // NSL
        Stack<Integer> st=new Stack<>();
        for(int  i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                NSL[i]=-1;
            }
            else{
                NSL[i]=st.peek();
            }
            st.push(i);
        }
        // AREA
        // width=nsr-nsl-1;
        for(int i=0;i<heights.length;i++){
            int height=heights[i];
            int width=NSR[i]-NSL[i]-1;
            int curr=height*width;
            maxarea=Math.max(maxarea , curr);
        }
        return maxarea;
    }
}