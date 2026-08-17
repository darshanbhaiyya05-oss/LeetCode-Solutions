class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<stones.length ; i++){
            pq.add(stones[i]);
        }

        while(pq.size() != 1){
            int first=pq.remove();
            int second=pq.remove();
            pq.add(Math.abs(first-second));
        }

        return pq.peek();
    }
}