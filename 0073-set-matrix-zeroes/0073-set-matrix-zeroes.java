class Solution {
    public void setZeroes(int[][] m) {
        boolean rowFlag = false;
        for(int i = 0; i < m[0].length; i++){
            if(m[0][i] == 0){
                rowFlag = true;
                break;
            }
        }
        
        boolean colFlag = false;
        for(int i = 0; i < m.length; i++){
            if(m[i][0] == 0){
                colFlag = true;
                break;
            }
        }
        
        //use the 1st row and the 1st col as the extra space to set the zeros
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if(m[i][j] == 0){
                    m[0][j] = 0;
                    m[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m.length; i++){
            for(int j = 1; j < m[0].length; j++){
                if(m[0][j] == 0 || m[i][0] == 0){
                    m[i][j] = 0;
                }
            }
        }
        
        if(rowFlag == true){
            for(int i = 0; i < m[0].length; i++){
                m[0][i] = 0;
            }
        }
        
        if(colFlag == true){
            for(int i = 0; i < m.length; i++){
                m[i][0] = 0;
            }
        }
        
    }
}