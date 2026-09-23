class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n];

        int pro=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected , vis , i);
                pro++;
            }
        }
        return pro;
    }

    public void dfs(int[][] isConnected , boolean[] vis , int curr){
        vis[curr]=true;

        for(int j=0;j<isConnected.length ; j++){
            if(isConnected[curr][j]==1 && !vis[j]){
                dfs(isConnected , vis , j);
            }
        }
    }
}