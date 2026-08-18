class Solution {
    public boolean isPossible(int[] target) {
       PriorityQueue<Integer> pq =
            new PriorityQueue<>(Comparator.reverseOrder());

        long sum = 0;

        for(int i=0;i<target.length;i++){
            pq.add(target[i]);
            sum+=target[i];
        }

        while(pq.peek()!=1){
            int large=pq.remove();

            long rest=sum - large;

            if(rest<=0 || large<=rest){
                return false;
            }
            if(rest==1) return true;
            long prev=large % rest;

            if(prev==0) return false;

            pq.add((int)prev);

            sum= rest+prev;
        }
        return true;
    }
}