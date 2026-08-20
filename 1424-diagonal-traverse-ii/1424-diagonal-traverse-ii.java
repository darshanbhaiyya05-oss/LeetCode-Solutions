class Solution {
    class Pair implements Comparable<Pair>{
        int i=0;
        int j=0;
        int sum=0;
        public Pair(int i , int j , int sum){
            this.i=i;
            this.j=j;
            this.sum=sum;
        }
        @Override
        public int compareTo(Pair p2){
            if (this.sum != p2.sum) {
                return this.sum - p2.sum;
            }

            return p2.i - this.i;
        } 
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int total=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                pq.add(new Pair(i,j,i+j));
                total++;
            }
        }

        int[] res=new int[total];

        for(int i=0;i<res.length;i++){
            Pair p = pq.remove();
            int row = p.i;
            int col = p.j;
            res[i]=nums.get(row).get(col);
        }
        return res;
        
    }
}