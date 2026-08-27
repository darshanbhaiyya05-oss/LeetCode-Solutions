class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans=0;
        for(int i=0;i<points.length;i++){
            HashMap<Integer , Integer> map=new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i==j) continue;

                int dx=points[i][0]-points[j][0];
                int dy=points[i][1]-points[j][1];
                int dist = dx*dx + dy*dy;

                if(map.containsKey(dist)){
                    map.put(dist , map.get(dist)+1);
                }else{
                    map.put(dist , 1);
                }
            }
            for (int count : map.values()) {
                ans += count * (count - 1);
            }
        }
        return ans;
    }
}