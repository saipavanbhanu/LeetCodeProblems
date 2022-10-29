class Solution {
    public void solve(char[][] board) {
        int rows = board.length; int cols = board[0].length;
        for(int i = 0; i < cols; i++){
            if(board[0][i] == 'O'){
                dfs(0, i, board);
            }
        }
        
        for(int i = 1; i < rows; i++){
            if(board[i][cols-1] == 'O'){
                dfs(i, cols-1, board);
            }
        }
        
        for(int i = cols-2; i >= 0; i--){
            if(board[rows-1][i] == 'O'){
                dfs(rows-1, i, board);
            }
        }
        
        for(int i = rows-2; i >= 0; i--){
            if(board[i][0] == 'O'){
                dfs(i, 0, board);
            }
        }
        //iterate over the m/n matrix and change the values
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    void dfs(int r, int c, char[][] board){
        int pos[][] = { {-1,0}, {0,1}, {1,0}, {0,-1}};
        int rows = board.length; int cols = board[0].length;
        board[r][c] = 'T';
        for(int arr[] : pos ){
            int i = r + arr[0];
            int j = c + arr[1];
            if(i >= 0 && i < rows && j >= 0 && j < cols && board[i][j] == 'O'){
                dfs(i, j, board);
            }
        }
    }
    
}