class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int node  , int dist){
            this.node=node;
            this.dist=dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            graph.get(u).add(new Pair(v,w));
        }

        int[] dist=new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[k]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>();

        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr=pq.remove();

            int node=curr.node;
            int currdist=curr.dist;

            if(currdist > dist[node]){
                continue;
            }

            for(Pair next : graph.get(node)){
                int nextnode=next.node;
                int wt=next.dist;

                int newdist=wt+currdist;

                if(newdist < dist[nextnode]){
                    dist[nextnode]=newdist;
                    pq.add(new Pair(nextnode,newdist));
                }
            }
        }

        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans , dist[i]);
        }

        return ans;
    }
}