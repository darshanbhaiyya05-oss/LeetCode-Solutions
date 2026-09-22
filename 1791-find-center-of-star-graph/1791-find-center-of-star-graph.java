class Solution {
    public int findCenter(int[][] edges) {
        int first=edges[0][0];
        int sec=edges[0][1];

        if(first==edges[1][0] || first==edges[1][1]){
            return first;
        }else{
            return sec;
        }
    }
}