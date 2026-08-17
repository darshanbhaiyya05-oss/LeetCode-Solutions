class Solution {
    public class Pair implements Comparable<Pair>{
        int[] point;
        int dist;
        public Pair(int[] point , int dist){
            this.point=point;
            this.dist=dist;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] res=new int[k][2];
        int row=points.length;
       
        PriorityQueue<Pair> pq=new PriorityQueue<>();
       
        int r=0 ;
        while(r < row){
            int x=points[r][0];
            int y=points[r][1];
            int dist= x*x + y*y;
            pq.add(new Pair(points[r],dist));
            r++;
        }
        for(int i=0;i<k;i++){
            res[i]=pq.peek().point;
            pq.remove();
        }
        return res;
    }
}