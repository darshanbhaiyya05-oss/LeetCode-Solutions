class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> hs=new HashSet<>();

        for(int i=0;i<candyType.length;i++){
            hs.add(candyType[i]);
        }

        int len=candyType.length;
        int unilen=hs.size();

        if(unilen > len/2){
            return len/2;
        }else{
            return unilen;
        }
    }
}