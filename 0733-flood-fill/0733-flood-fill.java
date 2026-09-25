class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis=new boolean[image.length][image[0].length];
        helper(image , sr , sc , color , vis , image[sr][sc]);
        return image;
    }
    public void helper(int[][] img , int sr , int sc , int color , boolean[][] vis , int orgColor){
        if(sr<0 || sc<0 || sr>=img.length || sc>=img[0].length || vis[sr][sc] || img[sr][sc]!=orgColor){
            return;
        }

        vis[sr][sc] = true;
        img[sr][sc]=color;
        //left
        helper(img , sr , sc-1 , color , vis , orgColor);
        //right
        helper(img , sr , sc+1 , color , vis , orgColor);
        //up
        helper(img , sr-1 , sc , color , vis , orgColor);
        //down
        helper(img , sr+1 , sc , color , vis , orgColor);
    }
}