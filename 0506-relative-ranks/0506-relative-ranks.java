class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] ans=new String[n];

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            pq.add(score[i]);
        }
        int rank=1;


        while(!pq.isEmpty()){
            int val=pq.remove();

            for(int i=0;i<n;i++){
                if(score[i]==val){
                    if(rank==1){
                        ans[i]="Gold Medal";
                    }
                    else if(rank==2){
                        ans[i]="Silver Medal";
                    }
                    else if(rank==3){
                         ans[i] = "Bronze Medal";
                    }
                    else{
                        ans[i]=String.valueOf(rank);
                    }
                    break;
                }
            }
            rank++;
        }
        return ans;
    }
}