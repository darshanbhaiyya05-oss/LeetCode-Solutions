class Solution {
    public int maxArea(int[] height) {
        int max_water=Integer.MIN_VALUE;
        int lp=0;
        int rp=height.length-1;
        while(rp>lp){
           int h = Math.min(height[lp], height[rp]);
            int width = rp - lp;
            int water = h * width;
            max_water=Math.max(water,max_water);
            if(height[lp]<height[rp]){
                lp++;
            }
            else if(height[rp]<=height[lp]){
                rp--;
            }
        }
        return max_water;
    }
}