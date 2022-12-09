class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor){
            return image;
        }
        backtrack(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    void backtrack(int[][] image, int sr, int sc, int newColor, int color){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color){
            return;
        }else{
            image[sr][sc] = newColor;
            
            backtrack(image, sr, sc+1, newColor, color);
            backtrack(image, sr+1, sc, newColor, color);
            backtrack(image, sr, sc-1, newColor, color);
            backtrack(image, sr-1, sc, newColor, color);
            
        }
    }
}