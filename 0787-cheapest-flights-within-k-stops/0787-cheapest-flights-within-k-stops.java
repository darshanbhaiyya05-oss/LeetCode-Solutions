class Solution {
    class Edge{
        int src ;
        int dest;
        int cost;
        Edge(int s , int d , int c){
            this.src=s;
            this.dest=d;
            this.cost=c;
        }
    }
    class Info {
        int node;
        int cost;
        int stop;
        Info(int n , int c , int s){
            this.node=n;
            this.cost=c;
            this.stop=s;
        }
    }
    void create(int[][] flight , ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length ; i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<flight.length;i++){
            int src=flight[i][0];
            int dest=flight[i][1];
            int cost=flight[i][2];
            Edge e=new Edge(src , dest , cost);
            graph[src].add(e);
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[]=new ArrayList[n];
        create(flights , graph);
        int dis[]=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src, 0, 0));
        dis[src] = 0;
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stop > k){
                break;
            }
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.cost;
                if(dis[u] != Integer.MAX_VALUE  && curr.stop<=k && curr.cost+wt < dis[v]){
                    dis[v]=curr.cost+wt;
                    q.add(new Info(v , dis[v] , curr.stop+1));
                }
            }
        }
        if(dis[dst]==Integer.MAX_VALUE) return -1;
        return dis[dst];
    }
}