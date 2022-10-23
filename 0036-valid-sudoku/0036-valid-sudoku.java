class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHash = new boolean[9][9];
        boolean[][] colHash = new boolean[9][9];
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                if(! (ch == '.') ){
                    if( rowHash[i][ch-'1'] == true){
                        return false;
                    }
                    rowHash[i][ch-'1'] = true;
                    
                    if( colHash[j][ch-'1'] == true){
                        return false;
                    }
                    colHash[j][ch-'1'] = true;
                }
            }
        }
        
        
        for(int i = 0; i <= 6; ){
            for(int j = 0; j <= 6; ){
                if(isValidBox(board, i, j)){
                    
                }else{
                    return false;
                }
                
                j = j + 3;
            }
            i = i + 3;
        }
        return true;
    }
    
    boolean isValidBox(char[][] board, int row, int col){
        boolean[] hash = new boolean[9];
        //System.out.println(row+","+col);
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                char ch = board[row+i][col+j];
                if( !(ch == '.')){
                    if(hash[ch-'1'] == true){
                        return false;
                    }
                    hash[ch-'1'] = true;
                }
            }
        }
        //System.out.println(Arrays.toString(hash));
        return true;
    }
}