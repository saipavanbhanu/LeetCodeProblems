class Solution {
    Set<Integer> col, posDiag, negDiag;
    char[][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        col = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        board = new char[n][n];
        result = new ArrayList<>();
        init(n);
        backtrack(0, n);
        return result;
    }
    
    void backtrack(int row, int n){
        if(row == n){
            List<String> li = new ArrayList<>(n);
            for(int i = 0; i < n; i++){
                li.add(new String(board[i]));
            }
            result.add(li);
        }else{
            for(int cIndex = 0; cIndex < n; cIndex++){
                if(col.contains(cIndex) || negDiag.contains(row - cIndex) || posDiag.contains(row + cIndex)){
                    continue;
                }
                
                col.add(cIndex);
                negDiag.add(row - cIndex);
                posDiag.add(row + cIndex);
                board[row][cIndex] = 'Q';
                
                backtrack(row+1, n);
                
                col.remove(cIndex);
                negDiag.remove(row - cIndex);
                posDiag.remove(row + cIndex);
                board[row][cIndex] = '.';
            }
        }
    }
    
    void init(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
    }
    
}