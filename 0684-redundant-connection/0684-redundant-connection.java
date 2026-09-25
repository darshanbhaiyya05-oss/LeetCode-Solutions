class Solution {
    public int[] par;
    public int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans=new int[2];
        int n = edges.length;

        par = new int[n + 1];
        rank = new int[n + 1];

        init(n);
        for(int i=0;i<edges.length;i++){
            int parA=find(edges[i][0]);
            int parB=find(edges[i][1]);

            if(parA==parB){
                ans[0]=edges[i][0];
                ans[1]=edges[i][1];
            }else{
                union(parA , parB);
            }
        }
        return ans;
    }
    
    void init(int n){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }

    void union(int a  , int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }
}